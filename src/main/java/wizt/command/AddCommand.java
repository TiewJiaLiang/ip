package wizt.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import wizt.storage.Storage;
import wizt.task.Deadline;
import wizt.task.Event;
import wizt.task.Task;
import wizt.task.TaskList;
import wizt.task.Todo;
import wizt.ui.Ui;
import wizt.ui.WizTException;


/**
 *  Represents commands that adds tasks into TasksList
 */
public class AddCommand extends Command {
    private static final String SEPARATOR = "\n -------------------------------------";
    private String input;

    public AddCommand() {
        super();
    }

    public AddCommand(String input1) {
        this.input = input1;
    }

    /**
     * Add corresponding task to tasklist based on command.
     * @param tasks
     * @param ui
     * @param storage
     * @throws WizTException
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {
        ArrayList<Task> tasklists = tasks.getTasksList();
        StringBuilder response = new StringBuilder();
        try {
            if (input.contains("todo")) {
                executeTodo(tasklists, response);
            } else if (input.contains("deadline")) {
                executeDeadline(tasklists, response);
            } else {
                if (input.contains("event")) {
                    executeEvent(tasklists, response);
                }
            }
        } catch (DateTimeParseException e) {
            response.append("Please enter a valid date in this format (dd/MM/yyyy HHmm)!");
        }
        return response.toString();
    }

    /**
     * Represents a Todo Command
     * @param al
     * @param response
     * @throws WizTException
     */
    public void executeTodo(ArrayList<Task>al, StringBuilder response) throws WizTException {
        try {
            String substr = input.substring("todo".length());
            if (substr.isEmpty()) {
                throw new WizTException("Hmm, Please enter a description!");
            }
            Task t = new Todo(substr);
            al.add(t);
            response.append("\n Got it Boss! I've added this task:")
                    .append("\n [T][ ]" + substr).append("\nNow you have " + al.size() + " tasks in the list.");
        } catch (WizTException e) {
            response.append("Hmm, Please enter a valid description!");
        }
    }

    /**
     * Represents a Deadline command
     * @param al
     * @param response
     * @throws WizTException
     */
    public void executeDeadline(ArrayList<Task>al, StringBuilder response) throws WizTException {
        try {
            String substr = input.substring("deadline".length());
            if (substr.isEmpty()) {
                throw new WizTException("Hmm, Please enter a deadline value!");
            }
            String[] as = substr.split(" /by ");
            System.out.println(as.length);
            if (as.length == 1) {
                throw new WizTException("Hmm, Please enter a deadline value!");
            }

            //format dd/MM/YYYY HHmm
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            LocalDateTime dt = LocalDateTime.parse(as[1], formatter);
            Task t = new Deadline(as[0], dt);
            al.add(t);
            response.append("\n Got it Boss! I've added this task:").append("\n [D][ ] ").append(as[0]).append(" (by: ")
                    .append(dt.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")))
                    .append(")").append("\n Now you have " + al.size() + " tasks in the list.");
        } catch (WizTException e) {
            response.append("Hmm, Please enter a valid description!");
        }
    }

    /**
     * Represents a Event command
     * @param al
     * @param response
     * @throws WizTException
     */
    public void executeEvent(ArrayList<Task>al, StringBuilder response) throws WizTException {
        try {
            String substr = input.substring("event".length());
            if (substr.isEmpty()) {
                throw new WizTException("Hmm, Please enter a time period!");
            }
            String[] as = substr.split(" /from");
            if (as.length == 1) {
                throw new WizTException("Hmm, Please enter a time period!");
            }
            String[] as2 = as[1].split(" /to");
            if (as2.length == 1) {
                throw new WizTException("Hmm, Please enter a time period!");
            }
            Task t = new Event(as[0] + " (from: " + as2[0] + " to: " + as2[1] + ")");
            al.add(t);
            response.append("\n Got it Boss! I've added this task:")
                    .append("\n [E][ ] " + as[0] + " (from: " + as2[0] + " to: " + as2[1] + ")")
                    .append("\n Now you have " + al.size() + " tasks in the list.");
        } catch (WizTException e) {
            response.append("Hmm, Please enter a valid description!");
        }
    }
}

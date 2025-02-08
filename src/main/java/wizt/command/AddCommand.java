package wizt.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    private String input1;

    public AddCommand() {
        super();
    }

    public AddCommand(String input1) {
        this.input1 = input1;
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
        ArrayList<Task> al = tasks.getTasksList();
        StringBuilder response = new StringBuilder();
        if (input1.contains("todo")) {

            String substr = input1.substring("todo".length());
            if (substr.isEmpty()) {
                throw new WizTException("Please enter a description!");
            }
            Task t = new Todo(substr);
            al.add(t);
            response.append("\n -------------------------------------")
                    .append("\n Got it. I've added this task:")
                    .append("\n [T][ ]" + substr)
                    .append("\nNow you have " + al.size() + " in the list.")
                    .append("\n -------------------------------------");


        } else if (input1.contains("deadline")) {
            String substr = input1.substring("deadline".length());
            if (substr.isEmpty()) {
                throw new WizTException("Please enter a deadline value!");
            }
            String[] as = substr.split(" /by ");


            //format dd/MM/YYYY HHmm
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HHmm");
            LocalDateTime dt = LocalDateTime.parse(as[1], formatter);
            Task t = new Deadline(as[0], dt);
            al.add(t);
            response.append("\n -------------------------------------")
                    .append("\n Got it. I've added this task:").append("\n [D][ ] ").append(as[0]).append(" (by: ")
                    .append(dt.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")))
                    .append(")")
                    .append("\n Now you have " + al.size() + " in the list.")
                    .append("\n -------------------------------------");
        } else {
            if (input1.contains("event")) {

                String substr = input1.substring("event".length());
                if (substr.isEmpty()) {
                    throw new WizTException("Please enter a time period!");
                }
                String[] as = substr.split(" /from");
                String[] as2 = as[1].split(" /to");

                Task t = new Event(as[0] + " (from: " + as2[0] + " to: " + as2[1] + ")");
                al.add(t);
                response.append("\n -------------------------------------")
                        .append("\n Got it. I've added this task:")
                        .append("\n [E][ ] " + as[0] + " (from: " + as2[0] + " to: " + as2[1] + ")")
                        .append("\n Now you have " + al.size() + " in the list.")
                        .append("\n -------------------------------------");
            }
        }
        return response.toString();
    }

}

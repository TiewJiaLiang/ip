package wizt.command;

import wizt.ui.Ui;
import wizt.ui.WizTException;
import wizt.task.*;
import wizt.storage.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    public void execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {
        ArrayList<Task> al = tasks.getTasksList();

        if (input1.contains("todo")) {

            String substr = input1.substring("todo".length());
            if (substr.isEmpty()) {
                throw new WizTException("Please enter a description!");
            }
            Task t = new Todo(substr);
            al.add(t);
            System.out.println("-------------------------------------");
            System.out.println("Got it. I've added this task:");
            System.out.println("[T][ ]" + substr);
            System.out.println("Now you have " + al.size() + " in the list.");
            System.out.println("-------------------------------------");


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
            System.out.println("-------------------------------------");
            System.out.println("Got it. I've added this task:");
            System.out.println("[D][ ] " + as[0] + " (by: " + dt.format(DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm")) + ")");

            System.out.println("Now you have " + al.size() + " in the list.");
            System.out.println("-------------------------------------");
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
                System.out.println("-------------------------------------");
                System.out.println("Got it. I've added this task:");
                System.out.println("[E][ ] " + as[0] + " (from: " + as2[0] + " to: " + as2[1] + ")");
                System.out.println("Now you have " + al.size() + " in the list.");
                System.out.println("-------------------------------------");
            }
        }
    }

}
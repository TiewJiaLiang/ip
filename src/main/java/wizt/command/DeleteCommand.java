package wizt.command;

import java.util.ArrayList;

import wizt.storage.Storage;
import wizt.task.Task;
import wizt.task.TaskList;
import wizt.ui.Ui;



/**
 *  Represents commands that adds deletes tasks from TasksList
 */

public class DeleteCommand extends Command {
    private String input1;
    public DeleteCommand() {
        super();
    }
    public DeleteCommand(String input1) {
        this.input1 = input1;
    }

    /**
     * Delete the task from tasklist
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        String[]split = input1.split(" ");
        int no = Integer.parseInt(split[1]);
        ArrayList<Task> al = tasks.getTasksList();
        System.out.println("-------------------------------------");
        System.out.println("Noted. I've removed this task:");
        System.out.println(al.get(no - 1).toString());
        al.remove(no - 1);

        System.out.println("Now you have " + al.size() + " in the list.");
        System.out.println("-------------------------------------");
    }
}

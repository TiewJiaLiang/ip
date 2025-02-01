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
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        String[]split = input1.split(" ");
        StringBuilder response = new StringBuilder();
        int no = Integer.parseInt(split[1]);
        ArrayList<Task> al = tasks.getTasksList();

        response.append("\n -------------------------------------")
                .append("\n Noted. I've removed this task:")
                .append(al.get(no - 1).toString());
        al.remove(no - 1);

        response.append("\n Now you have " + al.size() + " in the list.")
                .append("\n -------------------------------------");
        return response.toString();
    }

}

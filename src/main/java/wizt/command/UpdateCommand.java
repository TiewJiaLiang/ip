package wizt.command;

import java.util.ArrayList;

import wizt.storage.Storage;
import wizt.task.Task;
import wizt.task.TaskList;
import wizt.ui.Ui;


/**
 *  Represents commands that update tasks status into TasksList
 */

public class UpdateCommand extends Command {
    private String input1;
    public UpdateCommand() {
        super();
    }

    public UpdateCommand(String input1) {
        this.input1 = input1;
    }

    /**
     * Identify which update command user has inputted and mark accordingly
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> al = tasks.getTasksList();
        StringBuilder response = new StringBuilder();
        if (input1.contains("unmark")) {
            String[]split = input1.split(" ");

            int no = Integer.parseInt(split[1]);

            al.get(no - 1).unmarkAsDone();
            response.append("-------------------------------------")
                    .append("Ok, I've marked this task as not done yet:")
                    .append(al.get(no - 1).toString())
                    .append("-------------------------------------");
        } else {

            if (input1.contains("mark")) {
                String[]split = input1.split(" ");
                int no = Integer.parseInt(split[1]);
                al.get(no - 1).markAsDone();
                response.append("\n -------------------------------------")
                        .append("\n Nice! I've marked this task as done:")
                        .append(al.get(no - 1).toString())
                        .append("\n -------------------------------------");
            }

        }
        return response.toString();
    }
}

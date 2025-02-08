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
    private String input;
    private String assertMessage = "\n Invalid task number! Please choose a valid number from the task list.";
    public UpdateCommand() {
        super();
    }

    public UpdateCommand(String input1) {
        this.input = input1;
    }

    /**
     * Identify which update command user has inputted and mark accordingly
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder response = new StringBuilder();
        try {
            ArrayList<Task> tasklists = tasks.getTasksList();
            if (tasklists.isEmpty()) {
                response.append("\n You have no tasks in your list to update.");
                return response.toString();
            }
            if (input.contains("unmark")) {
                String[] split = input.split(" ");
                int no = Integer.parseInt(split[1]);
                assert no > 0 && no <= tasklists.size() : assertMessage;
                tasklists.get(no - 1).unmarkAsDone();
                response.append("Ok, I've marked this task as not done yet:")
                        .append(tasklists.get(no - 1).toString());

            } else {
                if (input.contains("mark")) {
                    String[] split = input.split(" ");
                    int no = Integer.parseInt(split[1]);
                    assert no > 0 && no <= tasklists.size() : assertMessage;
                    tasklists.get(no - 1).markAsDone();
                    response.append("\n Nice! I've marked this task as done:")
                            .append(tasklists.get(no - 1).toString());
                }

            }

        } catch (AssertionError e) {
            response.append(assertMessage);
        }
        return response.toString();
    }
}

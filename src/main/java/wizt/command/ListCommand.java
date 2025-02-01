package wizt.command;

import java.util.ArrayList;

import wizt.storage.Storage;
import wizt.task.Task;
import wizt.task.TaskList;
import wizt.ui.Ui;



/**
 *  Represents commands that list items in TasksList
 */
public class ListCommand extends Command {

    public ListCommand() {
        super();
    }

    /**
     * List all tasks in task list
     * @param tasks
     * @param ui
     * @param storage
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        StringBuilder response = new StringBuilder();
        response.append("\n Here are the tasks in your list: ");
        ArrayList<Task> al = tasks.getTasksList();
        for (int i = 0; i < al.size(); i++) {
            response.append("\n" + ( i + 1 ) + "." + al.get(i).toString());

        }
        return response.toString();
    }
}

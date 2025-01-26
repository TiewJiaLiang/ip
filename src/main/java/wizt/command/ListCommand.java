package wizt.command;

import wizt.ui.*;
import wizt.storage.*;
import wizt.task.*;
import java.util.ArrayList;
/**
 *  Represents commands that list items in TasksList
 */
public class ListCommand extends Command{

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
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        ArrayList<Task> al = tasks.getTasksList();
        for(int i = 0; i < al.size(); i++){
            System.out.println(i+1+"."+al.get(i).toString());

        }
    }
}

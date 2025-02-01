package wizt.command;

import java.util.ArrayList;

import wizt.storage.Storage;
import wizt.task.Task;
import wizt.task.TaskList;
import wizt.ui.Ui;



/**
 *  Represents commands that searches for tasks in program
 */
public class FindCommand extends Command {

    private String input1;
    public FindCommand() {
        super();
    }

    public FindCommand(String input1) {
        this.input1 = input1;
    }

    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {

        String[]split = input1.split(" ");
        StringBuilder response = new StringBuilder();
        String item = split[1];
        ArrayList<Task> al = new ArrayList<>();
        al = tasks.getTasksList();
        int count = 1;
        response.append("\n Here are the matching tasks in your list:");
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).toString().contains(item)) {
                response.append("\n" + count + "." + al.get(i).toString());
                count++;
            }
        }
        ui.showLine();


        return response.toString();
    }
}

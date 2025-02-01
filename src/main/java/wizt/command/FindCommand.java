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
    public void execute(TaskList tasks, Ui ui, Storage storage) {

        String[]split = input1.split(" ");
        String item = split[1];
        ArrayList<Task> al = new ArrayList<>();
        al = tasks.getTasksList();
        int count = 1;
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < al.size(); i++) {
            if (al.get(i).toString().contains(item)) {
                System.out.println(count + "." + al.get(i).toString());
                count++;
            }
        }
        ui.showLine();



    }
}

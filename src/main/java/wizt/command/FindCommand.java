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

<<<<<<< HEAD
        String[]split = input1.split(" ");
        if (split.length < 2) {
            return "Please provide a item to search for!";
        }
        StringBuilder response = new StringBuilder();
        String item = split[1];
        ArrayList<Task> tasklists = new ArrayList<>();
        tasklists = tasks.getTasksList();
        int count = 1;
        response.append("\n Here are the matching tasks in your list:");
        boolean isFound = false;
        for (Task tasklist : tasklists) {
            if (tasklist.toString().contains(item)) {
                response.append("\n" + count + "." + tasklist.toString());
                count++;
                isFound = true;
            }
        }
        if (!isFound) {
            response.append("\n No such item found");
        }
=======
        String[] split = input1.split(" ");
        if (split.length < 2) {
            return "Please provide an item to search for!";
        }

        StringBuilder response = new StringBuilder();
        String item = split[1];

        // Using stream to filter tasks and collect matching ones
        ArrayList<Task> matchingTasks = new ArrayList<>();

        tasks.getTasksList().stream()
                .filter(task -> task.toString().contains(item))
                .forEach(task -> matchingTasks.add(task));

        if (matchingTasks.isEmpty()) {
            response.append("\n No such item found");
        } else {
            response.append("\n Here are the matching tasks in your list:");
            for (int i = 0; i < matchingTasks.size(); i++) {
                response.append("\n" + (i + 1) + "." + matchingTasks.get(i).toString());
            }
        }

>>>>>>> branch-A-Streams
        return response.toString();
    }
}


import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList() {

    }
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasksList(){
        return tasks;
    }
}

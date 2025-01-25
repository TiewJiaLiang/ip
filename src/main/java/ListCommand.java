import java.util.ArrayList;

public class ListCommand extends Command{

    public ListCommand() {
        super();
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        System.out.println("Here are the tasks in your list:");
        ArrayList<Task> al = tasks.getTasksList();
        for(int i = 0; i < al.size(); i++){
            System.out.println(i+1+"."+al.get(i).toString());

        }
    }
}

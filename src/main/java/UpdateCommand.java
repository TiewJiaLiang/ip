import java.util.ArrayList;

public class UpdateCommand extends Command {
    private String input1;
    public UpdateCommand() {
        super();
    }

    public UpdateCommand(String input1) {
        this.input1 = input1;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ArrayList<Task> al = tasks.getTasksList();
        if(input1.contains("unmark")){
            String[]split = input1.split(" ");

            int no = Integer.parseInt(split[1]);

            al.get(no-1).unmarkAsDone();
            System.out.println("-------------------------------------");
            System.out.println("Ok, I've marked this task as not done yet:");
            System.out.println(al.get(no-1).toString());
            System.out.println("-------------------------------------");
        }else{

            if(input1.contains("mark")){
                String[]split = input1.split(" ");
                int no = Integer.parseInt(split[1]);
                al.get(no-1).markAsDone();
                System.out.println("-------------------------------------");
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(al.get(no-1).toString());
                System.out.println("-------------------------------------");
            }

        }
}
}

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExitCommand extends Command {

    public ExitCommand() {
        super();
    }
    @Override
    public boolean isExit() {

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------------");
        return true;
    }


}

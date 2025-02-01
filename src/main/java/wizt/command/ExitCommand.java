package wizt.command;


/**
 *  Represents commands that exit from program
 */
public class ExitCommand extends Command {

    public ExitCommand() {
        super();
    }

    /**
     * Set boolean isExit to true so program can exit
     * @return isExit
     */
    @Override
    public boolean isExit() {

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-------------------------------------");
        return true;
    }


}

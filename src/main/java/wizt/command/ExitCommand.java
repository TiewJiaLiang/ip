package wizt.command;

public class ExitCommand extends Command {
    /**
     *  Represents commands that exit from program
     */
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

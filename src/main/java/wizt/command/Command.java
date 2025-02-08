package wizt.command;



import wizt.storage.Storage;
import wizt.task.TaskList;
import wizt.ui.Ui;
import wizt.ui.WizTException;



/**
 *  Represents a base class for commands that users input into the program.
 *  Subclasses will implement specific commands like AddCommand, ExitCommand, etc.
 */
public class Command {
    public Command() {

    }

    public String execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {
        return "";
    }

    public boolean isExit() {
        return false;
    }
}

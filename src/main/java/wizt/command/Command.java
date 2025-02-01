package wizt.command;



import wizt.storage.Storage;
import wizt.task.TaskList;
import wizt.ui.Ui;
import wizt.ui.WizTException;



/**
 *  Represents any commands that user inputs into program
 */
public class Command {
    public Command() {

    }

    /*public void execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {

    }*/

    public String execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {
        return "";
    }

    public boolean isExit() {
        return false;
    }
}

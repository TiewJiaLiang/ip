package wizt.command;

import wizt.ui.Ui;
import wizt.ui.WizTException;
import wizt.storage.Storage;
import wizt.task.*;

/**
 *  Represents any commands that user inputs into program
 */
public class Command {
   public Command(){

   }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws WizTException {

    }
    public boolean isExit(){
        return false;
    }
}

package wizt.ui;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import wizt.parser.Parser;
import wizt.storage.Storage;
import wizt.task.*;
import wizt.command.*;
import wizt.ui.*;

//Tiew Jia Liang
//A0273239Y
/**
 *  Represents the main progam flow
 */
public class WizT {
    private TaskList tasks;
    private Ui ui;
    private Storage storage;

    public static void main(String[] args) throws WizTException {
        new WizT("wizt.txt").run();

}



    public WizT(String filename) throws WizTException{
        ui = new Ui();
        storage = new Storage(filename);
        try{
            tasks = new TaskList(storage.load());


        }catch(Exception e){
            ui.showLoadingError(e.getMessage());

            tasks = new TaskList();
        }



    }

    /**
     * The main program execution
     * @throws WizTException
     */
    public void run() throws WizTException{
        ui.showLine();
        ui.showWelcome();
        ui.showLine();
        String filename = "wizt.txt";

        boolean isExit = false;
        while(!isExit){

            try{
                String fullCommand = ui.readCommand();

                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);

                isExit = c.isExit();
                if(isExit){
                    writeToFile(filename,tasks.getTasksList());
                }

            }
            catch(WizTException e){
                ui.showError(e.getMessage());
            }catch(IndexOutOfBoundsException e){
                ui.showError("Please enter a wizt.task.Task number!");
            }

        }
    }

    /**
     * Write to hard disk
     * @param filename  file name of the tasklist
     * @param al Arraylist of all the tasks
     */
    public static void writeToFile(String filename, ArrayList<Task> al) {

        try {
            FileWriter fw = new FileWriter(filename);

            for (Task task : al) {

                fw.write(task.toString());
                fw.write("\n");
            }

            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }


}

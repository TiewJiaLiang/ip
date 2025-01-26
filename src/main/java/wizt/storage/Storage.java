package wizt.storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import wizt.task.*;
/**
 *  Represents the storage file where the user tasks are stored in hard disk
 */
public class Storage {
    private static String filename;

    /**
     * Create a file if does not exist
     * @param filename
     */
    public Storage(String filename) {
        Storage.filename = filename;
        File f = new File(filename);
        try {
            if (f.createNewFile()) {
                System.out.println("File dont exist!, created a new file wizt.txt!");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Load the tasks from file into Arraylist
     * @return all tasks in the task list
     * @throws FileNotFoundException
     */
    public ArrayList<Task> load() throws FileNotFoundException {


            File filename = new File(Storage.filename);
            Scanner s = new Scanner(filename);
            ArrayList<Task> al = new ArrayList<>();

            while (s.hasNext()) {
                String line = s.nextLine();

                if (line.contains("from")) {
                    line = line.substring(7);

                    String[] as = line.split("\\(from:");
                    String[] as2 = as[1].split("to:");

                    Task t = new Event(as[0].trim() + " (from: " + as2[0].trim() + " to: " + as2[1].trim());
                    al.add(t);
                } else {
                    if (line.contains("by")) {
                        line = line.substring(7);
                        String[] as = line.split("\\(by: ");
                        String[] datetime = as[1].split(" ");
                        String date = datetime[0];
                        String time = datetime[1];
                        LocalDateTime dt = LocalDateTime.parse(date);
                        Task t = new Deadline(as[0].trim(), dt);
                        al.add(t);
                    } else {
                        Task t = new Todo(line.substring(7).trim());

                        al.add(t);
                    }
                }

            }

            return al;


    }
}
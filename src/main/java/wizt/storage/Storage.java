package wizt.storage;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import wizt.task.Deadline;
import wizt.task.Event;
import wizt.task.Task;
import wizt.task.Todo;
/**
 *  Represents the storage file where the user tasks are stored in hard disk
 */

public class Storage {
    private String filename;

    /**
     * Create a file if does not exist
     * @param filename
     */
    public Storage(String filename) {
        this.filename = filename;
        File f = new File(filename);
        try {
            if (f.createNewFile()) {
                System.out.println("File dont exist!, created a new file wizt.txt!");

            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Load the tasks from file into Arraylist
     * @return all tasks in the task list
     * @throws FileNotFoundException
     */
    public ArrayList<Task> load() throws FileNotFoundException {
        File file = new File(this.filename);
        Scanner scanner = new Scanner(file);
        ArrayList<Task> tasklists = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.contains("from")) {
                parseFrom(line, tasklists);
            } else {
                if (line.contains("by")) {
                    parseBy(line, tasklists);
                } else {
                    parse(line, tasklists);
                }
            }
        }
        return tasklists;
    }

    /**
     * Represents a method to parse the from prefix
     * @param line
     * @param tasklists
     */
    public void parseFrom(String line, ArrayList<Task> tasklists) {
        line = line.substring(7);
        String[] as = line.split("\\(from:");
        String[] as2 = as[1].split("to:");
        Task t = new Event(as[0].trim() + " (from: " + as2[0].trim() + " to: " + as2[1].trim());
        if (line.substring(0 , 7).contains("X")) {
            t.markAsDone();
        }
        tasklists.add(t);
    }

    /**
     * Represents a method to parse by prefix
     * @param line
     * @param tasklists
     */
    public void parseBy(String line, ArrayList<Task> tasklists) {
        line = line.substring(7);
        String[] as = line.split("\\(by: ");
        String[] datetime = as[1].split(" ");
        String date = datetime[0];
        String time = datetime[1];
        LocalDateTime dt = LocalDateTime.parse(date);
        Task t = new Deadline(as[0].trim(), dt);
        if (line.substring(0 , 7).contains("X")) {
            t.markAsDone();
        }
        tasklists.add(t);
    }

    /**
     * Represents a methods to parse description
     * @param line
     * @param tasklists
     */
    public void parse(String line, ArrayList<Task> tasklists) {
        Task t = new Todo(line.substring(7).trim());
        if (line.substring(0 , 7).contains("X")) {
            t.markAsDone();
        }
        tasklists.add(t);
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Tiew Jia Liang
//A0273239Y 
public class WizT {
    public static void main(String[] args) throws WizTException {

        try{
        System.out.println("-------------------------------------");
        System.out.println("Hello! I'm WizT");
        String filename = "wizt.txt";
        ArrayList<Task> al = new ArrayList<>();
        readFromFile(filename, al);
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);

        String input1;

        boolean isexit = false;
        do {
            input1 = sc.nextLine();
            if(input1.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < al.size(); i++){
                    System.out.println(i+1+"."+al.get(i).toString());
                }
            }
            else{
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
                    else{


                        if(input1.contains("todo")){

                                String substr = input1.substring("todo".length());
                                if(substr.isEmpty()){
                                    throw new WizTException("Please enter a description!");
                                }
                                Task t = new Todo(substr);
                                al.add(t);
                                System.out.println("-------------------------------------");
                                System.out.println("Got it. I've added this task:");
                                System.out.println("[T][ ]" + substr);
                                System.out.println("Now you have " + al.size() + " in the list.");
                                System.out.println("-------------------------------------");


                        }else{
                            if(input1.contains("deadline")){
                                String substr = input1.substring("deadline".length());
                                if(substr.isEmpty()){
                                    throw new WizTException("Please enter a deadline value!");
                                }
                                String[] as = substr.split(" /by");

                                Task t = new Deadline(as[0],as[1]);
                                al.add(t);
                                System.out.println("-------------------------------------");
                                System.out.println("Got it. I've added this task:");
                                System.out.println("[D][ ] "+as[0]+" (by: "+as[1]+")");
                                System.out.println("Now you have "+al.size()+ " in the list.");
                                System.out.println("-------------------------------------");
                            }else{
                                if(input1.contains("event")){

                                    String substr = input1.substring("event".length());
                                    if(substr.isEmpty()){
                                        throw new WizTException("Please enter a time period!");
                                    }
                                    String[] as = substr.split(" /from");
                                    String[] as2= as[1].split(" /to");

                                    Task t = new Event(as[0]+" (from: " +as2[0]+ " to: "+as2[1]+")");
                                    al.add(t);
                                    System.out.println("-------------------------------------");
                                    System.out.println("Got it. I've added this task:");
                                    System.out.println("[E][ ] "+as[0]+" (from: " +as2[0]+ " to: "+as2[1]+")");
                                    System.out.println("Now you have "+al.size()+ " in the list.");
                                    System.out.println("-------------------------------------");
                                }else{
                                    if(input1.contains("delete")){
                                        String[]split = input1.split(" ");
                                        int no = Integer.parseInt(split[1]);

                                        System.out.println("-------------------------------------");
                                        System.out.println("Noted. I've removed this task:");
                                        System.out.println(al.get(no-1).toString());
                                        al.remove(no-1);

                                        System.out.println("Now you have "+al.size()+ " in the list.");
                                        System.out.println("-------------------------------------");

                                    }else{
                                        if(input1.equals("bye")){
                                            writeToFile(filename,al);
                                            System.out.println("Bye. Hope to see you again soon!");
                                            System.out.println("-------------------------------------");
                                            isexit=true;
                                        }else{
                                            throw new WizTException("Sorry, I have no idea what this means.. Please enter either todo [desc], mark [number], unmark [number], list, deadline [desc][by date], event [desc][time period], delete [number] ");
                                        }

                                    }

                                }
                            }
                        }

                    }

                }
            }

        }while(!isexit);





    }
    catch(WizTException e){
            System.out.println(e.getMessage());


    } catch(IndexOutOfBoundsException e){

            System.out.println("Please enter a Task number!");
        }

}

    public static void readFromFile(String filename, ArrayList<Task> al) {
        File f = new File(filename);
        try {
            if (f.createNewFile()) {
                System.out.println("File dont exist!, created a new file wizt.txt!");

            } else {
                Scanner s = new Scanner(f);
                System.out.println("Here are you tasks:");
                while (s.hasNext()) {
                    String line = s.nextLine();
                    System.out.println(line);
                    if(line.contains("from")){
                        line = line.substring(7);
                        String[] as = line.split("\\(from:");
                        String[] as2= as[1].split("to:");

                        Task t = new Event(as[0].trim()+" (from: " +as2[0].trim()+ " to: "+as2[1].trim());
                        al.add(t);
                    }else{
                        if(line.contains("by")){
                            line = line.substring(7);
                            String[] as = line.split("\\(by: ");

                            Task t = new Deadline(as[0].trim(),as[1].substring(0,as[1].length()-1));
                            al.add(t);
                        }else{
                            Task t = new Todo(line.substring(7));
                            al.add(t);
                        }
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static void writeToFile(String filename, ArrayList<Task> al) {

    try {
        FileWriter fw = new FileWriter(filename);

        for (Task task : al) {
            fw.write(task.toString());
            fw.write("\n");
        }

        fw.close();
    } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    }

    /*public static void updateToFile(String filename, String text, String action) {
        try{
            Scanner sc = new Scanner(new File(filename));
            while(sc.hasNext()){
                String line = sc.nextLine();
                if(line.equals(text)){
                    switch(action){
                    case "delete":
                        System.out.println("Task deleted!");
                        break;
                    case "mark":
                        System.out.println("Task marked as done!");
                        break;
                    case "unmark":
                        System.out.println("Task marked as not done!");
                        break;
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

*/

}

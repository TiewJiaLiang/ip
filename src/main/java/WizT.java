import java.util.ArrayList;
import java.util.Scanner;


public class WizT {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Hello! I'm WizT");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);
        String input1;
        ArrayList<Task> al = new ArrayList<>();

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
                            String substr = input1.substring("todo ".length());
                            Task t = new Todo(substr);
                            al.add(t);
                            System.out.println("-------------------------------------");
                            System.out.println("Got it. I've added this task:");
                            System.out.println("[T][ ]"+substr);
                            System.out.println("Now you have "+al.size()+ " in the list.");
                            System.out.println("-------------------------------------");
                        }else{
                            if(input1.contains("deadline")){
                                String substr = input1.substring("deadline ".length());
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

                                    String substr = input1.substring("event ".length());
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

                                }
                            }
                        }

                    }

                }
            }

        }while(!input1.equals("bye"));

            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("-------------------------------------");


    }
}

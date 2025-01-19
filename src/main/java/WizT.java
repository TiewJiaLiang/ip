import java.util.ArrayList;
import java.util.Scanner;


public class WizT {
    public static void main(String[] args) throws WizTException {

        try{
        System.out.println("-------------------------------------");
        System.out.println("Hello! I'm WizT");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);
        String input1;
        ArrayList<Task> al = new ArrayList<>();
        boolean exit = false;
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
                                            System.out.println("Bye. Hope to see you again soon!");
                                            System.out.println("-------------------------------------");
                                            exit=true;
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

        }while(!exit);





    }
    catch(WizTException e){
            System.out.println(e.getMessage());


    } catch(IndexOutOfBoundsException e){

            System.out.println("Please enter a Task number!");
        }
}}

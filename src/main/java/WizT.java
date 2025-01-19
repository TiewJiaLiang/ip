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
                    System.out.println(i+1+"."+al.get(i).getStatus());
                }
            }
            else{
                if(input1.contains("unmark")){
                    String[]split = input1.split(" ");
                    int no = Integer.parseInt(split[1]);
                    al.get(no-1).unmarkAsDone();
                    System.out.println("-------------------------------------");
                    System.out.println("Ok, I've marked this task as not done yet:");
                    System.out.println(al.get(no-1).getStatus());
                    System.out.println("-------------------------------------");
                }else{

                    if(input1.contains("mark")){
                        String[]split = input1.split(" ");
                        int no = Integer.parseInt(split[1]);
                        al.get(no-1).markAsDone();
                        System.out.println("-------------------------------------");
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(al.get(no-1).getStatus());
                        System.out.println("-------------------------------------");
                    }else{

                        System.out.println("-------------------------------------");

                        Task t = new Task(input1);
                        al.add(t);
                        System.out.println("added: " + input1);
                        System.out.println("-------------------------------------");
                    }

                }
            }

        }while(!input1.equals("bye"));

            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("-------------------------------------");


    }
}

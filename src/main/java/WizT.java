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
        ArrayList<String> al = new ArrayList<>();

        do {
            input1 = sc.nextLine();
            if(input1.equals("list")){
                for(int i = 0; i < al.size(); i++){
                    System.out.println(i+1+". "+al.get(i));
                }
            }
            else{
                System.out.println("-------------------------------------");
                al.add(input1);
                System.out.println("added: " + input1);
                System.out.println("-------------------------------------");
            }

        }while(!input1.equals("bye"));

            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("-------------------------------------");


    }
}

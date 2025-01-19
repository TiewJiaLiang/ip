import java.util.Scanner;

public class WizT {
    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Hello! I'm WizT");
        System.out.println("What can I do for you?");
        System.out.println("-------------------------------------");
        Scanner sc = new Scanner(System.in);
        String input1;

        do {
            input1 = sc.nextLine();
            System.out.println("-------------------------------------");
            System.out.println(input1);
            System.out.println("-------------------------------------");
        }while(!input1.equals("bye"));

            System.out.println("Bye. Hope to see you again soon!");
            System.out.println("-------------------------------------");


    }
}

package wizt.ui;

import java.util.Scanner;

public class Ui {


   public String readCommand(){
       Scanner scanner = new Scanner(System.in);

       return scanner.nextLine();
   }
    public void showWelcome(){

        System.out.println("Hello! I'm wizt.ui.WizT");
        System.out.println("What can I do for you?");

    }
    public void showLoadingError(String error){
        System.out.println("Error: "+error);
    }
    public void showLine(){
        System.out.println("-------------------------------------");
    }
    public void showError(String error){
       System.out.println(error);
    }

}

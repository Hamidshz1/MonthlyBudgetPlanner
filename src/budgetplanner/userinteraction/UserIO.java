package budgetplanner.userinteraction;

import java.util.Scanner;

//  voglio usare la clase UserIo per gestire l'input e l'output dell'utente
public class UserIO {
    private Scanner scanner;
    
    
    
    

    public UserIO() {
        scanner = new Scanner(System.in);
    }

    public double getDoubleInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextDouble();
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextInt();
    }

    public String getStringInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.err.println(message);
    }
}
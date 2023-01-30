/**
 * 
 */
package invoicingSystem;

import java.util.Scanner;

/**
 * @author LAP-8
 *
 */
public class UserInputHandler {
     
	private Scanner userInput = new Scanner(System.in);

    public int getUserChoice() {
        Integer choice = null;
        while (choice == null) {
            System.out.println("Enter your choice: ");
            try {
                choice = Integer.parseInt(userInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return choice;
    }
    
    public String getUserChoiceString() {
        String choice = null;
        while (choice == null) {
            System.out.println("Enter your choice: ");
            choice = userInput.nextLine();
        }
        return choice;
    }
}

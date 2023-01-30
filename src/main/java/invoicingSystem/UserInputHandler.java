package invoicingSystem;

import java.util.Scanner;

/*
 * Description:
 * The UserInputHandler class is responsible for handling user inputs from the command line. 
 *  The class contains two methods: getUserChoice() and getUserChoiceString().
 */
public class UserInputHandler {

	private Scanner userInput = new Scanner(System.in);

	/**
	 * Input: None Output: Integer value Description: This method prompts the user
	 * to enter an integer value and returns the input as an integer. In case of an
	 * invalid input, it prompts the user to enter a valid integer.
	 * @return the input as an integer
	 */
	public int getUserChoice() {
		Integer choice = null;
		while (choice == null) {
			try {
				choice = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a valid integer.");
			}
		}
		return choice;
	}

	/**
	 * Input: None Output: String value Description: This method prompts the user to
	 * enter a string value and returns the input as a string.
	 * @return returns the input as a string
	 */

	public String getUserChoiceString() {
		String choice = null;
		while (choice == null) {
			choice = userInput.nextLine();
		}
		return choice;
	}
}

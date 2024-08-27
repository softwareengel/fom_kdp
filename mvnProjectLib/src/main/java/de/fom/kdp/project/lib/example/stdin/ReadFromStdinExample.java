package de.fom.kdp.project.lib.example.stdin;

import java.util.Scanner;

/**
 * In this example, we create an instance of the Scanner class with System.in as
 * the argument, which represents the standard input stream. We use the Scanner
 * object to read data from stdin.
 *
 * The nextLine() method is used to read a line of text input from the user, and
 * the nextInt() method is used to read an integer input from the user.
 *
 * After reading the input, we display the input values to the console.
 *
 * Finally, we close the Scanner object to release any resources associated with
 * it.
 *
 * You can run this code and enter a string and an integer when prompted, and
 * the program will display the entered values.
 *
 * @author engels
 *
 */
public class ReadFromStdinExample {
	/**
	 * The entry point of the application.
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String inputString = scanner.nextLine();
		System.out.println("You entered: " + inputString);

		System.out.print("Enter an integer: ");
		int inputInt = scanner.nextInt();
		System.out.println("You entered: " + inputInt);

		System.out.print("Enter an float: ");
		float inputfloat = scanner.nextFloat();
		System.out.println("You entered: " + inputfloat);

		scanner.close();
	}
}

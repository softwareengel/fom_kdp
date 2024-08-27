package de.fom.kdp.project.lib.stdin;

import java.util.Locale;
import java.util.Scanner;

/**
 * The {@code ConsoleReader} class provides methods to read different types of
 * data from the console.
 * <p>
 * The available methods allow you to read and return strings, integers, floats,
 * and doubles from the console. It also demonstrates how to handle locale
 * settings when reading decimal numbers.
 * </p>
 * 
 * @author engels
 */
public class ConsoleReader {

	/**
	 * Reads a string from the console.
	 * <p>
	 * This method prompts the user to enter a string and then reads the entire line
	 * of input.
	 * </p>
	 *
	 * @return the string entered by the user
	 */
	public static String readString() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter string: ");
			String inputString = scanner.nextLine();
			// System.out.println("You entered: " + inputString);
			return inputString;
		}
	}

	/**
	 * Reads an integer from the console.
	 * <p>
	 * This method prompts the user to enter an integer value and then reads the
	 * integer from the input.
	 * </p>
	 *
	 * @return the integer entered by the user
	 * @throws java.util.InputMismatchException if the input is not a valid integer
	 */
	public static int readInt() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter int: ");
			int inputInt = scanner.nextInt();
			return inputInt;
		}

	}

	/**
	 * Reads a float from the console with locale settings.
	 * <p>
	 * This method prompts the user to enter a float value. It demonstrates how to
	 * manage locale settings for decimal separators, ensuring the correct
	 * interpretation of the float value.
	 * </p>
	 *
	 * @return the float entered by the user
	 * @throws java.util.InputMismatchException if the input is not a valid float
	 */
	public static float readFloat() {
		try (Scanner scanner = new Scanner(System.in)) {
			// Get the current locale used by the Scanner object
			Locale currentLocale = scanner.locale();

			System.out.println("Current Scanner Locale: " + currentLocale);

			// Set the desired locale with the appropriate decimal separator
			scanner.useLocale(Locale.US);
			System.out.println("New Scanner Locale: " + scanner.locale());

			System.out.print("Enter float: ");
			float input = scanner.nextFloat();
			return input;
		}

	}

	/**
	 * Reads a double from the console with locale settings.
	 * <p>
	 * This method prompts the user to enter a double value. It demonstrates how to
	 * manage locale settings for decimal separators, ensuring the correct
	 * interpretation of the double value.
	 * </p>
	 *
	 * @return the double entered by the user
	 * @throws java.util.InputMismatchException if the input is not a valid double
	 */
	public static double readDouble() {

		try (Scanner scanner = new Scanner(System.in)) {
			// Get the current locale used by the Scanner object
			Locale currentLocale = scanner.locale();

			System.out.println("Current Scanner Locale: " + currentLocale);

			// Set the desired locale with the appropriate decimal separator
			scanner.useLocale(Locale.US);
			System.out.println("New Scanner Locale: " + scanner.locale());

			System.out.print("Enter double: ");
			double input = scanner.nextDouble();

			return input;
		}

	}

}

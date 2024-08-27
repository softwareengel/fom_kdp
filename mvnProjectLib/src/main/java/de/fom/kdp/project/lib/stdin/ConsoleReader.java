package de.fom.kdp.project.lib.stdin;

import java.util.Locale;
import java.util.Scanner;

/**
 * ConsoleReader reads Data from Console - readString - readInt - readFloat
 * 
 * @author engels
 *
 */
public class ConsoleReader {

	/**
	 * read string from console
	 *
	 * @return String with console input data
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
	 * read int from console
	 *
	 * @return int with console input data
	 */
	public static int readInt() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter int: ");
			int inputInt = scanner.nextInt();
			return inputInt;
		}

	}

	/**
	 * read float from console
	 * 
	 * @return float with console input data
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
	 * read double from console
	 * 
	 * @return double with console input data
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

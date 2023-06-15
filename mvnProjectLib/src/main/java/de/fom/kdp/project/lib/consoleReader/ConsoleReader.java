package de.fom.kdp.project.lib.consoleReader;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleReader {

	/**
	 * read string from console
	 *
	 * @return
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
	 * @return
	 */
	public static int readInt() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Enter int: ");
			int inputInt = scanner.nextInt();
			return inputInt;
		}

	}

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

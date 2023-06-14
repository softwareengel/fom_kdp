package de.fom.kdp.project.lib.examples.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this example, all three regex examples are combined into a single Java
 * file. Each example is preceded by a comment describing its purpose. The input
 * string remains the same ("Hello, World!") throughout the examples.
 * 
 * You can compile and run this Java file to see the output for each example.
 * Remember to import the necessary classes from the java.util.regex package
 * before running the code.
 * 
 * @author engels
 *
 */
public class RegexExample {
	public static void main(String[] args) {
		String input = "Hello, World!";

		// Example 1: Matching a Pattern
		Pattern pattern1 = Pattern.compile("Hello");
		Matcher matcher1 = pattern1.matcher(input);
		if (matcher1.find()) {
			System.out.println("Pattern found in the input.");
		} else {
			System.out.println("Pattern not found in the input.");
		}

		// Example 2: Extracting Substrings
		Pattern pattern2 = Pattern.compile(",\\s(\\w+)");
		Matcher matcher2 = pattern2.matcher(input);
		if (matcher2.find()) {
			String extracted = matcher2.group(1);
			System.out.println("Extracted substring: " + extracted);
		} else {
			System.out.println("Pattern not found in the input.");
		}

		// Example 3: Replacing Matches
		Pattern pattern3 = Pattern.compile("World");
		Matcher matcher3 = pattern3.matcher(input);
		String replaced = matcher3.replaceAll("Universe");
		System.out.println("Replaced string: " + replaced);
	}
}

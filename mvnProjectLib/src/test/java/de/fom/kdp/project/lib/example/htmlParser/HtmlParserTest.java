package de.fom.kdp.project.lib.example.htmlParser;

import org.junit.Test;

/**
 * Test class for {@link HtmlParser}.
 * <p>
 * This class contains a test method to verify that the main method of the
 * {@link HtmlParser} class executes without any exceptions.
 * </p>
 */
public class HtmlParserTest {
	/**
	 * Tests the {@link HtmlParser#main(String[])} method.
	 * <p>
	 * This method invokes the main method of {@link HtmlParser} with a null
	 * argument and verifies that no exceptions are thrown during its execution.
	 * </p>
	 */
	@Test
	public void testMain() {
		HtmlParser.main(null);
	}

	/**
	 * Tests the {@link HtmlParser#showHTMLTags(String)} method with a valid URL.
	 * <p>
	 * This method tests the extraction and display of HTML tags from a valid URL.
	 * It verifies that the method correctly processes the HTML content from the
	 * given URL ("https://heise.de") and outputs the HTML tags.
	 * </p>
	 */
	@Test
	public void testHTMLTags() {
		String url = "https://heise.de";
		HtmlParser.showHTMLTags(url);
	}

	/**
	 * Tests the {@link HtmlParser#showHTMLTags(String)} method with an invalid URL.
	 * <p>
	 * This method tests the behavior of the HTML tag extraction when provided with
	 * an invalid URL ("blablablakeineUrl"). It verifies that the method handles
	 * errors gracefully and does not cause the program to crash when processing an
	 * incorrect or malformed URL.
	 * </p>
	 */
	@Test
	public void testHTMLTagsError() {
		String url = "blablablakeineUrl";
		HtmlParser.showHTMLTags(url);
	}
}

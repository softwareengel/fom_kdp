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

	@Test
	public void testHTMLTags() {
		String url = "https://heise.de";
		HtmlParser.showHTMLTags(url);
	}
	
	@Test
	public void testHTMLTagsError() {
		String url = "blablablakeineUrl";
		HtmlParser.showHTMLTags(url);
	}
}

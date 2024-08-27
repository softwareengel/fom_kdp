package de.fom.kdp.project.lib.example.htmlParser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * This class demonstrates how to use the Jsoup library to parse and extract
 * elements from an HTML document.
 * <p>
 * The {@link HtmlParser} class fetches the HTML content from a specified URL
 * and extracts various elements, including:
 * <ul>
 * <li>Links (a tags with href attribute)</li>
 * <li>Images (img tags with src attribute)</li>
 * <li>Headings (h1, h2, h3 tags)</li>
 * <li>Page title</li>
 * <li>Meta description</li>
 * </ul>
 * The extracted information is then printed to the console.
 * <p>
 * This example serves as a basic template for more advanced HTML parsing
 * operations. It demonstrates how to use Jsoup's CSS selector syntax to find
 * and extract specific elements from an HTML document.
 * </p>
 * 
 * @author engels
 */
public class HtmlParser {
	/**
	 * The entry point of the application.
	 * <p>
	 * This method fetches the HTML content from a predefined URL and processes it
	 * to extract and print various elements.
	 * </p>
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {
		// Fetch the HTML content from a URL
		String url = "https://hackernews.com";

		showHTMLTags(url);
	}

	/**
	 * Extracts and displays specific HTML tags and metadata from the given URL.
	 * <p>
	 * This method connects to the specified URL using Jsoup, fetches the HTML
	 * content, and then extracts:
	 * <ul>
	 * <li>Links (anchor tags with href attribute)</li>
	 * <li>Images (img tags with src attribute)</li>
	 * <li>Headings (h1, h2, h3 tags)</li>
	 * <li>Page title</li>
	 * <li>Meta description</li>
	 * </ul>
	 * The extracted elements are printed to the console.
	 * <p>
	 * If an {@link IOException} or any other exception occurs during the process,
	 * it is caught and the stack trace is printed.
	 * </p>
	 * 
	 * @param url The URL of the HTML document to be fetched and parsed.
	 */
	public static void showHTMLTags(String url) {
		try {

			// using External Lib Jsoup
			Document document = Jsoup.connect(url).get();

			// Extract specific elements from the HTML
			Elements links = document.select("a[href]");
			Elements images = document.select("img[src]");
			Elements headings = document.select("h1, h2, h3");

			// Print out the extracted elements
			System.out.println("Links:");
			for (Element link : links) {
				System.out.println(link.attr("href"));
			}

			System.out.println("\nImages:");
			for (Element image : images) {
				System.out.println(image.attr("src"));
			}

			System.out.println("\nHeadings:");
			for (Element heading : headings) {
				System.out.println(heading.text());
			}

			// Extract the page title
			String title = document.title();
			System.out.println("\nPage Title: " + title);

			// Extract meta description
			Element metaDescription = document.selectFirst("meta[name=description]");
			if (metaDescription != null) {
				String description = metaDescription.attr("content");
				System.out.println("Meta Description: " + description);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// Other Exceptions
			// java.lang.IllegalArgumentException: The supplied URL, 'blablablakeineUrl', is
			// malformed. Make sure it is an absolute URL, and starts with 'http://' or
			// 'https://'. See https://jsoup.org/cookbook/extracting-data/working-with-urls
			// e.printStackTrace();
		}
	}
}

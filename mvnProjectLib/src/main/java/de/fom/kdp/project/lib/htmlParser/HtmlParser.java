package de.fom.kdp.project.lib.htmlParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * In this example, we added more parsing operations using Jsoup. Here's
 * what it does:
 * 
 * Fetches the HTML content from a specified URL using Jsoup.connect(url).get().
 * Extracts links (a tags with href attribute), images (img tags with src
 * attribute), and headings (h1, h2, h3 tags) using CSS selectors. Prints out
 * the extracted links, images, and headings. Extracts the page title using the
 * title() method of the Document object. Extracts the meta description by
 * selecting the first meta tag with name=description and retrieving the content
 * attribute.
 * 
 * Feel free to modify and expand this example to suit your specific parsing
 * needs.
 * 
 * @author engels
 *
 */
public class HtmlParser {
	public static void main(String[] args) {
		try {
			// Fetch the HTML content from a URL
			String url = "https://hackernews.com";
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
		}
	}
}

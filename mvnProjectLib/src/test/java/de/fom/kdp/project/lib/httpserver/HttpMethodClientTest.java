package de.fom.kdp.project.lib.httpserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link SimpleWebServerClient}.
 * <p>
 * This class contains test methods to verify the functionality of HTTP GET
 * requests made by the {@link SimpleWebServerClient}. Each test checks the
 * response from various URLs and ensures that the expected content is present
 * in the response.
 * </p>
 */
public class HttpMethodClientTest {
	/**
	 * Tests the HTTP GET request to "https://news.ycombinator.com/news".
	 * <p>
	 * This test verifies that the response from the server contains the expected
	 * content, specifically checking for the presence of the word "Hacker" in the
	 * response.
	 * </p>
	 * 
	 * @throws IOException if an I/O error occurs during the HTTP GET request.
	 */
	@Test
	public void testHttpGet() throws IOException {
		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("https://news.ycombinator.com/news"); // Status Code: 301, Moved
																							// Permanently to
		// https://www.heise.de/
		assertTrue(ret.contains("Hacker"));
	}

	/**
	 * Tests the HTTP GET request that results in a 301 Moved Permanently response.
	 * <p>
	 * This test sends a GET request to "http://heise.de:80/" and verifies that the
	 * response contains the status code "301", indicating a redirection.
	 * </p>
	 * 
	 * @throws IOException if an I/O error occurs during the HTTP GET request.
	 */
	@Test
	public void testHttpGet_http301() throws IOException {

		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("http://heise.de:80/"); // Status Code: 301, Moved Permanently to
																			// https://www.heise.de/
		assertTrue(ret.contains("301"));

	}

	/**
	 * Tests the HTTP GET request to an HTTPS URL.
	 * <p>
	 * This test verifies that the response from "https://www.heise.de:443/"
	 * contains the expected HTML meta description.
	 * </p>
	 * 
	 * @throws IOException if an I/O error occurs during the HTTP GET request.
	 */
	@Test
	public void testHttpGet_https() throws IOException {

		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("https://www.heise.de:443/"); // Body: <!DOCTYPE html><html lang="de"

		assertTrue(ret.contains("meta name=\"description\""));

	}

}

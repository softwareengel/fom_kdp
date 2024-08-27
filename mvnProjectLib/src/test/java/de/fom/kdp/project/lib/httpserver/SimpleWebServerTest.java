package de.fom.kdp.project.lib.httpserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link SimpleWebServer}.
 * <p>
 * This class contains a test method that verifies the functionality of various
 * HTTP methods (GET, POST, PUT, DELETE) when interacting with the
 * {@link SimpleWebServer}. The test uses the {@link SimpleWebServerClient} to
 * send requests to the server and checks that the server responds appropriately
 * to each HTTP method.
 * </p>
 * 
 * @author engels
 *
 */

public class SimpleWebServerTest {
	/**
	 * Tests the handling of HTTP methods by the {@link SimpleWebServer}.
	 * <p>
	 * This method performs the following:
	 * <ul>
	 * <li>Starts the {@link SimpleWebServer} on port 8000.</li>
	 * <li>Sends GET, POST, PUT, and DELETE requests to the server using the
	 * {@link SimpleWebServerClient}.</li>
	 * <li>Verifies that the server responds with the expected content for each HTTP
	 * method.</li>
	 * <li>Shuts down the server after the tests are completed.</li>
	 * </ul>
	 * 
	 * @throws IOException if an I/O error occurs during the test execution.
	 */
	@Test
	public void testHttpMethodClient_on_SimpleWebServer() throws IOException {
		SimpleWebServer sws = new SimpleWebServer(8000);
		sws.startup();

		SimpleWebServerClient htm = new SimpleWebServerClient();
		// Test GET method
		String ret = SimpleWebServerClient.httpGet("http://localhost:8000/");
		assertTrue(ret.contains("GET request"));

		// Test POST method
		ret = SimpleWebServerClient.httpPost("http://localhost:8000/", "This is a POST request");
		assertTrue(ret.contains("POST request"));
		// Test PUT method
		ret = SimpleWebServerClient.httpPut("http://localhost:8000/", "This is a PUT request");
		assertTrue(ret.contains("PUT request"));

		// Test DELETE method
		ret = SimpleWebServerClient.httpDelete("http://localhost:8000/");
		assertTrue(ret.contains("DELETE request"));

		sws.shutdown();
	}

}

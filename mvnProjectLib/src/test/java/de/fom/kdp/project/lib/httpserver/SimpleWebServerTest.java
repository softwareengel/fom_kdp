package de.fom.kdp.project.lib.httpserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class SimpleWebServerTest {

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

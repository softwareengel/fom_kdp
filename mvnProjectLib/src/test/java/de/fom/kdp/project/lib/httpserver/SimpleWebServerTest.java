package de.fom.kdp.project.lib.httpserver;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class SimpleWebServerTest {

	@Test
	public void testHttpMethodClient_on_SimpleWebServer() throws IOException {
		SimpleWebServer sws = new SimpleWebServer();
		sws.startup();

		SimpleWebServerClient htm = new SimpleWebServerClient();
		// Test GET method
		String ret = htm.httpGet("http://localhost:8000/");
		assertTrue(ret.contains("GET request"));

		// Test POST method
		ret = htm.httpPost("http://localhost:8000/", "This is a POST request");
		assertTrue(ret.contains("POST request"));
		// Test PUT method
		ret = htm.httpPut("http://localhost:8000/", "This is a PUT request");
		assertTrue(ret.contains("PUT request"));

		// Test DELETE method
		ret = htm.httpDelete("http://localhost:8000/");
		assertTrue(ret.contains("DELETE request"));

		sws.shutdown();
	}



}

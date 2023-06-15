package de.fom.kdp.project.lib.httpserver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class HttpMethodClientTest {

	@Test
	public void testHttpGet() throws IOException {
		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("https://news.ycombinator.com/news"); // Status Code: 301, Moved Permanently to
																		// https://www.heise.de/
		assertTrue(ret.contains("Hacker"));
	}

	@Test
	public void testHttpGet_http301() throws IOException {

		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("http://heise.de:80/"); // Status Code: 301, Moved Permanently to https://www.heise.de/
		assertTrue(ret.contains("301"));

	}

	@Test
	public void testHttpGet_https() throws IOException {

		SimpleWebServerClient htm = new SimpleWebServerClient();

		// Test GET method
		String ret = SimpleWebServerClient.httpGet("https://www.heise.de:443/"); // Body: <!DOCTYPE html><html lang="de"

		assertTrue(ret.contains("meta name=\"description\""));

	}

}

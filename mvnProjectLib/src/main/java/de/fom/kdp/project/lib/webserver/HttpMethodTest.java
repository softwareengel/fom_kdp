package de.fom.kdp.project.lib.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * In this example, we use the HttpURLConnection class from the Java standard
 * library to send HTTP requests and receive responses. Each HTTP method is
 * tested by creating the corresponding request object, setting the request
 * method, and handling the request and response.
 * 
 * @author engels
 *
 */
public class HttpMethodTest {
	public static void main(String[] args) throws IOException {
		// Test GET method
		testHttpGet("http://localhost:8000/");

		// Test POST method
		testHttpPost("http://localhost:8000/", "This is a POST request");

		// Test PUT method
		testHttpPut("http://localhost:8000/", "This is a PUT request");

		// Test DELETE method
		testHttpDelete("http://localhost:8000/");
	}

	private static void testHttpGet(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		int responseCode = connection.getResponseCode();
		String responseBody = getResponseBody(connection);

		System.out.println("HTTP Method: GET");
		System.out.println("Status Code: " + responseCode);
		System.out.println("Response Body: " + responseBody);
		System.out.println("----------------------------------------------");

		connection.disconnect();
	}

	private static void testHttpPost(String urlString, String requestBody) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setDoOutput(true);

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(requestBody.getBytes());
		outputStream.flush();
		outputStream.close();

		int responseCode = connection.getResponseCode();
		String responseBody = getResponseBody(connection);

		System.out.println("HTTP Method: POST");
		System.out.println("Status Code: " + responseCode);
		System.out.println("Response Body: " + responseBody);
		System.out.println("----------------------------------------------");

		connection.disconnect();
	}

	private static void testHttpPut(String urlString, String requestBody) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setDoOutput(true);

		OutputStream outputStream = connection.getOutputStream();
		outputStream.write(requestBody.getBytes());
		outputStream.flush();
		outputStream.close();

		int responseCode = connection.getResponseCode();
		String responseBody = getResponseBody(connection);

		System.out.println("HTTP Method: PUT");
		System.out.println("Status Code: " + responseCode);
		System.out.println("Response Body: " + responseBody);
		System.out.println("----------------------------------------------");

		connection.disconnect();
	}

	private static void testHttpDelete(String urlString) throws IOException {
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("DELETE");

		int responseCode = connection.getResponseCode();
		String responseBody = getResponseBody(connection);

		System.out.println("HTTP Method: DELETE");
		System.out.println("Status Code: " + responseCode);
		System.out.println("Response Body: " + responseBody);
		System.out.println("----------------------------------------------");

		connection.disconnect();
	}

	private static String getResponseBody(HttpURLConnection connection) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		StringBuilder responseBody = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			responseBody.append(line);
		}
		reader.close();
		return responseBody.toString();
	}
}

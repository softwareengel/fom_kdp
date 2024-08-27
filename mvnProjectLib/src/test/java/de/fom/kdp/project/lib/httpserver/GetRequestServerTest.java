package de.fom.kdp.project.lib.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

/**
 * /** Test class for {@link GetRequestServer}.
 * <p>
 * This class contains test methods to verify the functionality of the
 * {@link GetRequestServer}, specifically testing its ability to handle GET
 * requests and provide the expected responses.
 * </p>
 * 
 * @author engels
 *
 */
public class GetRequestServerTest {
	/**
	 * Tests the GET request handling of the {@link GetRequestServer}.
	 * <p>
	 * This method does the following:
	 * <ul>
	 * <li>Starts the server on port 8001.</li>
	 * <li>Sends a GET request to the server and checks the HTTP response code.</li>
	 * <li>Reads and verifies the response from the server.</li>
	 * <li>Checks if the response matches the expected output ("Hello,
	 * world!").</li>
	 * <li>Prints the test result to the console.</li>
	 * <li>Shuts down the server after the test is complete.</li>
	 * </ul>
	 * 
	 * 
	 * @throws IOException if an I/O error occurs during the test execution.
	 */
	@Test
	public void testGet() throws IOException {

		GetRequestServer grs = new GetRequestServer(8001);
		grs.startup();

		String serverUrl = "http://localhost:8001/hello";

		try {
			// Sende eine GET-Anfrage an den Server
			URL url = new URL(serverUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			// Überprüfe den HTTP-Statuscode der Serverantwort
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			// Lese die Serverantwort
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			StringBuilder response = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			// Überprüfe die erwartete Antwort des Servers
			String expectedResponse = "Hello, world!";
			String actualResponse = response.toString();
			if (expectedResponse.equals(actualResponse)) {
				System.out.println("Test erfolgreich! Erwartete Antwort erhalten.");
			} else {
				System.out.println("Test fehlgeschlagen! Unerwartete Antwort erhalten.");
				System.out.println("Erwartet: " + expectedResponse);
				System.out.println("Erhalten: " + actualResponse);
			}

			// Schließe die Verbindung
			connection.disconnect();

		} catch (IOException e) {
			e.printStackTrace();
		}
		grs.shutdown();
	}

	/**
	 * Tests the main method of the {@link GetRequestServer} class.
	 * <p>
	 * This method is primarily included to ensure code coverage for the
	 * {@link GetRequestServer#main(String[])} method. It simply calls the main
	 * method with a null argument to verify that no exceptions are thrown.
	 * </p>
	 * 
	 * @throws IOException if an I/O error occurs during the execution.
	 */
	@Test
	public void test_main() throws IOException {
		GetRequestServer.main(null);
	}
}

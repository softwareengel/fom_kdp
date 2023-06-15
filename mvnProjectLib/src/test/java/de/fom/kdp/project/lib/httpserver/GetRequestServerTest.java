package de.fom.kdp.project.lib.httpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;

public class GetRequestServerTest {

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
	 * only for code coverage
	 *
	 * @throws IOException
	 */
	@Test
	public void test_main() throws IOException {
		GetRequestServer.main(null);
	}
}

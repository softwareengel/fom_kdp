package de.fom.kdp.project.lib.httpconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * In diesem Beispiel wird eine GET-Anfrage an den Server unter der angegebenen
 * URL gesendet und die Serverantwort überprüft. Die erwartete Antwort des
 * Servers wird mit der tatsächlichen Antwort verglichen, und das Ergebnis des
 * Tests wird ausgegeben.
 * 
 * Du kannst den Code anpassen, um verschiedene Arten von Anfragen (GET, POST,
 * usw.) zu senden und die erwarteten Antworten für unterschiedliche Testfälle
 * zu definieren. Beachte, dass du den Server vor dem Test ausführen musst, um
 * sicherzustellen, dass er auf die Anfragen antworten kann.
 * 
 * @author engels
 *
 */
public class HttpServerTest {
	public static void main(String[] args) {
		String serverUrl = "http://localhost:8000/hello";

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
	}
}

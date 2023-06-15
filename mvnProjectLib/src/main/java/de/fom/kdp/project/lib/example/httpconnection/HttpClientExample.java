package de.fom.kdp.project.lib.example.httpconnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Abrufen von HTTP - Web - Daten
 *
 * @author engels
 *
 */
public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Definiere die URL, die du aufrufen möchtest
//            URL url = new URL("https://www.wikipedia.com");
            URL url = new URL("https://news.ycombinator.com");

            // Erstelle eine Verbindung zur URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Setze die HTTP-Methode (GET ist die Standardmethode)
            connection.setRequestMethod("GET");

            // Lese die Antwort des Servers
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Gib die Serverantwort aus
            System.out.println(response.toString());

            // Schließe die Verbindung
            connection.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package de.fom.kdp.project.lib.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * In diesem Beispiel wird ein HTTP-Server erstellt, der auf Port 8000 läuft und
 * auf der URL "/hello" reagiert. Wenn du den Server ausführst und
 * "http://localhost:8000/hello" im Browser aufrufst, wird die Nachricht "Hello,
 * world!" als Antwort angezeigt.
 * 
 * @author engels
 *
 */
public class GetRequestServer {
	HttpServer server = null;

	int port = 8001;

	public static void main(String[] args) {
		try {
			GetRequestServer grs = new GetRequestServer(8001);
			int port = grs.startup();

			System.out.println("HTTP Server gestartet. Port: " + port);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * C'tor 
	 * @param port
	 */
	public GetRequestServer(int port) {
		super();
		this.port = port;
	}

	int startup() throws IOException {
		// Erstelle einen HTTP-Server an einem bestimmten Port
		server = HttpServer.create(new InetSocketAddress(port), 0);

		// Definiere den Pfad und den Handler für eine bestimmte URL
		server.createContext("/hello", new MyHandler());

		// Starte den Server
		server.start();
		return port;
	}

	public void shutdown() {
		server.stop(0);

	}

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String response = "Hello, world!";

			// Setze den HTTP-Statuscode und die Content-Type-Header
			exchange.sendResponseHeaders(200, response.length());
			exchange.getResponseHeaders().set("Content-Type", "text/plain");

			// Schreibe die Antwort auf den Output-Stream der HTTP-Antwort
			OutputStream outputStream = exchange.getResponseBody();
			outputStream.write(response.getBytes());
			outputStream.close();
		}
	}
}

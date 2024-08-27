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
 * The {@code GetRequestServer} class demonstrates how to create a simple HTTP
 * server that listens on a specified port and responds to requests made to the
 * "/hello" endpoint. When the server is running, accessing
 * "http://localhost:8000/hello" in a browser will return the message "Hello,
 * world!".
 *
 * <p>
 * This class sets up the server, defines the request handler for the "/hello"
 * endpoint, and manages the server's lifecycle.
 * </p>
 *
 * @author engels
 *
 */
public class GetRequestServer {
	HttpServer server = null;

	int port = 8001;

	/**
	 * The entry point of the application. This method creates an instance of
	 * {@code GetRequestServer}, starts the server on the specified port, and prints
	 * a message indicating that the server is running.
	 *
	 * @param args command-line arguments (not used in this example).
	 */
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
	 * Constructs a {@code GetRequestServer} instance that listens on the specified
	 * port.
	 *
	 * @param port the port number on which the server will listen for incoming HTTP
	 *             requests.
	 */
	public GetRequestServer(int port) {
		super();
		this.port = port;
	}

	/**
	 * Starts the HTTP server and binds it to the specified port. This method sets
	 * up the request handler for the "/hello" endpoint and starts the server,
	 * making it ready to accept and process incoming HTTP requests.
	 *
	 * @return the port number on which the server is running.
	 * @throws IOException if an I/O error occurs during server creation or startup.
	 */
	int startup() throws IOException {
		// Erstelle einen HTTP-Server an einem bestimmten Port
		server = HttpServer.create(new InetSocketAddress(port), 0);

		// Definiere den Pfad und den Handler für eine bestimmte URL
		server.createContext("/hello", new MyHandler());

		// Starte den Server
		server.start();
		return port;
	}

	/**
	 * Shuts down the HTTP server gracefully, stopping it from accepting and
	 * processing new requests.
	 */
	public void shutdown() {
		server.stop(0);

	}

	/**
	 * The {@code MyHandler} class implements the {@code HttpHandler} interface and
	 * defines how to handle incoming HTTP requests to the "/hello" endpoint.
	 *
	 * <p>
	 * When a request is received, this handler responds with a simple "Hello,
	 * world!" message.
	 * </p>
	 */
	static class MyHandler implements HttpHandler {
		/**
		 * Handles the incoming HTTP request and sends a "Hello, world!" response.
		 *
		 * @param exchange the {@code HttpExchange} object that encapsulates the HTTP
		 *                 request and response.
		 * @throws IOException if an I/O error occurs during the handling of the request
		 *                     or response.
		 */

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

package de.fom.kdp.project.lib.httpserver;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * In this code, the MyHandler class handles different HTTP methods using a
 * switch statement. The handleGetRequest(), handlePostRequest(),
 * handlePutRequest(), and handleDeleteRequest() methods demonstrate how to
 * handle specific HTTP methods (GET, POST, PUT, DELETE) by sending different
 * response messages. If the server receives an unsupported HTTP method, the
 * handleUnsupportedMethod() method is called, which sends a 405 status code
 * (Method Not Allowed).
 *
 * The sendResponse() method is used to set the response headers, send the
 * appropriate response code, and write the response message to the output
 * stream.
 *
 * Compile and run the code, and you can test different HTTP methods by using
 * tools like cURL or web browsers with the appropriate requests. The server
 * will respond with the corresponding messages for each HTTP method.
 *
 * @author engels
 *
 */
public class SimpleWebServer {
	/**
	 *
	 */
	HttpServer server = null;
	/**
	 * port of SimpleWebServer
	 */
	int port = 8000;

	public static void main(String[] args) throws IOException {
		// Create a new HTTP server listening on port 8000
		SimpleWebServer sws = new SimpleWebServer(8000);

		sws.startup();

		System.out.println("Server is running on port 8000");
	}

	/**
	 * c'tor of SimpleWebServer
	 *
	 * @param port
	 */
	public SimpleWebServer(int port) {
		super();
		this.port = port;
	}

	void startup() throws IOException {
		server = HttpServer.create(new InetSocketAddress(port), 0);

		// Set the handler for each supported HTTP method
		server.createContext("/", new MyHandler());

		// Start the server
		server.start();
	}

	public void shutdown() {
		server.stop(0);
	}

	static class MyHandler implements HttpHandler {
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			String method = exchange.getRequestMethod(); // Get the HTTP method

			// Handle different HTTP methods
			switch (method) {
			case "GET":
				handleGetRequest(exchange);
				break;
			case "POST":
				handlePostRequest(exchange);
				break;
			case "PUT":
				handlePutRequest(exchange);
				break;
			case "DELETE":
				handleDeleteRequest(exchange);
				break;
			default:
				handleUnsupportedMethod(exchange);
				break;
			}
		}

		private void handleGetRequest(HttpExchange exchange) throws IOException {
			String response = "This is a GET request";
			sendResponse(exchange, response, 200);
		}

		private void handlePostRequest(HttpExchange exchange) throws IOException {
			String response = "This is a POST request";
			sendResponse(exchange, response, 200);
		}

		private void handlePutRequest(HttpExchange exchange) throws IOException {
			String response = "This is a PUT request";
			sendResponse(exchange, response, 200);
		}

		private void handleDeleteRequest(HttpExchange exchange) throws IOException {
			String response = "This is a DELETE request";
			sendResponse(exchange, response, 200);
		}

		private void handleUnsupportedMethod(HttpExchange exchange) throws IOException {
			String response = "Unsupported HTTP method";
			sendResponse(exchange, response, 405);
		}

		private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
			exchange.getResponseHeaders().set("Content-Type", "text/plain");
			exchange.sendResponseHeaders(statusCode, response.length());

			OutputStream outputStream = exchange.getResponseBody();
			outputStream.write(response.getBytes());
			outputStream.close();
		}
	}

}

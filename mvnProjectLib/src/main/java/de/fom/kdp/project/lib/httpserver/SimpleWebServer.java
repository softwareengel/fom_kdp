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

	/**
	 * The entry point of the {@code SimpleWebServer} application. This method
	 * creates and starts an HTTP server that listens on port 8000.
	 * 
	 * <p>
	 * Steps performed by this method:
	 * </p>
	 * <ul>
	 * <li>Creates an instance of {@code SimpleWebServer}, configured to listen on
	 * port 8000.</li>
	 * <li>Starts the server by calling the {@code startup} method, which begins
	 * handling HTTP requests.</li>
	 * <li>Prints a message to the console indicating that the server is running on
	 * port 8000.</li>
	 * </ul>
	 *
	 * @param args command-line arguments (not used in this example).
	 * @throws IOException if an I/O error occurs during the startup of the server.
	 */
	public static void main(String[] args) throws IOException {
		// Create a new HTTP server listening on port 8000
		SimpleWebServer sws = new SimpleWebServer(8000);

		sws.startup();

		System.out.println("Server is running on port 8000");
	}

	/**
	 * Constructs a new {@code SimpleWebServer} instance that listens on the
	 * specified port. This constructor initializes the server to be ready to handle
	 * HTTP requests on the provided port number.
	 *
	 * @param port the port number on which the server will listen for incoming HTTP
	 *             requests.
	 */

	public SimpleWebServer(int port) {
		super();
		this.port = port;
	}

	/**
	 * Starts the {@code SimpleWebServer} by creating and configuring an HTTP server
	 * instance.
	 * 
	 * <p>
	 * This method performs the following actions:
	 * </p>
	 * <ul>
	 * <li>Initializes the HTTP server to listen on the port specified during the
	 * construction of the {@code SimpleWebServer}.</li>
	 * <li>Sets up the request handler for the root context ("/"), directing
	 * incoming HTTP requests to the {@code MyHandler} class.</li>
	 * <li>Starts the HTTP server, making it ready to accept and process incoming
	 * HTTP requests.</li>
	 * </ul>
	 *
	 * @throws IOException if an I/O error occurs during the creation or startup of
	 *                     the server.
	 */
	void startup() throws IOException {
		server = HttpServer.create(new InetSocketAddress(port), 0);

		// Set the handler for each supported HTTP method
		server.createContext("/", new MyHandler());

		// Start the server
		server.start();
	}

	/**
	 * Shuts down the {@code SimpleWebServer} gracefully.
	 * 
	 * <p>
	 * This method stops the HTTP server, ceasing its ability to accept and process
	 * incoming HTTP requests. The server is stopped immediately without any delay.
	 * </p>
	 */
	public void shutdown() {
		server.stop(0);
	}

	/**
	 * {@code MyHandler} is an implementation of the {@code HttpHandler} interface,
	 * responsible for handling HTTP requests received by the
	 * {@code SimpleWebServer}. This class processes various HTTP methods (GET,
	 * POST, PUT, DELETE) and provides appropriate responses for each.
	 */
	static class MyHandler implements HttpHandler {

		/**
		 * Handles an incoming HTTP request by determining the request method and
		 * dispatching it to the appropriate handler method (GET, POST, PUT, DELETE).
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during request handling or
		 *                     response sending.
		 */
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

		/**
		 * Handles HTTP GET requests by sending a simple text response.
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void handleGetRequest(HttpExchange exchange) throws IOException {
			String response = "This is a GET request";
			sendResponse(exchange, response, 200);
		}

		/**
		 * Handles HTTP POST requests by sending a simple text response.
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void handlePostRequest(HttpExchange exchange) throws IOException {
			String response = "This is a POST request";
			sendResponse(exchange, response, 200);
		}

		/**
		 * Handles HTTP PUT requests by sending a simple text response.
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void handlePutRequest(HttpExchange exchange) throws IOException {
			String response = "This is a PUT request";
			sendResponse(exchange, response, 200);
		}

		/**
		 * Handles HTTP DELETE requests by sending a simple text response.
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void handleDeleteRequest(HttpExchange exchange) throws IOException {
			String response = "This is a DELETE request";
			sendResponse(exchange, response, 200);
		}

		/**
		 * Handles unsupported HTTP methods by sending a "405 Method Not Allowed"
		 * response.
		 *
		 * @param exchange the {@code HttpExchange} object that contains the request and
		 *                 response details.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void handleUnsupportedMethod(HttpExchange exchange) throws IOException {
			String response = "Unsupported HTTP method";
			sendResponse(exchange, response, 405);
		}

		/**
		 * Sends a response back to the client with the specified status code and
		 * message.
		 *
		 * @param exchange   the {@code HttpExchange} object that contains the request
		 *                   and response details.
		 * @param response   the response message to send to the client.
		 * @param statusCode the HTTP status code to send with the response.
		 * @throws IOException if an I/O error occurs during response sending.
		 */
		private void sendResponse(HttpExchange exchange, String response, int statusCode) throws IOException {
			exchange.getResponseHeaders().set("Content-Type", "text/plain");
			exchange.sendResponseHeaders(statusCode, response.length());

			OutputStream outputStream = exchange.getResponseBody();
			outputStream.write(response.getBytes());
			outputStream.close();
		}
	}

}

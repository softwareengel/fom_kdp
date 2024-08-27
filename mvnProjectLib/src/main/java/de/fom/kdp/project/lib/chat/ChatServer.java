package de.fom.kdp.project.lib.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ChatServer} class represents a simple multi-threaded chat server
 * in Java. It allows multiple clients to connect, send messages, and have those
 * messages broadcasted to all other connected clients.
 *
 * <p>
 * The {@code ChatServer} class implements the {@code Runnable} interface,
 * allowing it to be executed in a separate thread. The server listens for
 * client connections on a specified port using a {@code ServerSocket}. When a
 * client connects, a new {@code ClientHandler} instance is created to manage
 * that client's input and output streams. Each {@code ClientHandler} runs in
 * its own thread, continuously reading messages from the client and
 * broadcasting them to all connected clients.
 * </p>
 *
 * <p>
 * The {@code stop()} method stops the server by closing the
 * {@code ServerSocket}, which terminates the server's ability to accept new
 * client connections.
 * </p>
 *
 * <p>
 * The main method demonstrates how to start the chat server in a separate
 * thread. Additionally, the code includes commented-out sections for stopping
 * the server after a delay, which could be useful for testing purposes.
 * </p>
 *
 * <p>
 * A list called {@code clients} is used to store all connected clients. When a
 * new client connects, the corresponding {@code ClientHandler} is added to the
 * {@code clients} list. Messages received from a client are broadcasted to all
 * connected clients using the {@code sendMessageToAllClients()} method. When a
 * client disconnects, its {@code ClientHandler} is removed from the
 * {@code clients} list.
 * </p>
 *
 * <p>
 * This simple chat server provides a basic foundation for creating a
 * multi-client chat application in Java.
 * </p>
 *
 * @author engels
 */
public class ChatServer implements Runnable {
	private static List<ClientHandler> clients = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean isRunning = true;

	/**
	 * Constructs a {@code ChatServer} instance that listens for client connections
	 * on the specified port.
	 *
	 * @param port the port number on which the server will listen for incoming
	 *             connections.
	 * @throws IOException if an I/O error occurs when opening the socket.
	 */
	public ChatServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		isRunning = true;
	}

	/**
	 * The entry point of the application. This method creates an instance of
	 * {@code ChatServer}, starts the server in a separate thread, and optionally
	 * stops the server after a delay (code commented out).
	 *
	 * @param args command-line arguments (not used in this example).
	 */
	public static void main(String[] args) {

		try {
			ChatServer server = new ChatServer(12345);
			// server.startChatServer();
			Thread serverthread = new Thread(server);
			serverthread.start();

//			Thread.sleep(5000);
//			server.stop();
//			serverthread.join();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Starts the chat server, listening for incoming client connections and
	 * spawning a new {@code ClientHandler} thread for each connected client. This
	 * method runs continuously until the server is stopped.
	 */
	public void startChatServer() {

		System.out.println("Chat Server started on port " + serverSocket.getLocalPort());
		while (isRunning) {
			Socket clientSocket;
			try {
				clientSocket = serverSocket.accept();
				System.out.println("Server - Client connected: " + clientSocket.getInetAddress().getHostAddress());
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				clients.add(clientHandler);
				Thread thread = new Thread(clientHandler);
				thread.start();
			} catch (IOException e) {
				if (e.getMessage().equals("Socket closed")) {
					System.out.println("Server Socket closed. Chat server stopped.");

				} else {
					e.printStackTrace();
				}

			}
		}
	}

	/**
	 * Stops the chat server by closing the {@code ServerSocket} and stopping its
	 * ability to accept new connections.
	 */
	public void stop() {
		isRunning = false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server stopped.");
	}

	/**
	 * Runs the chat server in a separate thread. This method is called when the
	 * {@code ChatServer} instance is passed to a {@code Thread} and started.
	 */
	@Override
	public void run() {

		startChatServer();
	}

	/**
	 * The {@code ClientHandler} class is responsible for handling communication
	 * between the server and a single connected client. It reads messages from the
	 * client and broadcasts them to all connected clients.
	 *
	 * <p>
	 * Each {@code ClientHandler} runs in its own thread, allowing multiple clients
	 * to be handled concurrently.
	 * </p>
	 */
	static class ClientHandler implements Runnable {
		private Socket clientSocket;
		private BufferedReader reader;
		private PrintWriter writer;

		/**
		 * Constructs a {@code ClientHandler} for a specific client socket. Initializes
		 * the input and output streams for communication with the client.
		 *
		 * @param clientSocket the socket representing the connection to the client.
		 * @throws IOException if an I/O error occurs when creating the input/output
		 *                     streams.
		 */
		public ClientHandler(Socket clientSocket) throws IOException {
			this.clientSocket = clientSocket;
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
		}

		/**
		 * Handles communication with the connected client. Reads messages from the
		 * client and broadcasts them to all other connected clients. If the client
		 * disconnects, this method closes the connection and removes the
		 * {@code ClientHandler} from the list of active clients.
		 */
		@Override
		public void run() {
			try {
				String message = null;

				while ((message = reader.readLine()) != null) {
					// synchronized (message)
					{
						System.out.println("Server - Received message from client: " + message);
						sendMessageToAllClients(message);
					}
				}
			} catch (IOException e) {
				if (e.getMessage().equals("Connection reset")) {
					System.out.println("Server Connection reset.");
				} else {

					e.printStackTrace();
				}
			} finally {
				try {
					reader.close();
					writer.close();
					clientSocket.close();
					clients.remove(this);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * Sends a message to all connected clients.
		 *
		 * @param message the message to be sent to all clients.
		 */
		private void sendMessageToAllClients(String message) {
			for (ClientHandler client : clients) {
				// synchronized (client)
				{
					client.writer.println(message);
					System.out.println("Server - send : " + message);
				}
			}
		}
	}

}

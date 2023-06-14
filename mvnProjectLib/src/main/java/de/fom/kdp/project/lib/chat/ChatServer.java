package de.fom.kdp.project.lib.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * simple chat server in Java. It allows clients to connect, send messages, and
 * broadcasts those messages to all connected clients
 * 
 * * The ChatServer class implements the Runnable interface, allowing it to be
 * run in a separate thread. It listens for client connections on a specified
 * port using a ServerSocket. When a client connects, a new ClientHandler
 * instance is created to handle the client's input and output streams. Each
 * ClientHandler runs in its own thread and continuously reads messages from the
 * client and broadcasts them to all connected clients.
 * 
 * The stop() method is used to stop the server by closing the ServerSocket.
 * 
 * In the main() method, a ChatServer instance is created, and its run() method
 * is executed in a separate thread. After waiting for 5 seconds, the server is
 * stopped by calling the stop() method.
 * 
 * a list called clients is created to store all connected clients. When a new
 * client connects, the ClientHandler instance for that client is added to the
 * clients list. When a message is received from a client, the
 * sendMessageToAllClients() method is called, which iterates over all the
 * connected clients in the clients list and sends the message to each client
 * using their respective PrintWriter.
 * 
 * Additionally, when a client disconnects, the corresponding ClientHandler is
 * removed from the clients list.
 * 
 * when a client sends a message to the server, the server will broadcast the
 * message to all connected clients.
 * 
 * @author engels
 *
 */
public class ChatServer implements Runnable {
	private static List<ClientHandler> clients = new ArrayList<>();
	private ServerSocket serverSocket;
	private boolean isRunning = true;

	public ChatServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		isRunning = true;
	}

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

	public void stop() {
		isRunning = false;
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server stopped.");
	}

	@Override
	public void run() {

		startChatServer();
	}

	static class ClientHandler implements Runnable {
		private Socket clientSocket;
		private BufferedReader reader;
		private PrintWriter writer;

		public ClientHandler(Socket clientSocket) throws IOException {
			this.clientSocket = clientSocket;
			reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			writer = new PrintWriter(clientSocket.getOutputStream(), true);
		}

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

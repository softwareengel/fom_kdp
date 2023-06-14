package de.fom.kdp.project.lib.chat;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
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
 * Now, when a client sends a message to the server, the server will broadcast
 * the message to all connected clients.
 * 
 * @author engels
 *
 */
public class ChatServer {
	private static List<ClientHandler> clients = new ArrayList<>();

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(12345);
			System.out.println("Chat Server started on port 12345.");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

				ClientHandler clientHandler = new ClientHandler(clientSocket);
				clients.add(clientHandler);
				Thread thread = new Thread(clientHandler);
				thread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				String message;
				while ((message = reader.readLine()) != null) {
					System.out.println("Received message from client: " + message);
					sendMessageToAllClients(message);
				}
			} catch (IOException e) {
				e.printStackTrace();
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
				client.writer.println("Server: " + message);
			}
		}
	}
}

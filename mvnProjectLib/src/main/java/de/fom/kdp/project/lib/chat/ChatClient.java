package de.fom.kdp.project.lib.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * To test the Java client, you can run the ChatClient class. It will connect to
 * the chat server running on localhost at port 12345. You can type messages in
 * the console and press enter to send them to the server. The server will then
 * echo the message back to the client, and the client will display it in the
 * console as "Server: [message]".
 * 
 * You can run multiple instances of the client to simulate multiple users
 * interacting with the chat server.
 * 
 * @author engels
 *
 */
public class ChatClient {
	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket("localhost", 12345);
			System.out.println("Connected to Chat Server.");

			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

			// Start a separate thread to receive messages from the server
			Thread receiveThread = new Thread(() -> {
				try {
					BufferedReader serverReader = new BufferedReader(
							new InputStreamReader(clientSocket.getInputStream()));
					String message;
					while ((message = serverReader.readLine()) != null) {
						System.out.println("Server: " + message);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			receiveThread.start();

			// Read user input and send messages to the server
			String userInput;
			while ((userInput = reader.readLine()) != null) {
				writer.println(userInput);
			}

			reader.close();
			writer.close();
			clientSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

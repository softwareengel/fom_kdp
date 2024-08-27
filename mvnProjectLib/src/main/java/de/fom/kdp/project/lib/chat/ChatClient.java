package de.fom.kdp.project.lib.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * To Use the Java client, you can run the ChatClient class. It will connect to
 * the chat server running on localhost at port 12345. You can type messages in
 * the console and press enter to send them to the server. The server will then
 * echo the message back to the client, and the client will display it in the
 * console as "Server: [message]".
 *
 * You can run multiple instances of the client to simulate multiple users
 * interacting with the chat server.
 *
 * The {@code ChatClient} class represents a simple chat client that connects to
 * a chat server, sends messages, and receives messages from the server. This
 * client is designed to interact with a chat server running on a specified host
 * and port.
 *
 * <p>
 * The client can be run as a standalone application, and multiple instances of
 * the client can be used to simulate multiple users interacting with the same
 * chat server.
 * </p>
 *
 * <p>
 * Upon connecting to the server, the client can send messages typed in the
 * console and will receive messages broadcasted by the server. Messages
 * received from the server are displayed in the console with the prefix
 * "Server: [message]".
 * </p>
 *
 * <p>
 * The client operates with two main threads: one for sending messages from the
 * console and one for receiving messages from the server.
 * </p>
 * 
 * @author engels
 *
 */
public class ChatClient implements Runnable {
	Socket clientSocket;
	PrintWriter socketwriter;
	/**
	 * The {@code receiveThread} field represents an instance of the
	 * {@code ReceiveThread} class, which is responsible for handling the reception
	 * of messages in a separate thread.
	 *
	 * <p>
	 * This thread is typically used in chat applications or networked programs to
	 * continuously listen for and process incoming messages from a server or
	 * another client, allowing the main thread to remain responsive and handle
	 * other tasks.
	 * </p>
	 *
	 * <p>
	 * Note: The {@code ReceiveThread} class itself should be documented separately
	 * to provide more details on its functionality and usage.
	 * </p>
	 */
	public ReceiveThread receiveThread;
	private boolean isRunning = true;

	/**
	 * Creates a new {@code ChatClient} instance that connects to a chat server
	 * using the specified host and port. Upon successful connection, the client
	 * socket is initialized, and a separate thread is started to handle incoming
	 * messages from the server.
	 *
	 * @param host the hostname or IP address of the chat server to connect to.
	 * @param port the port number on which the chat server is listening.
	 * @throws UnknownHostException if the IP address of the host cannot be
	 *                              determined.
	 * @throws IOException          if an I/O error occurs when creating the socket
	 *                              or getting the output stream.
	 */
	public ChatClient(String host, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(host, port);

		socketwriter = new PrintWriter(clientSocket.getOutputStream(), true);

		System.out.println("Client - Connected to Chat Server.");

		receiveThread = new ReceiveThread();
		Thread t = new Thread(receiveThread);
		t.start();

	}

	/**
	 * The entry point of the {@code ChatClient} application. This method creates a
	 * new instance of {@code ChatClient} and starts a client thread to handle
	 * communication with the chat server.
	 * 
	 * <p>
	 * Steps performed by this method:
	 * </p>
	 * <ul>
	 * <li>Instantiates a {@code ChatClient} object, connecting to a chat server
	 * running on the local host at port 12345.</li>
	 * <li>Creates and starts a new thread to handle the {@code ChatClient}
	 * operations.</li>
	 * </ul>
	 * 
	 * <p>
	 * Commented-out code demonstrates how to stop the client after a delay and wait
	 * for the thread to finish:
	 * </p>
	 * <ul>
	 * <li>{@code Thread.sleep(5000);} - Pauses the main thread for 5 seconds.</li>
	 * <li>{@code chatClient.stop();} - Stops the client connection (method needs to
	 * be implemented in {@code ChatClient}).</li>
	 * <li>{@code clientthread.join();} - Waits for the client thread to finish
	 * execution.</li>
	 * </ul>
	 *
	 * @param args command-line arguments (not used in this example).
	 * @throws UnknownHostException if the IP address of the host cannot be
	 *                              determined.
	 * @throws IOException          if an I/O error occurs when creating the socket.
	 * @throws InterruptedException if any thread has interrupted the current
	 *                              thread.
	 */

//	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
//		ChatClient chatClient = new ChatClient("localhost", 12345);
//		Thread clientthread = new Thread(chatClient);
//		clientthread.start();
//
////		Thread.sleep(5000);
////		chatClient.stop();
////		clientthread.join();
//	}

	/**
	 * The {@code ReceiveThread} class handles the reception of messages from the
	 * server in a separate thread. It stores received messages in a list and
	 * provides a method for retrieving the next available message.
	 * 
	 */
	class ReceiveThread implements Runnable {
		ArrayList<String> alMessages = new ArrayList<>();

		/**
		 * Retrieves the next available message received from the server. If no message
		 * is available, it returns {@code null}.
		 *
		 * @return the next received message, or {@code null} if no message is
		 *         available.
		 */
		public String getNextMEssage() {
			String ret = null;
			synchronized (alMessages) {

				if (alMessages.size() > 0) {
					ret = alMessages.remove(0);
					System.out.println("client - getNextMessage: " + ret);
				}
			}
			return ret;
		}

		/**
		 * Continuously listens for messages from the server, stores them in a list, and
		 * prints them to the console.
		 */
		@Override
		public void run() {
			System.out.println("Client - ReceiveThread started.");
			try {
				BufferedReader serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String message;
				while ((message = serverReader.readLine()) != null) {
					synchronized (alMessages) {
						System.out.println("Client - ReceiveThread: " + message);
						alMessages.add(message);
					}
				}
			} catch (IOException e) {
				if (e.getMessage().equals("Socket closed")) {
					System.out.println("Server Socket closed.");
				} else {
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * Starts reading input from the console and sends the typed messages to the
	 * server.
	 *
	 * @throws IOException if an I/O error occurs when reading from the console or
	 *                     sending messages.
	 */
	private void startConsoleInput() throws IOException {
		BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));

		// Read user input and send messages to the server
		String userInput;
		while ((userInput = consolereader.readLine()) != null) {
			sendMessage(userInput);
			System.out.println("Client: " + userInput);
		}

		consolereader.close();
	}

	/**
	 * Sends a message typed by the user to the chat server.
	 *
	 * @param userInput the message to be sent to the server.
	 */
	void sendMessage(String userInput) {
		synchronized (userInput) {
			socketwriter.println(userInput);
			System.out.println("Client-sendMessage: " + userInput);
		}
	}

	/**
	 * Stops the chat client by closing the connection to the server and stopping
	 * any ongoing communication.
	 */
	public void stop() {
		isRunning = false;
		try {
			clientSocket.close();

			socketwriter.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Runs the chat client by starting the console input reading loop. This method
	 * is invoked when the {@code ChatClient} is passed to a {@code Thread} and
	 * started.
	 */
	@Override
	public void run() {
		try {
			startConsoleInput();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

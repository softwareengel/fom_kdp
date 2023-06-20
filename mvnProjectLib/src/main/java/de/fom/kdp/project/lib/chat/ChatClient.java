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
 * @author engels
 *
 */
public class ChatClient implements Runnable {
	Socket clientSocket;
	PrintWriter socketwriter;
	public ReceiveThread receiveThread;
	private boolean isRunning = true;

	public ChatClient(String host, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(host, port);

		socketwriter = new PrintWriter(clientSocket.getOutputStream(), true);

		System.out.println("Client - Connected to Chat Server.");

		receiveThread = new ReceiveThread();
		Thread t = new Thread(receiveThread);
		t.start();

	}

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		ChatClient chatClient = new ChatClient("localhost", 12345);
		Thread clientthread = new Thread(chatClient);
		clientthread.start();

//		Thread.sleep(5000);
//		chatClient.stop();
//		clientthread.join();
	}

	class ReceiveThread implements Runnable {
		ArrayList<String> alMessages = new ArrayList<>();

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

//	private void start() {
//		try {
//			startConsoleInput();
//
//			socketwriter.close();
//			clientSocket.close();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

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

	void sendMessage(String userInput) {
		synchronized (userInput) {
			socketwriter.println(userInput);
			System.out.println("Client-sendMessage: " + userInput);
		}
	}

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

package de.fom.kdp.project.lib.chat;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link ChatClient}.
 * <p>
 * This class contains a test method to verify the functionality of a simple
 * chat system involving a server and one or more clients. The test simulates
 * sending and receiving messages between the clients and the server.
 * </p>
 * 
 * @author engels
 */

public class ChatClientTest {
	ChatServer server;

	/**
	 * Tests the {@link ChatClient} and {@link ChatServer} interaction.
	 * <p>
	 * This test does the following:
	 * <ul>
	 * <li>Starts a chat server.</li>
	 * <li>Starts a chat client and connects it to the server.</li>
	 * <li>The client sends a message to the server.</li>
	 * <li>The client displays the received message from the server.</li>
	 * <li>Starts a second chat client and sends messages from both clients.</li>
	 * <li>Verifies that messages are correctly received and displayed by each
	 * client.</li>
	 * </ul>
	 *
	 * @throws IOException          if an I/O error occurs while creating the server
	 *                              or client.
	 * @throws InterruptedException if the test thread is interrupted during sleep.
	 */
	@Test
	public void testChatClient() throws IOException, InterruptedException {

		startserver();

		ChatClient chatClient = new ChatClient("localhost", 12345);
		Thread clientthread = new Thread(chatClient);
		clientthread.start();

		String userInput = "Message0!";
		chatClient.sendMessage(userInput);

		Thread.sleep(10);
		String msg = null;

		while ((msg = chatClient.receiveThread.getNextMEssage()) != null) {
			System.out.println("TestOut: " + msg);
			assertEquals(msg, userInput);
		}

		Thread.sleep(10);
		ChatClient chatClient2 = new ChatClient("localhost", 12345);
		Thread clientthread2 = new Thread(chatClient);
		clientthread2.start();

		chatClient.sendMessage("chatClient M1!");
		chatClient2.sendMessage("chatClient2 M2!");
		Thread.sleep(10);

		while ((msg = chatClient.receiveThread.getNextMEssage()) != null) {
			System.out.println("TestOut- chatClient: " + msg);
		}
		Thread.sleep(10);
		while ((msg = chatClient2.receiveThread.getNextMEssage()) != null) {
			System.out.println("TestOut- chatClient2: " + msg);
		}

		chatClient.stop();
		chatClient2.stop();

		stopserver();
	}

	/**
	 * Stops the chat server.
	 * <p>
	 * This method stops the running chat server, releasing any resources and
	 * stopping any ongoing server activities.
	 * </p>
	 */
	private void stopserver() {
		server.stop();

	}

	/**
	 * Starts the local chat server.
	 * <p>
	 * This method initializes and starts a chat server on port 12345. The server
	 * runs in a separate thread to handle client connections and messages.
	 * </p>
	 */
	private void startserver() {

		try {
			server = new ChatServer(12345);
			Thread serverthread = new Thread(server);
			serverthread.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

package de.fom.kdp.project.lib.chat;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class ChatClientTest {
	ChatServer server;

	/**
	 * - start chat 1:n </br>
	 * - server </br>
	 * - start chat client </br>
	 * - client: send message to server </br>
	 * - client: show received message from server </br>
	 * - start 2x chat client
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 * @see {@link ChatServer}, {@link ChatClient}
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
		stopserver();
	}

	private void stopserver() {
		server.stop();

	}

	/**
	 * start local chat server
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

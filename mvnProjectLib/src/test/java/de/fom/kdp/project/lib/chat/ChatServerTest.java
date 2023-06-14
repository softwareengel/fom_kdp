package de.fom.kdp.project.lib.chat;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

public class ChatServerTest {

	/**
	 * start & stop chat server 
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @see {@link ChatServer}
	 */
	@Test
	public void testChatServer() throws IOException, InterruptedException {
		ChatServer server = new ChatServer(12346);
		
		Thread serverthread = new Thread(server);
		serverthread.start();
		
		assertNotNull(server);
		
		Thread.sleep(50);
		
		server.stop();
		
		serverthread.join();

	}

}

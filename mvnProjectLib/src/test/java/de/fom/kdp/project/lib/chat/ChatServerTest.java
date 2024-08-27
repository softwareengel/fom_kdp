package de.fom.kdp.project.lib.chat;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

/**
 * Test class for {@link ChatServer}.
 * <p>
 * This class contains a unit test to verify the basic functionality of the
 * {@link ChatServer}, including starting the server, ensuring it is properly
 * instantiated, and stopping it.
 * </p>
 * 
 * @author engels
 *
 */
public class ChatServerTest {

	/**
	 * Tests the start and stop functionality of the {@link ChatServer}.
	 * <p>
	 * This test performs the following steps:
	 * <ul>
	 * <li>Creates a new instance of {@link ChatServer} on port 12346.</li>
	 * <li>Starts the server in a separate thread.</li>
	 * <li>Verifies that the server instance is not null.</li>
	 * <li>Waits briefly to allow the server to start.</li>
	 * <li>Stops the server and waits for the server thread to finish.</li>
	 * </ul>
	 *
	 * @throws IOException          if an I/O error occurs during the creation or
	 *                              operation of the server.
	 * @throws InterruptedException if the current thread is interrupted while
	 *                              waiting for the server thread to finish.
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

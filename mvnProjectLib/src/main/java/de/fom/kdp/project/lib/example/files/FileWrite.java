package de.fom.kdp.project.lib.example.files;

import java.io.FileWriter;
import java.io.IOException;

/**
 * A utility class for writing content to a file using the {@link FileWriter}
 * class.
 * <p>
 * This class demonstrates how to create a new file and write specified content
 * into it. The file path where the content should be written and the content
 * itself are provided as parameters.
 * </p>
 * <p>
 * It is important to handle any {@link IOException} that may occur during the
 * file writing process. After writing the content, the {@link FileWriter}
 * should be closed to release any system resources associated with it.
 * </p>
 * <p>
 * In this example, the file path is set to "file.txt", and the content is a
 * simple string. Ensure that the file path is correctly specified and
 * accessible.
 * </p>
 * 
 * <p>
 * <b>Note:</b> Replace "file.txt" with the actual file path where you want to
 * write the content.
 * </p>
 * 
 * @author engels
 */
public class FileWrite {
	/**
	 * The entry point of the application.
	 * <p>
	 * This method sets the content and file path, and then attempts to write the
	 * content to the file. If an {@link IOException} occurs, it is caught and the
	 * stack trace is printed.
	 * </p>
	 * 
	 * @param args Command-line arguments passed to the program (not used in this
	 *             example).
	 */
	public static void main(String[] args) {

		String content = "This is the content to be written into the file.";
		String filePath = "file.txt";
		try {
			writeFile(content, filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Writes the specified content to a file at the given file path.
	 * <p>
	 * This method uses a {@link FileWriter} to create or overwrite a file at the
	 * specified path with the provided content. After writing the content, the file
	 * writer is closed to ensure all resources are released.
	 * </p>
	 * 
	 * @param content  The content to be written to the file.
	 * @param filePath The file path where the content should be written.
	 * @throws IOException if an I/O error occurs during the writing process.
	 */
	public static void writeFile(String content, String filePath) throws IOException {

		FileWriter writer = new FileWriter(filePath);
		writer.write(content);
		writer.close();
		System.out.println("Successfully wrote the content to the file.");

	}
}

package de.fom.kdp.project.lib.example.files;

import java.io.FileWriter;
import java.io.IOException;

/**
 * In this example, the FileWriter class is used to create a new file and write
 * the specified content into it. You need to provide the file path where you
 * want to create the file, and the content you want to write.
 * 
 * Make sure to handle the IOException that may occur during the file writing
 * process. After writing the content, the writer should be closed to release
 * any system resources associated with it.
 * 
 * Remember to replace "path/to/file.txt" with the actual file path where you
 * want to write the content.
 * 
 * @author engels
 *
 */
public class FileWriteExample {
	public static void main(String[] args) {
		String content = "This is the content to be written into the file.";
		String filePath = "file.txt";

		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(content);
			writer.close();
			System.out.println("Successfully wrote the content to the file.");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

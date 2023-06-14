package de.fom.kdp.project.lib.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * In this example, the FileReader class is used to read the file, and the
 * BufferedReader class is used to read the file line by line. You need to
 * provide the file path of the file you want to read.
 * 
 * The code reads each line of the file using the readLine() method until it
 * reaches the end of the file (when readLine() returns null). Each line is then
 * printed to the console.
 * 
 * Remember to replace "path/to/file.txt" with the actual file path you want to
 * read. Also, handle the IOException that may occur during the file reading
 * process.
 * 
 * @author engels
 *
 */
public class FileReadExample {
	public static void main(String[] args) {
		String filePath = "file.txt";

		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}

			bufferedReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

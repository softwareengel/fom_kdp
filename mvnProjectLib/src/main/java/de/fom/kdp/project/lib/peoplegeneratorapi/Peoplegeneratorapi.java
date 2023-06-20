package de.fom.kdp.project.lib.peoplegeneratorapi;

import java.net.http.*;
import java.net.URI;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * simple api client for https://peoplegeneratorapi.live/api/person/
 * 
 * @author engels
 * 
 * @see <a href="https://peoplegeneratorapi.live/get-started"></a>
 */
public class Peoplegeneratorapi {

	private static String decompressGzip(byte[] compressedData) {
		try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
			return new String(gis.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

//	public static void main(String[] args) throws IOException, InterruptedException {
//		getPeople(5);
//	}

	/**
	 * 
	 * @param anzahl
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String getPeople(int anzahl) throws IOException, InterruptedException {
		int retrycount = 15; // max 15 retries
		String json = null;
		while (json == null && retrycount-- > 0) {

			HttpClient client = HttpClient.newHttpClient();

			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://peoplegeneratorapi.live/api/person/" + anzahl)).GET().build();

			HttpResponse<byte[]> response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

			json = decompressGzip(response.body());
			if (json == null) {
				Thread.sleep(500);
				System.out.println("Retry: " + retrycount);
			}
		}
		System.out.println(retrycount + ": " + json);

		return json;
	}
}
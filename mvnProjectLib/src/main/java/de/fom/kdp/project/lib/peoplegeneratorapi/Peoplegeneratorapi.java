package de.fom.kdp.project.lib.peoplegeneratorapi;

import java.net.http.*;
import java.net.URI;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * A simple API client for interacting with the People Generator API at <a href=
 * "https://peoplegeneratorapi.live/api/person/">https://peoplegeneratorapi.live/api/person/</a>.
 * 
 * <p>
 * This class provides a method to fetch generated people data in JSON format
 * from the API. It handles retries for failed requests and decompresses
 * GZIP-compressed responses.
 * </p>
 * 
 * <p>
 * <strong>Note:</strong> This class is marked as {@link Deprecated} and should
 * not be used in production.
 * </p>
 * 
 * @author engels
 * @see <a href="https://peoplegeneratorapi.live/get-started">People Generator
 *      API Documentation</a>
 * @deprecated This class is deprecated and may be removed or replaced in future
 *             versions.
 */
@Deprecated
public class Peoplegeneratorapi {
	/**
	 * Decompresses a GZIP-compressed byte array into a UTF-8 encoded string.
	 * 
	 * @param compressedData the byte array containing GZIP-compressed data.
	 * @return the decompressed string, or {@code null} if decompression fails.
	 */
	private static String decompressGzip(byte[] compressedData) {
		try (GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressedData))) {
			return new String(gis.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Fetches a specified number of generated people from the People Generator API.
	 * 
	 * <p>
	 * The method attempts to retrieve the data with a maximum of 15 retries in case
	 * of failures. The API response is expected to be GZIP-compressed, and this
	 * method decompresses it.
	 * </p>
	 * 
	 * @param anzahl the number of generated people to fetch.
	 * @return a JSON string containing the generated people data, or {@code null}
	 *         if the request fails after retries.
	 * @throws IOException          if an I/O error occurs during the HTTP request
	 *                              or response handling.
	 * @throws InterruptedException if the operation is interrupted during
	 *                              execution.
	 * @deprecated This method is deprecated and may be removed or replaced in
	 *             future versions.
	 */
	@Deprecated
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
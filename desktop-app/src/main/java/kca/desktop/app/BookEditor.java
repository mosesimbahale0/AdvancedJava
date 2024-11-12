package kca.desktop.app;

import com.google.gson.Gson;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class BookEditor {

    private static final String API_URL = "http://localhost:9000/api/books";
    private static final Gson gson = new Gson();

    // Add a new book
    public static boolean addBook(Book book) {
        return sendRequest(API_URL, "POST", gson.toJson(book));
    }

    // Update an existing book by ID
    public static boolean updateBook(Long id, Book bookDetails) {
        String urlWithId = API_URL + "/" + id;
        return sendRequest(urlWithId, "PUT", gson.toJson(bookDetails));
    }

    // Delete a book by ID
    public static boolean deleteBook(Long id) {
        String urlWithId = API_URL + "/" + id;
        return sendRequest(urlWithId, "DELETE", null);
    }

    // Helper method to handle API requests
    private static boolean sendRequest(String urlString, String requestMethod, String jsonInputString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // If there is data to send, write it to the request body
            if (jsonInputString != null) {
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = jsonInputString.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            // Read the response to confirm success or failure
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                System.out.println("Request was successful.");
                return true;
            } else {
                System.out.println("Request failed with response code: " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Exception during request: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Indicate failure
    }
}

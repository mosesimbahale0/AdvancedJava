package kca.desktop.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookDeleter {
    private static final String API_URL = "http://localhost:9000/api/books/";

    public static boolean deleteBook(Long bookId) {
        try {
            URL url = new URL(API_URL + bookId);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            // Log the URL being hit for debugging
            System.out.println("Sending DELETE request to: " + url);

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode); // Log the response code

            if (responseCode == HttpURLConnection.HTTP_NO_CONTENT || responseCode == HttpURLConnection.HTTP_OK) {
                // Success - no content (204) or OK (200)
                System.out.println("Book deleted successfully.");
                return true;
            } else {
                // Handle error response codes
                System.out.println("Failed to delete book. Response code: " + responseCode);

                // Check if the error stream exists before reading
                InputStream errorStream = conn.getErrorStream();
                if (errorStream != null) {
                    BufferedReader in = new BufferedReader(new InputStreamReader(errorStream));
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    System.out.println("Error Response: " + response.toString());
                } else {
                    System.out.println("No error details available.");
                }
            }
        } catch (Exception e) {
            // Log any exception that occurs
            System.err.println("Exception during book deletion: " + e.getMessage());
            e.printStackTrace();
        }
        return false;  // Indicate failure
    }
}

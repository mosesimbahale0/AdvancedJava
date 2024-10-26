///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package kca.desktop.app;
//
///**
// *
// * @author personal
// */
//public class BookAdder {
//    
//}
package kca.desktop.app;

import com.google.gson.Gson;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookAdder {

    private static final String API_URL = "http://localhost:9000/api/books";

    public static boolean addBook(Book book) {
        try {
            // Define the API URL
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);

            // Convert the Book object to JSON
            Gson gson = new Gson();
            String jsonInputString = gson.toJson(book);

            // Write the JSON input string to the request body
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Get the response code to determine if the request was successful
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_CREATED || responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Book added successfully.");
                return true;
            } else {
                System.out.println("Failed to add book. Response code: " + responseCode);
            }
        } catch (Exception e) {
            System.err.println("Exception during book addition: " + e.getMessage());
            e.printStackTrace();
        }
        return false; // Indicate failure
    }
}

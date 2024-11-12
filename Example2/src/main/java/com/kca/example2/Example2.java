import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Example2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/week5";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM books"; // Replace 'books' with your table name
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                System.out.println("Book ID: " + resultSet.getInt("id"));
                System.out.println("Title: " + resultSet.getString("title"));
                System.out.println("Author: " + resultSet.getString("author"));
                System.out.println("--------------------");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
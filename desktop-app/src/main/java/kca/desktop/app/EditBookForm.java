package kca.desktop.app;

import javax.swing.*;
import java.awt.*;

public class EditBookForm extends JFrame {
    
    private Integer bookId; // Or use Book book if you need more details

    public EditBookForm(Integer bookId) {
        this.bookId = bookId;
        setTitle("Edit Book"); 
        setSize(400, 300); 
        setLocationRelativeTo(null); // Center the form on the screen
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        loadBookData();
    }

    private void initComponents() {
        // Create components (text fields, labels, buttons, etc.)
        JLabel titleLabel = new JLabel("Edit Book");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Styling title

        JLabel nameLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField(20);

        JLabel priceLabel = new JLabel("Price:");
        JTextField priceField = new JTextField(10);

        JButton saveButton = new JButton("Save");
        saveButton.setFont(new Font("Arial", Font.BOLD, 14)); // Button styling
        saveButton.setPreferredSize(new Dimension(100, 30)); // Button size

        // Padding and margins setup
        int marginSize = 20;

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize)); // Adding margins
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Layout with vertical alignment
        
        // Add components to the panel with padding
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Vertical padding between components

        panel.add(nameLabel);
        panel.add(titleField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Padding

        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Padding

        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Padding

        panel.add(saveButton);
        
        // Add the panel to the frame
        add(panel);

        // Save button action
        saveButton.addActionListener(e -> {
            // Implement save logic here
            // Update the book with the new data and save changes
            JOptionPane.showMessageDialog(this, "Book details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    private void loadBookData() {
        // Fetch the book details using bookId and populate form fields
        // Simulated data load for now
        System.out.println("Loading data for book ID: " + bookId);
    }

    public static void main(String[] args) {
        // Example usage
        EditBookForm editBookForm = new EditBookForm(1); // Simulating book with ID 1
        editBookForm.setVisible(true);
    }
}

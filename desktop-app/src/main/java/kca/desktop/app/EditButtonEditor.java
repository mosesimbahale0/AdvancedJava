package kca.desktop.app;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EditButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JButton button;
    private int row;
    private JTable table;
    private List<Book> books;
    private BookTableModel tableModel;
    private boolean isEditMode; // New field to handle the mode

    public EditButtonEditor(JTable table, List<Book> books, BookTableModel tableModel, boolean isEditMode) {
        this.table = table;
        this.books = books;
        this.tableModel = tableModel;
        this.isEditMode = isEditMode; // Assign the boolean value
        button = new JButton("Edit"); // Render the "Edit" button
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;  // Return the button component for rendering
    }

    @Override
    public Object getCellEditorValue() {
        return "Edit";  // Return the text of the button when it's clicked
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Open an edit dialog only if in edit mode (optional check)
        if (isEditMode) {
            Book book = books.get(row);
            showEditDialog(book);
        }
        stopCellEditing();  // Stop editing the cell after the button is clicked
    }

    private void showEditDialog(Book book) {
        // Create and display the edit dialog with book details
        JTextField titleField = new JTextField(book.getTitle());
        JTextField authorField = new JTextField(book.getAuthor());
        JTextField descriptionField = new JTextField(book.getDescription());
        JTextField priceField = new JTextField(String.valueOf(book.getPrice()));
        JTextField imgField = new JTextField(book.getImg());
        JTextField ratingField = new JTextField(String.valueOf(book.getRating()));
        JTextField stockField = new JTextField(String.valueOf(book.getStock()));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Author:"));
        panel.add(authorField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Image URL:"));
        panel.add(imgField);
        panel.add(new JLabel("Rating:"));
        panel.add(ratingField);
        panel.add(new JLabel("Stock:"));
        panel.add(stockField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Book", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            // Update the book object with new values
            book.setTitle(titleField.getText());
            book.setAuthor(authorField.getText());
            book.setDescription(descriptionField.getText());
            book.setPrice(Double.parseDouble(priceField.getText()));
            book.setImg(imgField.getText());
            book.setRating(Integer.parseInt(ratingField.getText()));
            book.setStock(Integer.parseInt(stockField.getText()));

            // Update the table model to reflect changes in the JTable
            tableModel.fireTableRowsUpdated(row, row);
        }
    }
}

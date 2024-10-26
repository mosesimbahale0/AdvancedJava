//package kca.desktop.app;
//
//import javax.swing.*;
//import javax.swing.table.TableCellEditor;
//import java.awt.Component;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//
//public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
//
//    private JButton button;
//    private int row;
//    private JTable table;
//    private List<Book> books;
//    private BookTableModel tableModel;
//    private boolean clicked = false;  // Add a flag to track if the button has been clicked
//
//    public ButtonEditor(JTable table, List<Book> books, BookTableModel tableModel) {
//        this.table = table;
//        this.books = books;
//        this.tableModel = tableModel;
//        button = new JButton("Delete");
//        button.addActionListener(this);
//    }
//
//    @Override
//    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        this.row = row;
//        this.clicked = false;  // Reset the flag when a new editor component is created
//        return button;
//    }
//
//    @Override
//    public Object getCellEditorValue() {
//        return "Delete";
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        // Ensure the action is only performed once
//        if (clicked) {
//            return;  // If already clicked, do nothing
//        }
//
//        clicked = true;  // Set flag to indicate the button was clicked
//
//        // Get the book to delete
//        Book book = books.get(row);
//        Long bookId = Long.valueOf(book.getId());  // Convert int to Long if necessary
//
//        // Call the backend API to delete the book
//        boolean isDeleted = BookDeleter.deleteBook(bookId);  // Ensure deleteBook returns a boolean
//
//        if (isDeleted) {
//            // If successful, remove the book from the table model
//            tableModel.removeBook(row);
//            table.revalidate();
//            table.repaint();
//        } else {
//            // If failed, show an error dialog
//            JOptionPane.showMessageDialog(table, "Failed to delete the book from the server.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//
//        // Stop editing the cell to prevent further actions
//        stopCellEditing();
//    }
//
//    @Override
//    public boolean stopCellEditing() {
//        clicked = false;  // Reset the flag for future interactions
//        return super.stopCellEditing();
//    }
//}
package kca.desktop.app;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {

    private JButton button;
    private int row;
    private JTable table;
    private List<Book> books;
    private BookTableModel tableModel;

    public ButtonEditor(JTable table, List<Book> books, BookTableModel tableModel) {
        this.table = table;
        this.books = books;
        this.tableModel = tableModel;
        button = new JButton("Delete"); // Render the "Delete" button
        button.addActionListener(this);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        return button;  // Return the button component for rendering
    }

    @Override
    public Object getCellEditorValue() {
        return "Delete";  // Return the text of the button when it's clicked
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // No deletion logic here. The deletion will be handled in the Dashboard.
        stopCellEditing();  // Stop editing the cell after the button is clicked
    }
}

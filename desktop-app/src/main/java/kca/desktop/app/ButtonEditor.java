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

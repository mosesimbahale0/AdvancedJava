package kca.desktop.app;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {

    private final List<Book> books;
    private final String[] columnNames = {
        "ID", "Title", "Author", "Description", "Price", "Create Time", "Image", "Rating", "Stock", "Delete"
    };

    public BookTableModel(List<Book> books) {
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = books.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return book.getId();
            case 1:
                return book.getTitle();
            case 2:
                return book.getAuthor();
            case 3:
                return book.getDescription();
            case 4:
                return book.getPrice();
            case 5:
                return book.getCreateTime();
            case 6:
                return book.getImg();
            case 7:
                return book.getRating();
            case 8:
                return book.getStock();  // Stock column (no "Delete" button here)
            case 9:
                return "Delete";  // Text for the delete button in the "Delete" column
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Only the "Delete" column (index 9) should be editable
        return column == 9;
    }

    /**
     * Method to remove a book from the model.
     *
     * @param rowIndex the row index of the book to remove.
     */
    public void removeBook(int rowIndex) {
        books.remove(rowIndex); // Remove the book from the list
        fireTableRowsDeleted(rowIndex, rowIndex); // Notify the table that the row was deleted
    }

    /**
     * Optional: Method to add a book to the model (in case you want to add
     * books dynamically).
     *
     * @param book the book to add.
     */
    public void addBook(Book book) {
        books.add(book); // Add the new book to the list
        fireTableRowsInserted(books.size() - 1, books.size() - 1); // Notify the table of the new row
    }

    /**
     * Method to handle the delete action when the "Delete" column is clicked.
     * This will trigger the back-end delete call and remove the book from the
     * table.
     *
     * @param rowIndex the row index of the book to delete.
     */
    public void handleDeleteAction(int rowIndex) {
        Book book = books.get(rowIndex); // Get the book to delete

        Long bookId = Long.valueOf(book.getId());

        // Call the backend API to delete the book
        BookDeleter.deleteBook(bookId);

        // Remove the book from the list and update the table
        removeBook(rowIndex);
    }
}

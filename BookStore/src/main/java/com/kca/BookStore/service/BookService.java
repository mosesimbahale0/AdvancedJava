package com.kca.BookStore.service;

import com.kca.BookStore.entity.Book;  // Import the Book entity
import com.kca.BookStore.repository.BookRepository;  // Import the BookRepository for database interaction
import org.springframework.beans.factory.annotation.Autowired;  // Import for automatic dependency injection
import org.springframework.stereotype.Service;  // Import for marking this class as a service layer

import java.util.List;

@Service  // Marks this class as a Spring service, allowing it to be injected into other components
public class BookService {

    @Autowired  // Automatically injects an instance of BookRepository
    private BookRepository bookRepository;

    // Method to find all books in the repository (database)
    public List<Book> findAll() {
        return bookRepository.findAll();  // Returns a list of all books from the database
    }

    // Method to save a new book to the repository
    public Book save(Book book) {
        return bookRepository.save(book);  // Saves the book entity to the database and returns the saved book
    }

    // Method to update an existing book by its ID
    public Book update(Long id, Book bookDetails) {
        // Find the book by its ID, or throw an exception if the book isn't found
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));

        // Update the book's properties with the new details
        book.setTitle(bookDetails.getTitle());  // Update the title
        book.setAuthor(bookDetails.getAuthor());  // Update the author
        book.setDescription(bookDetails.getDescription());  // Update the description
        book.setCreatedAt(bookDetails.getCreatedAt());  // Update the createdAt timestamp
        book.setImg(bookDetails.getImg());  // Update the image URL or path
        book.setRating(bookDetails.getRating());  // Update the rating
        book.setPrice(bookDetails.getPrice());  // Update the price
        book.setStock(bookDetails.getStock());  // Update the stock quantity

        // Save the updated book to the database and return it
        return bookRepository.save(book);
    }

    // Method to delete a book by its ID
    public void delete(Long id) {
        bookRepository.deleteById(id);  // Deletes the book from the database based on the given ID
    }
}

//@Service: Marks the class as a service layer, part of the business logic in a Spring application.
//@Autowired: Injects dependencies automatically, allowing Spring to manage the BookRepository without needing to instantiate it manually.
//findAll(): Retrieves all books from the database.
//save(): Saves a new book or updates an existing book in the database.
//update(): Finds a book by its ID and updates its properties with the new values from bookDetails.
//delete(): Deletes a book by its ID from the database.

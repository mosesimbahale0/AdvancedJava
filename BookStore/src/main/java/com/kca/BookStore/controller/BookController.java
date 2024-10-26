package com.kca.BookStore.controller;

import com.kca.BookStore.entity.Book;  // Importing the Book entity class
import com.kca.BookStore.service.BookService;  // Importing the BookService class for business logic
import org.springframework.beans.factory.annotation.Autowired;  // Enables dependency injection
import org.springframework.web.bind.annotation.*;  // Enables REST API annotations

import java.util.List;

@RestController  // Indicates that this class is a REST controller, handling HTTP requests
@RequestMapping("/api/books")  // Maps the controller to handle requests that start with "/api/books"
public class BookController {

    @Autowired  // Injects an instance of BookService to handle business logic related to books
    private BookService bookService;

    // HTTP GET method to retrieve all books
    @GetMapping  // Maps this method to handle GET requests at "/api/books"
    public List<Book> getAllBooks() {
        return bookService.findAll();  // Calls the service method to return a list of all books
    }

    // HTTP POST method to create a new book
    @PostMapping  // Maps this method to handle POST requests at "/api/books"
    public Book createBook(@RequestBody Book book) {
        return bookService.save(book);  // Calls the service method to save the book and return the saved book object
    }

    // HTTP PUT method to update an existing book by its ID
    @PutMapping("/{id}")  // Maps this method to handle PUT requests at "/api/books/{id}"
    public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        return bookService.update(id, bookDetails);  // Calls the service method to update the book details based on the given ID
    }

    // HTTP DELETE method to delete a book by its ID
    @DeleteMapping("/{id}")  // Maps this method to handle DELETE requests at "/api/books/{id}"
    public void deleteBook(@PathVariable Long id) {
        bookService.delete(id);  // Calls the service method to delete the book with the given ID
    }
}

//
//@RestController: Marks this class as a RESTful web service controller, handling HTTP requests and returning JSON responses.
//@RequestMapping("/api/books"): Defines the base URL for all methods in this controller (/api/books).
//@Autowired: Injects the BookService object so that the controller can delegate business logic to it.
//@GetMapping: This annotation handles HTTP GET requests. The method getAllBooks() retrieves a list of all books.
//@PostMapping: Handles HTTP POST requests to create a new book. The @RequestBody annotation binds the incoming request body (JSON) to the Book object.
//@PutMapping("/{id}"): Handles HTTP PUT requests for updating an existing book. The @PathVariable is used to get the id from the URL path, and @RequestBody binds the request body to the bookDetails.
//@DeleteMapping("/{id}"): Handles HTTP DELETE requests to remove a book by its id. The @PathVariable annotation is used to extract the id from the URL path.
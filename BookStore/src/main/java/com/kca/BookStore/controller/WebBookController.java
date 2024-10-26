package com.kca.BookStore.controller;

import com.kca.BookStore.entity.Book;  // Importing the Book entity class
import com.kca.BookStore.service.BookService;  // Importing the BookService class to handle business logic
import org.springframework.beans.factory.annotation.Autowired;  // Enables dependency injection
import org.springframework.stereotype.Controller;  // Marks this class as a Spring MVC controller
import org.springframework.ui.Model;  // Provides a container to hold model attributes for the view
import org.springframework.web.bind.annotation.GetMapping;  // Handles HTTP GET requests

import java.util.List;

@Controller  // Marks the class as a Spring MVC controller responsible for handling web page requests
public class WebBookController {

    @Autowired  // Injects an instance of BookService to handle business logic related to books
    private BookService bookService;

    // HTTP GET method to fetch and display all books in a web view
    @GetMapping("/books")  // Maps this method to handle GET requests at "/books"
    public String getAllBooks(Model model) {
        // Fetches the list of all books from the service
        List<Book> books = bookService.findAll();

        // Adds the list of books to the model, making it available to the view (Thymeleaf template)
        model.addAttribute("books", books);

        // Returns the name of the view template (Thymeleaf template "bookList.html") to render the books
        return "bookList";  // Ensure "bookList" matches the name of the Thymeleaf template
    }
}


//@Controller: Marks this class as a Spring MVC controller that returns web views (HTML pages) rather than JSON responses.
//@Autowired: Injects the BookService to access business logic and interact with the book data.
//@GetMapping("/books"): Handles HTTP GET requests at the URL /books. This method is responsible for fetching and displaying all books.
//Model model: The Model object is used to pass data to the view. In this case, it's used to pass the list of books to the Thymeleaf template.
//        model.addAttribute("books", books): Adds the list of books to the model under the attribute name "books", so it can be accessed in the view (Thymeleaf).
//        return "bookList": Returns the name of the Thymeleaf template (without the .html extension) to render the list of books. Make sure you have a corresponding bookList.html file in your templates folder.
package com.kca.BookStore.repository;

import com.kca.BookStore.entity.Book;  // Importing the Book entity class
import org.springframework.data.jpa.repository.JpaRepository;  // Importing JpaRepository for basic CRUD operations

// This interface provides CRUD (Create, Read, Update, Delete) operations for the Book entity
public interface BookRepository extends JpaRepository<Book, Long> {
    // No need to implement anything here, JpaRepository provides common database operations by default
    // The JpaRepository interface is parameterized with the type of the entity (Book) and the type of the entity's primary key (Long)
}


//        JpaRepository<Book, Long>: Extending JpaRepository provides built-in methods to perform CRUD operations (e.g., findAll(), save(), deleteById()) for the Book entity. It handles all the database interactions for the Book class.
//        Book: The entity type that this repository manages.
//        Long: The type of the primary key of the Book entity.
//        You don't need to write custom methods unless you want to perform more specific queries. The JpaRepository interface already provides most of the basic operations.

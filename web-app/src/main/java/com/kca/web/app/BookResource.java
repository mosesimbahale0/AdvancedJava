package com.kca.web.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 * REST API resource for managing books.
 */
@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Retrieves all books.
     *
     * @return a list of books.
     */
    @GET
    public List<Book> getAllBooks() {
        return entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the ID of the book.
     * @return the book or a 404 response if not found.
     */
    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(book).build();
    }

    /**
     * Creates a new book.
     *
     * @param book the book to create.
     * @return a 201 response with the created book.
     */
    @POST
    @Transactional
    public Response createBook(Book book) {
        entityManager.persist(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    /**
     * Updates an existing book.
     *
     * @param id the ID of the book to update.
     * @param updatedBook the updated book details.
     * @return the updated book or a 404 response if not found.
     */
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateBook(@PathParam("id") Long id, Book updatedBook) {
        Book existingBook = entityManager.find(Book.class, id);
        if (existingBook == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setCreatedAt(updatedBook.getCreatedAt());
        existingBook.setImg(updatedBook.getImg());
        existingBook.setRating(updatedBook.getRating());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setStock(updatedBook.getStock());
        entityManager.merge(existingBook);
        return Response.ok(existingBook).build();
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete.
     * @return a 204 response if deleted, or 404 if not found.
     */
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteBook(@PathParam("id") Long id) {
        Book book = entityManager.find(Book.class, id);
        if (book == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        entityManager.remove(book);
        return Response.noContent().build();
    }
}

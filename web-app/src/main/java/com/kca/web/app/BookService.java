package com.kca.web.app;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BookService {

    private final EntityManagerFactory emf;

    public BookService() {
        this.emf = EMF.get();
    }

    public void addBook(Book book) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Book> getAllBooks() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.kca.web.app;
//
///**
// *
// * @author moses-imbahale
// */
//public class BookService {
//    
//}

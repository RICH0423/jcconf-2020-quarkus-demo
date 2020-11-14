package com.rich.quarkus.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author rich
 */
@ApplicationScoped
public class BookRepository {

    private static Logger logger = LoggerFactory.getLogger(BookRepository.class);

    private static final String FIND_BY_NAME_HQL = "FROM Book b WHERE b.name = ?1";

    @Inject
    private EntityManager em;

    @Transactional
    public Book createBook(String name, String isbn) {
        Book book = new Book(name, isbn);
        em.persist(book);
        return book;
    }

    @Transactional
    public void removeBook(long id) {
        Book book = find(id);
        em.remove(book);
    }

    public List<Book> findAll() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    public Book find(long id) {
        Book book = em.find(Book.class, id);
        if(book == null) {
            logger.warn("Book not found, id: {}", id);
            throw new EntityNotFoundException("Book not found, id: " + id);
        }

        return book;
    }

    public List<Book> findByName(String name) {
        return em.createQuery(FIND_BY_NAME_HQL, Book.class)
                .setParameter(1, name)
                .getResultList();
    }
}

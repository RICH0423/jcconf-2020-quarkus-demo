package com.rich.quarkus;

import com.rich.quarkus.repository.Book;
import com.rich.quarkus.repository.BookRepository;
import io.quarkus.test.Mock;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@Mock
@ApplicationScoped
public class MockBookRepository extends BookRepository {

    List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("Quarkus Cookbook", "1234"));
        books.add(new Book("Camel in Action", "2234"));
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book createBook(String name, String isbn) {
        Book book = new Book(name, isbn);
        books.add(book);
        return book;
    }

    @Override
    public void removeBook(long id) {
    }

    @Override
    public Book find(long id) {
        Book book = new Book("", "");
        book.setId(id);
        return book;
    }

}

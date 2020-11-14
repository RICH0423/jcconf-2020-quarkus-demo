package com.rich.quarkus;

import com.rich.quarkus.repository.Book;
import com.rich.quarkus.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    private static Logger logger = LoggerFactory.getLogger(BookResource.class);

    @Inject
    BookRepository bookRepository;

    @GET
    @Path("/info")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello Quarkus";
    }

    @POST
    public Book createBook(Book book) {
        return bookRepository.createBook(book.getName(), book.getIsbn());
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") long id) {
        bookRepository.removeBook(id);
    }

    @GET
    public List<Book> list() {
        List<Book> books = bookRepository.findAll();
        logger.info("get all books: {}", books);
        return books;
    }

    @GET
    @Path("/{id}")
    public Book get(@PathParam("id") long id) {
        return bookRepository.find(id);
    }

}
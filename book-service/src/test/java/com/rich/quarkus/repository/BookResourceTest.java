package com.rich.quarkus.repository;

import com.rich.quarkus.repository.Book;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void whenGetAllBooks_thenResponseShouldNotBeEmpty() {
        given()
                .when().get("/books")
                .then()
                .statusCode(200)
                .body(is(not(empty())));
    }

    @Test
    public void whenCreateBook_thenShouldReturnSuccessfully() {
        String bookName = "quarkus cookbook";
        String bookISBN = "1234";

        given()
                .contentType(ContentType.JSON)
                .body(new Book(bookName, bookISBN))
                .when().post("/books")
                .then()
                .statusCode(200)
                .body("name", is(bookName))
                .body("isbn", is(bookISBN));
    }

}
package com.rich.quarkus;

import com.rich.quarkus.repository.User;
import com.rich.quarkus.repository.UserRepository;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@QuarkusTest
public class UserResourceTest {

    @InjectMock
    UserRepository userRepository;

    @Test
    public void whenGetAllUsers_thenResponseShouldNotBeEmpty() {
        when(userRepository.getAll()).thenReturn(
                List.of(new User("rich", 30)));

        given()
          .when().get("/users")
          .then()
             .statusCode(200)
             .body(is(not(empty())));
    }

    @Test
    public void whenCreateUser_thenShouldReturnSuccessfully() {
        User user = new User("rich", 30);
        doNothing().when(userRepository).create(user);

        given()
                .contentType(ContentType.JSON)
                .body(user)
                .when().post("/users")
                .then()
                .statusCode(200)
                .body(is(not(empty())));
    }
}
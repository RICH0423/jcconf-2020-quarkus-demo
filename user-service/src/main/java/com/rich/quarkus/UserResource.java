package com.rich.quarkus;

import com.rich.quarkus.repository.User;
import com.rich.quarkus.repository.UserRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    public List<User> list() {
        return userRepository.getAll();
    }

    @POST
    public List<User> add(User user) {
        userRepository.create(user);
        return list();
    }
}
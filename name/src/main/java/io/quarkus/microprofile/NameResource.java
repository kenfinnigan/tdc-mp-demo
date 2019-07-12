package io.quarkus.microprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class NameResource {

    @GET
    @Path("name")
    @Produces(MediaType.APPLICATION_JSON)
    public Name name() {
        return new Name("Nobody");
    }
}

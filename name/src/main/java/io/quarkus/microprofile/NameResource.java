package io.quarkus.microprofile;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

@Path("/")
public class NameResource {

    @ConfigProperty(name = "app.greeting", defaultValue = "Edson")
    String name;

    @GET
    @Path("name")
    @Produces(MediaType.APPLICATION_JSON)
    public Name name(@Context SecurityContext context) {
        Principal caller = context.getUserPrincipal();
        return caller != null ? new Name(caller.getName()) : new Name(name);
    }
}

package io.quarkus.microprofile;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
@Path("/")
@RegisterClientHeaders
public interface NameService {
    @GET
    @Path("name")
    @Produces(MediaType.APPLICATION_JSON)
    Name name();
}

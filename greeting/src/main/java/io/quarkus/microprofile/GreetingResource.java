package io.quarkus.microprofile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {

    @GET
    @Path("greeting")
    @Produces(MediaType.APPLICATION_JSON)
    public Greeting greeting() {
        return new Greeting("Hello World");
    }

    public class Greeting {
        private String greeting;

        public Greeting(String greeting) {
            this.greeting = greeting;
        }

        public String getGreeting() {
            return greeting;
        }
    }
}

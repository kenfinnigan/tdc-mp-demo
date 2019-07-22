package io.quarkus.microprofile;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class GreetingResource {
    @Inject
    @RestClient
    NameService nameService;

    @GET
    @Path("greeting")
    @Produces(MediaType.APPLICATION_JSON)
    @Timed
    @Counted(monotonic = true, name = "counted")
    @Fallback(fallbackMethod = "greetingFailure")
    public Greeting greeting() {
        return new Greeting("Hello " + nameService.name().getName());
    }

    private Greeting greetingFailure() {
        return new Greeting("Hello from Fallback");
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

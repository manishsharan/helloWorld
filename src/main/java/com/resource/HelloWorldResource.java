package com.resource;

import com.google.common.base.Joiner;
import com.configuration.HelloWorldConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final HelloWorldConfiguration helloWorldConfiguration;
    private final AtomicLong counter;

    public HelloWorldResource(String template, HelloWorldConfiguration helloWorldConfiguration) {
        this.template = template;
        this.helloWorldConfiguration = helloWorldConfiguration;
        this.counter = new AtomicLong();
    }

    @GET
    public Response sayHello() {
        return Response.status(Response.Status.OK).entity(Joiner.on(",").join(template, helloWorldConfiguration.getDefaultName())).build();

    }
}
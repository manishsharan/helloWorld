package com.resource;

import com.dao.HelloWorldDAO;
import com.google.common.base.Joiner;
import com.configuration.HelloWorldConfiguration;
import com.impl.HelloWorldImpl;
import com.impl.IHelloWorld;
import com.yammer.dropwizard.hibernate.UnitOfWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/application")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final HelloWorldConfiguration helloWorldConfiguration;
    private IHelloWorld iHelloWorld;
    private final HelloWorldDAO helloWorldDAO;

    public HelloWorldResource(HelloWorldConfiguration helloWorldConfiguration, HelloWorldDAO helloWorldDAO) {
        this.helloWorldConfiguration = helloWorldConfiguration;
        this.iHelloWorld = new HelloWorldImpl();
        this.helloWorldDAO = helloWorldDAO;
    }

    @GET
    @UnitOfWork
    public Response testDbConnection(){
        return Response.status(Response.Status.OK).entity(iHelloWorld.fetchTestData(helloWorldDAO)).build();
    }
}
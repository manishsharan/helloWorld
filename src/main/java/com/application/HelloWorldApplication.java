package com.application;


import com.dao.HelloWorldDAO;
import com.database.model.Test1;
import com.google.common.collect.ImmutableList;
import com.configuration.HelloWorldConfiguration;
import com.database.HibernateSessionFactoryFactory;
import com.resource.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import com.yammer.dropwizard.hibernate.HibernateBundle;
import com.yammer.metrics.core.HealthCheck;

public class HelloWorldApplication extends Service<HelloWorldConfiguration> {

    final HibernateBundle<HelloWorldConfiguration> hibernateBundle = new HibernateBundle<HelloWorldConfiguration>(
            ImmutableList.<Class<?>>builder().add(Test1.class).build(),
            new HibernateSessionFactoryFactory()) {
        public DatabaseConfiguration getDatabaseConfiguration(HelloWorldConfiguration helloWorldConfiguration) {
            return helloWorldConfiguration.getDatabase();
        }
    };

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.setName("application-world");
    }

    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        environment.addResource(new HelloWorldResource(helloWorldConfiguration, new HelloWorldDAO(hibernateBundle.getSessionFactory())));
        environment.addHealthCheck(new HealthCheck("template") {
            @Override
            protected Result check() throws Exception {
                return null;
            }
        });
    }
}
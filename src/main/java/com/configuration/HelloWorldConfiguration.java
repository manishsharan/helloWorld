package com.configuration;

import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloWorldConfiguration extends Configuration {
    private String defaultName = "Stranger";

    private DatabaseConfiguration database = new DatabaseConfiguration();

}
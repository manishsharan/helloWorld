package com.impl;

import com.dao.HelloWorldDAO;
import com.database.model.Test1;

import java.util.List;
import java.util.Map;

/**
 * Created by manish.sharan on 10/09/16.
 */
public class HelloWorldImpl implements IHelloWorld {
    @Override
    public List<Test1> fetchTestData(HelloWorldDAO helloWorldDAO) {
        return helloWorldDAO.getHelloWorldDetails();
    }
}

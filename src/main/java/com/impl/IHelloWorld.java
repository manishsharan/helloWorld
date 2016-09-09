package com.impl;

import com.dao.HelloWorldDAO;
import com.database.model.Test1;

import java.util.List;

/**
 * Created by manish.sharan on 10/09/16
 */
public interface IHelloWorld {

    List<Test1> fetchTestData(HelloWorldDAO helloWorldDAO);
}

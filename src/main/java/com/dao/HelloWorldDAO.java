package com.dao;

import com.database.model.Test1;
import com.google.common.collect.Lists;
import com.yammer.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by manish.sharan on 10/09/16.
 */
public class HelloWorldDAO extends AbstractDAO<Test1> {

    public HelloWorldDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<Test1> getHelloWorldDetails() {
        Criteria criteria = currentSession().createCriteria(Test1.class);
        return criteria.list();
    }
}

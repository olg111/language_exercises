package com.olga.spring.my_first_mvc.dao.topics;


import com.olga.spring.my_first_mvc.dao.topics.TopicsDAO;
import com.olga.spring.my_first_mvc.entity.Topics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // спациализированный @Component
public class TopicsDAOImpl implements TopicsDAO {


    @Autowired
    private SessionFactory sessionFactory;
    // creating beans from applicationContext. to create session.to work with the database


    @Override

    public List<Topics> getAllTopics() {
        Session session = sessionFactory.getCurrentSession();

        Query<Topics> query = session.createQuery("from Topics", Topics.class);
        List<Topics> allTopics =  query.getResultList();
        return allTopics;
    }
}

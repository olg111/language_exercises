package com.olga.spring.my_first_mvc.dao.topics;


import com.olga.spring.my_first_mvc.dao.topics.TopicsDAO;
import com.olga.spring.my_first_mvc.entity.Topics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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


    @Override
    public void saveTopic(Topics topics) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(topics);
    }

    @Override
    public Topics getTopic(int id) {
        Session session= sessionFactory.getCurrentSession();
        Topics topics = session.get(Topics.class, id);
        return topics;
    }

    @Override
    public void deleteTopic(int id) {
        Session session= sessionFactory.getCurrentSession();
        Query<Topics> query = session.createQuery("delete from Topics where id=:topicId");
        query.setParameter("topicId", id);
        query.executeUpdate();
    }


}

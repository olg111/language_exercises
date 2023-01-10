package com.olga.spring.my_first_mvc.dao.sentences;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Sentences;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // спациализированный @Component
public class SentencesDAOImpl implements SentencesDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Sentences> getAllSentences() {
        Session session = sessionFactory.getCurrentSession();
        Query<Sentences> query = session.createQuery("from Sentences", Sentences.class);
        List<Sentences> allSentences = query.getResultList();

        return allSentences;
    }

    @Override
    public List<Sentences> getSentenceByExId(int exerciseId) {
        Session session = sessionFactory.getCurrentSession();

        Query<Sentences> query = session.createQuery("from Sentences " +
                "where exercise.id = '"+exerciseId+"'", Sentences.class);
        List<Sentences> allSentencesById = query.getResultList();
        return allSentencesById;

    }

    @Override
    public void saveSentence(Sentences sentences) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(sentences);
    }

    @Override
    public Sentences getSentence(int id) {
        Session session = sessionFactory.getCurrentSession();
        Sentences sentences = session.get(Sentences.class, id);
        return  sentences;
    }

    @Override
    public void deleteSentence(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Sentences> query = session.createQuery("delete from Sentences where id=:sentenceId");
        query.setParameter("sentenceId", id);
        query.executeUpdate();

    }
    // creating beans from applicationContext. to create session.to work with the database



}

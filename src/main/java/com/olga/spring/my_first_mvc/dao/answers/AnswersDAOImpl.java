package com.olga.spring.my_first_mvc.dao.answers;

import com.olga.spring.my_first_mvc.entity.Answers;
import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.service.sentences.SentencesService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // спациализированный @Component
public class AnswersDAOImpl implements AnswersDAO{

    @Autowired
    private SessionFactory sessionFactory;
    // creating beans from applicationContext. to create session.to work with the database


    @Override
    public List<Answers> getAllAnswers() {
        Session session = sessionFactory.getCurrentSession();

        Query<Answers> query = session.createQuery("from Answers", Answers.class);
        List<Answers> allAnswers =  query.getResultList();
        return allAnswers;
    }

    @Override
    public void saveAnswers(Answers answers) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(answers);

    }

    @Override
    public Answers getAnswer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Answers answers = session.get(Answers.class, id);
        return answers;
    }

    @Override
    public void deleteAnswerBySentenceId (int sentenceId) {
        Session session= sessionFactory.getCurrentSession();
        Query<Answers> query = session.createQuery("delete from Answers where sentence.id=:sentenceId");
        query.setParameter("sentenceId", sentenceId);
        query.executeUpdate();

    }

}

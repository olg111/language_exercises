package com.olga.spring.my_first_mvc.dao.exercises;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository  // спациализированный @Component
public class ExercisesDAOImpl implements ExercisesDAO {


    @Autowired
    private SessionFactory sessionFactory;
    // creating beans from applicationContext. to create session.to work with the database


    @Override

    public List<Exercises> getAllExercises() {
        Session session = sessionFactory.getCurrentSession();

        Query<Exercises> query = session.createQuery("from Exercises", Exercises.class);
        List<Exercises> allExercises =  query.getResultList();
        return allExercises;
    }
}

package com.olga.spring.my_first_mvc.service.exercises;


import com.olga.spring.my_first_mvc.dao.exercises.ExercisesDAO;
import com.olga.spring.my_first_mvc.entity.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ExercisesServiceImpl implements ExercisesService {

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private ExercisesDAO exercisesDAO;


    @Override
    @Transactional
    public List<Exercises> getAllExercises() {
        return exercisesDAO.getAllExercises();
    }

    @Override
    @Transactional
    public void saveExercise(Exercises exercises) {
        exercisesDAO.saveExercise(exercises);

    }

    @Override
    @Transactional
    public Exercises getExercise(int id) {

        return exercisesDAO.getExercise(id);
    }

    @Override
    @Transactional
    public void deleteExercise(int id) {
        exercisesDAO.deleteExercise(id);

    }
}

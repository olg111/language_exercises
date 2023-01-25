package com.olga.spring.my_first_mvc.dao.exercises;

import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;

import java.util.List;

public interface ExercisesDAO {

//    public List<Exercises> getAllExercises();

    public List<Exercises> getExercisesById(int topicId); //

    public void saveExercise(Exercises exercises);

    public Exercises getExercise(int id);

    public void deleteExercise(int id);


}

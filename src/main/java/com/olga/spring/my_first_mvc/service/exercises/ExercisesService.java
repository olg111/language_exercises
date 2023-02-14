package com.olga.spring.my_first_mvc.service.exercises;

import com.olga.spring.my_first_mvc.entity.Exercises;

import java.util.List;

public interface ExercisesService {

    public List<Exercises> getExercisesById(int topicId); //

    public  void saveExercise(Exercises exercises);

    public Exercises getExercise(int id);

    public  void deleteExercise(int id);

}

package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ExerciseController {

    @Autowired
    private TopicsService topicsService;

    @Autowired
    private ExercisesService exercisesService;



    @RequestMapping("/")
    public String showAllTopics(Model model){

        List<Topics> allTopics =topicsService.getAllTopics();
        model.addAttribute("allTop", allTopics);

        return "all-topics";
//         чтобы view мог отобразить значения полей "темы" нужно в методе контроллера создать model
//          и добавить темы в качестве атрибутов этой модели
    }


//    @RequestMapping("/exerciseNames")
//    public String showExerciseNames(Model model){
//
//        List<Exercises> allExerciseNames = exercisesService.getAllExercises();
//        model.addAttribute("allEx", allExerciseNames);
//
//        return "all-exercise-names";
////         чтобы view мог отобразить значения полей "темы" нужно в методе контроллера создать model
////          и добавить темы в качестве атрибутов этой модели
//    }

    @RequestMapping("/exercisesByTopic/{topicId}")
    public String showExercisesByTopic(@PathVariable int topicId) {
        System.out.println(topicId);

//

//        Exercises exercises = exercisesService.getAllExercises().get(id);

        return "all-exercise-names";
    }



}

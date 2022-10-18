package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExerciseController {



    @Autowired
    private ExercisesService exercisesService;

//    @Autowired
//    private Topics topics;

    List<Exercises> allExercises;
    List<Exercises> exercisesById;

//    @RequestMapping("/showExercises")
//    public String showAllExercises(Model model){
//
//        allExercises =exercisesService.getAllExercises();
//        model.addAttribute("allEx", allExercises);
//
//        return "all-exercise-names";
////         чтобы view мог отобразить значения полей "темы" нужно в методе контроллера создать model
////          и добавить темы в качестве атрибутов этой модели
//    }

        @RequestMapping("/showExercises/{topicId}")
    public String showExercisesByTopic(@PathVariable int topicId, Model model) {
            exercisesById = exercisesService.getExercisesById(topicId);
            model.addAttribute("exById", exercisesById);

        return "all-exercise-names";
    }


    @RequestMapping("/addNewExercise")
    public String addNewExercise(Model model){
        Exercises exercises = new Exercises();
        model.addAttribute("exercise", exercises);

        return "all-exercises-info";

    }


    @RequestMapping("/saveExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercises exercises){

        exercisesService.saveExercise(exercises);
//        return "all-exercises-info";

        return "redirect:/showExercises/"+exercises.getTopicId() ;
    }

    @RequestMapping("/updateInfoExercise")
    public String updateExercise(@RequestParam("exId") int id, Model model){

        Exercises exercises = exercisesService.getExercise(id);
        model.addAttribute("exercise", exercises);
        return "all-exercises-info";
    }

    //////////////////////////////////////////
    @RequestMapping("/deleteExercise")
    public String deleteExercise(@RequestParam("exId") int id){

        exercisesService.deleteExercise(id);
        return "redirect:/showExercises/{topicId}";
    }










}

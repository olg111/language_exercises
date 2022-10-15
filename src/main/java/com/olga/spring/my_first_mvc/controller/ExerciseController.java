package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExerciseController {



      @Autowired
    private ExercisesService exercisesService;

    @RequestMapping("/showExercises")
    public String showAllExercises(Model model){

        List<Exercises> allExercises =exercisesService.getAllExercises();
        model.addAttribute("allEx", allExercises);
        for (Exercises e:allExercises
             ) {System.out.println("e");

        }



        return "all-exercise-names";
//         чтобы view мог отобразить значения полей "темы" нужно в методе контроллера создать model
//          и добавить темы в качестве атрибутов этой модели
    }

    ///////////////////////////////////////////////////

    @RequestMapping("/addNewExercise")
    public String addNewExercise(Model model){
        Exercises exercises = new Exercises();
        model.addAttribute("exercise", exercises);

        return "all-exercises-info";

    }


    @RequestMapping("/saveExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercises exercises){

        exercisesService.saveExercise(exercises);

        return "redirect:/showExercises";
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
        return "redirect:/showExercises";
    }







//    @RequestMapping("/exercisesByTopic")
//    public String showExercisesByTopic(@RequestParam("empId") int topicId, Model model) {
//
//        Exercises exercise = exercisesService.getAllExercises().get(topicId);
//        model.addAttribute("exercise", exercise);
//
//        return "all-exercise-names";
//    }



}

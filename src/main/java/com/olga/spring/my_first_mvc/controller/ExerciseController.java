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
    ///////////////////////////////////////////////////

    @RequestMapping("/addNewTopic")
    public String addNewTopic(Model model){
        Topics topics = new Topics();
        model.addAttribute("topic", topics);
        System.out.println("done add");

        return "all-topics-info";

    }

    @RequestMapping("/saveTopic")
    public String saveTopic(@ModelAttribute("topic") Topics topics){

        topicsService.saveTopic(topics);

        return "redirect:/";
    }

    @RequestMapping("/updateInfoTopic")
    public String updateTopic(@RequestParam("topId") int id, Model model){

        Topics topics = topicsService.getTopic(id);
        model.addAttribute("topic", topics);
        return "all-topics-info";
    }

    //////////////////////////////////////////
    @RequestMapping("/deleteTopic")
    public String deleteTopic(@RequestParam("topId") int id){

        topicsService.deleteTopic(id);
        return "redirect:/";
    }





















    @RequestMapping("/ex")
    public String showAllExercises(Model model) {

        List<Exercises> allExercises = exercisesService.getAllExercises();
        model.addAttribute("allEx", allExercises);
        System.out.println("+");

        return "all-exercise-names";
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

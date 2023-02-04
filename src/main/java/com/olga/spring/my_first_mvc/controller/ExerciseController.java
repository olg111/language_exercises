package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExerciseController {
// REV00 переименовать все jsp файлы, чтоб они отражали свою суть
    @Autowired
    private ExercisesService exercisesService;

    @Autowired
    private TopicsService topicsService;


    @GetMapping("/guest/showExercises/{topicId}")
    public String showExercisesByTopic(@PathVariable int topicId, Model model) {
        List<Exercises> exercisesById = exercisesService.getExercisesById(topicId);
        model.addAttribute("exById", exercisesById);

        return "guest-exercise-list";
    }
//  REV00  Переработать пути, чтоб не было такого : http://localhost:8080/guest/showExercises/28/guest/showSentences/38
    @GetMapping("/admin/showExercises/{topicId}")
    public String showExercisesByTopicToAdmin(@PathVariable int topicId, Model model) {
        List<Exercises> exercisesById = exercisesService.getExercisesById(topicId);
        model.addAttribute("exById", exercisesById);

        return "admin-exercise-list";
    }

    @GetMapping("/admin/addNewExercise/{topicId}")
    public String addNewExercise(@PathVariable int topicId, Model model){
        Map<Integer, String> topicMap = topicsService.createMap();
        Exercises exercise = new Exercises();
        model.addAttribute("exercise", exercise);
        model.addAttribute("topics", topicMap);

        return "admin-exercise-creation";
    }

    @PostMapping("/admin/saveExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercises exercises){
        exercisesService.saveExercise(exercises);

        return "redirect:/admin/showExercises/"+ exercises.getTopic().getId() ;
    }

    @GetMapping("/admin/updateInfoExercise")
    public String updateExercise(@RequestParam("exId") int id, Model model){
        Map<Integer, String> topicMap = topicsService.createMap();
        Exercises exercises = exercisesService.getExercise(id);
        model.addAttribute("exercise", exercises);
        model.addAttribute("topics", topicMap);

        return "admin-exercise-creation";
    }

    @PostMapping("/admin/deleteExercise/{exId}")
    public String deleteExercise(@PathVariable int exId ){
        int topicID = exercisesService.getExercise(exId).getTopic().getId();
        exercisesService.deleteExercise(exId);

        return "redirect:/admin/showExercises/"  + topicID;
    }

}

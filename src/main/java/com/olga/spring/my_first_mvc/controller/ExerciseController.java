package com.olga.spring.my_first_mvc.controller;

import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
public class ExerciseController {

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
        model.addAttribute("title", "Create an exercise");

        return "admin-exercise-creation";
    }

    @PostMapping("/admin/saveExercise")
    public String saveExercise(@Valid @ModelAttribute("exercise") Exercises exercises, BindingResult bindingResult ){
        if(bindingResult.hasErrors()){
            return "admin-exercise-creation";
        }

        exercisesService.saveExercise(exercises);
        return "redirect:/admin/showExercises/"+ exercises.getTopic().getId() ;

    }

    @GetMapping("/admin/updateInfoExercise/{topicId}")
    public String updateExercise(@PathVariable int topicId, @RequestParam("exId") int id, Model model){
        Map<Integer, String> topicMap = topicsService.createMap(); //
        Exercises exercises = exercisesService.getExercise(id);
        model.addAttribute("exercise", exercises);
        model.addAttribute("topics", topicMap);
        model.addAttribute("title", "Edit the exercise");

        return "admin-exercise-creation";
    }

    @PostMapping("/admin/deleteExercise/{exId}")
    public String deleteExercise(@PathVariable int exId ){
        int topicID = exercisesService.getExercise(exId).getTopic().getId();
        exercisesService.deleteExercise(exId);

        return "redirect:/admin/showExercises/"  + topicID;
    }

}

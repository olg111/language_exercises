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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ExerciseController {

    @Autowired
    private ExercisesService exercisesService;

    @Autowired
    private TopicsService topicsService;

    List<Exercises> exercisesById;
    Map<Integer, String> topicMap = new HashMap<>();
    public Map <Integer, String> createMap(){
        for (Topics top: topicsService.getAllTopics() ) {
            topicMap.put(top.getId(), top.getName());
        }
        return topicMap;
    }

    @RequestMapping("/guest/showExercises/{topicId}")
    public String showExercisesByTopic(@PathVariable int topicId, Model model) {
        exercisesById = exercisesService.getExercisesById(topicId);
        model.addAttribute("exById", exercisesById);

        return "guest-exercise-names";
    }

    @RequestMapping("/admin/showExercises/{topicId}")
    public String showExercisesByTopicToAdmin(@PathVariable int topicId, Model model) {
        exercisesById = exercisesService.getExercisesById(topicId);
        model.addAttribute("exById", exercisesById);

        return "admin-exercise-names";
    }

    @RequestMapping("/admin/addNewExercise")
    public String addNewExercise(Model model){
        Exercises exercise = new Exercises();
        createMap();
        model.addAttribute("exercise", exercise);
        model.addAttribute("topics", topicMap);

        return "admin-exercises-info";
    }

    @RequestMapping("/admin/saveExercise")
    public String saveExercise(@ModelAttribute("exercise") Exercises exercises){

        exercisesService.saveExercise(exercises);

        return "redirect:/admin/showExercises/"+ exercises.getTopic().getId() ;
    }

    @RequestMapping("/admin/updateInfoExercise")
    public String updateExercise(@RequestParam("exId") int id, Model model){
        Exercises exercises = exercisesService.getExercise(id);
        createMap();
        model.addAttribute("exercise", exercises);
        model.addAttribute("topics", topicMap);

        return "admin-exercises-info";
    }

    @RequestMapping("/admin/deleteExercise")
    public String deleteExercise(@RequestParam("exId") int id){
        int topicID =     exercisesService.getExercise(id).getTopic().getId();
        exercisesService.deleteExercise(id);

        return "redirect:/admin/showExercises/"  + topicID;
    }

}

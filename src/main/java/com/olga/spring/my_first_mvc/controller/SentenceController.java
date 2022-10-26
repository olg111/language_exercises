package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Sentences;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.sentences.SentencesService;
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
public class SentenceController {

    @Autowired
    private TopicsService topicsService;
    @Autowired
    private ExercisesService exercisesService;
    @Autowired
    private SentencesService sentencesService;

    List<Sentences> allSentences;
    List<Sentences> sentencesById;




    @RequestMapping("/showExercises/{topicId}/showSentences/{exerciseId}")


    public String showSentencesByExercise(@PathVariable int exerciseId, Model model) {
           sentencesById = sentencesService.getSentenceById(exerciseId);
            model.addAttribute("sentById", sentencesById);

            return "all-sentences-names";


    }
    ///////////////////////////////////////////////////

//    @RequestMapping("/addNewTopic")
//    public String addNewTopic(Model model){
//        Topics topics = new Topics();
//        model.addAttribute("topic", topics);
//        System.out.println("done add");
//
//        return "all-topics-info";
//
//    }

//    @RequestMapping("/saveTopic")
//    public String saveTopic(@ModelAttribute("topic") Topics topics){
//
//        topicsService.saveTopic(topics);
//
//        return "redirect:/";
//    }

    @RequestMapping("/updateInfoSentences")
    public String updateTopic(@RequestParam("sentId") int id, Model model){

        Sentences sentences = sentencesService.getSentence(id);
        model.addAttribute("sent", sentences);
        return "all-sentences-names";
    }

    //////////////////////////////////////////
    @RequestMapping("/deleteSentence")
    public String deleteSentence(@RequestParam("sentId") int id){

        int sentenceId = sentencesService.getSentence(id).getExerciseId();

        sentencesService.deleteSentence(id);
        return "/showExercises/{topicId}/showSentences/" + sentenceId;
    }




}

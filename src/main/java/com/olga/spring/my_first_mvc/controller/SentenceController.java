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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    Map<Integer, String> sentenceMap = new HashMap<>();


    public Map <Integer, String> createSentenceMap(){
        for (Sentences sent: sentencesService.getAllSentences() ) {
            sentenceMap.put(sent.getId(), sent.getSentence());
        }
        return sentenceMap;
    }


   @RequestMapping("/showExercises/{topicId}/showSentences")
   //@RequestMapping("/showSentences")

    public String showSentences(@PathVariable int topicId, Model model) {
        allSentences = sentencesService.getAllSentences();
        model.addAttribute("allSent", allSentences);
        model.addAttribute("topicId", topicId);

        return "all-sentences-names";

    }



    @RequestMapping("/showExercises/{topicId}/showSentences/{exerciseId}")

    public String showSentencesByExercise(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {
           sentencesById = sentencesService.getSentenceByExId(exerciseId);
            model.addAttribute("sentById", sentencesById);
            model.addAttribute("topicId", topicId);


            return "all-sentences-names";

    }
    ///////////////////////////////////////////////////

    @RequestMapping("/addNewSentence/{topicId}")
    public String addNewSentence(@PathVariable int topicId, Model model){
        Sentences sentence = new Sentences();
        createSentenceMap();
        System.out.println("topicId:" + topicId);
        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceMap", sentenceMap);
        model.addAttribute("topicId", topicId);


        return "sentences-info";
    }

    @RequestMapping("/addNewSentence/{topicId}/saveSentence")
    public String saveSentence(@PathVariable int topicId, @ModelAttribute("sentence") Sentences sentences, Model model){

      sentencesService.saveSentence(sentences);

      model.addAttribute("topicId", topicId);


       // return "redirect:/showExercises/{topicId}/showSentences"+ exercises.getTopicId() ;
      //  return "redirect:/showExercises/{topicId}/showSentences" ;
        return "redirect:/showExercises/"+ topicId + "/showSentences/" + sentences.getExerciseId();
    }

    @RequestMapping("/updateInfoSentences")
    public String updateSentence(@RequestParam("sentId") int id, Model model){

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

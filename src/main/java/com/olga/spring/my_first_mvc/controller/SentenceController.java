package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Sentences;
import com.olga.spring.my_first_mvc.service.answers.AnswersService;
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
    @Autowired
    private AnswersService answersService;


    List<Sentences> allSentences;
    List<Sentences> sentencesById;

    Map<Integer, String> sentenceMap = new HashMap<>();


    public Map <Integer, String> createSentenceMap(){
        for (Sentences sent: sentencesService.getAllSentences() ) {
            sentenceMap.put(sent.getId(), sent.getSentence());
        }
        return sentenceMap;
    }


//   @RequestMapping("/guest/showExercises/{topicId}/guest/showSentences")
//   //@RequestMapping("/showSentences")
//    public String showSentencesToGuest(@PathVariable int topicId, Model model) {
//        allSentences = sentencesService.getAllSentences();
//        model.addAttribute("allSent", allSentences);
//        model.addAttribute("topicId", topicId);
//        return "guest-sentences-names";
//    }
//
//    @RequestMapping("/admin/showExercises/{topicId}/admin/showSentences")
//    //@RequestMapping("/showSentences")
//    public String showSentencesToAdmin(@PathVariable int topicId, Model model) {
//        allSentences = sentencesService.getAllSentences();
//        model.addAttribute("allSent", allSentences);
//        model.addAttribute("topicId", topicId);
//        return "admin-sentences-names";
//    }


    @RequestMapping("/guest/showExercises/{topicId}/guest/showSentences/{exerciseId}")
    public String showSentencesByExerciseToGuest(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {
           sentencesById = sentencesService.getSentenceByExId(exerciseId);
        String exName = exercisesService.getExercise(exerciseId).getName();
            model.addAttribute("sentById", sentencesById);
            model.addAttribute("exerciseId", exerciseId);
            model.addAttribute("topicId", topicId);
            model.addAttribute("exName", exName);
            return "guest-sentences-names";
    }

    @RequestMapping("/admin/showExercises/{topicId}/admin/showSentences/{exerciseId}")
    public String showSentencesByExerciseToAdmin(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {
        sentencesById = sentencesService.getSentenceByExId(exerciseId);
        String exName = exercisesService.getExercise(exerciseId).getName();
        model.addAttribute("sentById", sentencesById);
        model.addAttribute("exerciseId", exerciseId);
        model.addAttribute("topicId", topicId);
        model.addAttribute("exName", exName);
        return "admin-sentences-names";
    }


    @RequestMapping("/admin/addNewSentence/{topicId}/{exerciseId}")
    public String addNewSentence(@PathVariable int topicId, @PathVariable int exerciseId,  Model model){
        Sentences sentence = new Sentences();
        createSentenceMap();
        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceMap", sentenceMap);
        model.addAttribute("topicId", topicId);
        model.addAttribute("exerciseId", exerciseId);
        return "admin-sentences-info";
    }

    @RequestMapping("/admin/addNewSentence/{topicId}/admin/saveSentence")
    public String saveSentence(@PathVariable int topicId, @ModelAttribute("sentence") Sentences sentences, Model model){
      sentencesService.saveSentence(sentences);
      answersService.saveAnswers(sentences);
      model.addAttribute("topicId", topicId);
       // return "redirect:/showExercises/"+ topicId + "/showSentences/" + sentences.getExerciseId();
        return "redirect:/admin/showExercises/"+ topicId + "/admin/showSentences/" + sentences.getExercise().getId();
    }

    @RequestMapping("/admin/updateInfoSentences/{topicId}")
    public String updateSentence(@PathVariable int topicId, @RequestParam("sentId") int id, Model model){
        Sentences sentences = sentencesService.getSentence(id);
        model.addAttribute("sentence", sentences);
        model.addAttribute("topicId", topicId);
        return "admin-sentences-info";
    }

    //////////////////////////////////////////
    @RequestMapping("/admin/deleteSentence/{topicId}")
    public String deleteSentence(@PathVariable int topicId, @RequestParam("sentId") int id,  Model model){

        int exerciseId = sentencesService.getSentence(id).getExercise().getId(); ///
        model.addAttribute("topicId", topicId);


        sentencesService.deleteSentence(id);
        return "redirect:/admin/showExercises/" + topicId +"/admin/showSentences/" + exerciseId;
    }




}

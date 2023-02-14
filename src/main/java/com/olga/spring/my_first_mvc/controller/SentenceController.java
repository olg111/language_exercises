package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Sentences;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.sentences.SentencesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/guest/showExercises/{topicId}/{exerciseId}")
    public String showSentencesByExerciseToGuest(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {
        String exName = exercisesService.getExercise(exerciseId).getName();
        List<List<HashMap<String, String>>> allListsHashMap = sentencesService.splitSentence(exerciseId);

            model.addAttribute("exerciseId", exerciseId);
            model.addAttribute("topicId", topicId);
            model.addAttribute("exName", exName);
            model.addAttribute("allListsHashMap", allListsHashMap);
            return "guest-sentence-list";
    }

    @GetMapping("/admin/showExercises/{topicId}/{exerciseId}")
    public String showSentencesByExerciseToAdmin(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {

        List<Sentences> sentencesById = sentencesService.getSentenceByExId(exerciseId);
        String exName = exercisesService.getExercise(exerciseId).getName();
        model.addAttribute("sentById", sentencesById);
        model.addAttribute("exerciseId", exerciseId);
        model.addAttribute("topicId", topicId);
        model.addAttribute("exName", exName);
        return "admin-sentence-list";
    }


    @GetMapping("/admin/addNewSentence/{topicId}/{exerciseId}")
    public String addNewSentence(@PathVariable int topicId, @PathVariable int exerciseId,  Model model){
        Sentences sentence = new Sentences();
        Map<Integer, String> sentenceMap = sentencesService.createSentenceMap();
        model.addAttribute("sentence", sentence);
        //model.addAttribute("sentenceMap", sentenceMap); //не нужен
        //model.addAttribute("topicId", topicId);
        //model.addAttribute("exerciseId", exerciseId);
        model.addAttribute("title", "Create a sentence");

        return "admin-sentence-creation";
    }

    @PostMapping("/admin/saveSentence/{topicId}")
    public String saveSentence(@PathVariable int topicId,  @ModelAttribute("sentence") Sentences sentences, Model model){
        sentencesService.saveSentence(sentences);
        model.addAttribute("topicId", topicId);

        return "redirect:/admin/showExercises/"+ topicId + "/" + sentences.getExercise().getId();
    }

    @GetMapping("/admin/updateInfoSentences/{topicId}/{exerciseId}")
    public String updateSentence(@PathVariable int topicId, @PathVariable int exerciseId, @RequestParam("sentId") int id, Model model){
        Sentences sentences = sentencesService.getSentence(id);

        model.addAttribute("sentence", sentences);
        model.addAttribute("title", "Edit the sentence");

        return "admin-sentence-creation";
    }

    @PostMapping("/admin/deleteSentence/{topicId}/{sentId}")
    public String deleteSentence(@PathVariable int topicId, @PathVariable int sentId, Model model){
        int exerciseId = sentencesService.getSentence(sentId).getExercise().getId();
        model.addAttribute("topicId", topicId);
        sentencesService.deleteSentence(sentId);

        return "redirect:/admin/showExercises/" + topicId + "/" + exerciseId;
    }
}

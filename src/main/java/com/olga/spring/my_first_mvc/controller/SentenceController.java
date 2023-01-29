package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Sentences;
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
import java.util.ArrayList;
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


//    все 3 переменные не нужны и могут быть заменены локальными
    List<Sentences> sentencesById;
    Map<Integer, String> sentenceMap = new HashMap<>();
    List<List<HashMap<String, String>>> allListsHashMap = new ArrayList<List<HashMap<String, String>>>();

//  переместить в сервис сентенс
    public Map <Integer, String> createSentenceMap(){
        for (Sentences sent: sentencesService.getAllSentences() ) {
            sentenceMap.put(sent.getId(), sent.getSentence());
        }
        return sentenceMap;
    }

//  поменять длинные пути на что-то более читабельное. Добавить глобальный декоратор для каждого контроллера
    @RequestMapping("/guest/showExercises/{topicId}/guest/showSentences/{exerciseId}")
    public String showSentencesByExerciseToGuest(@PathVariable int topicId, @PathVariable int exerciseId, Model model) {

        String exName = exercisesService.getExercise(exerciseId).getName();
        allListsHashMap = sentencesService.splitSentence(exerciseId);
//        не все из пересисленного нужно в jsp
            model.addAttribute("sentById", sentencesById);
            model.addAttribute("exerciseId", exerciseId);
            model.addAttribute("topicId", topicId);
            model.addAttribute("exName", exName);
            model.addAttribute("allListsHashMap", allListsHashMap);
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
//        не все аттрибуты используются в jsp
        model.addAttribute("sentence", sentence);
        model.addAttribute("sentenceMap", sentenceMap);
        model.addAttribute("topicId", topicId);
        model.addAttribute("exerciseId", exerciseId);

        return "admin-sentences-info";
    }

//    @RequestMapping("/admin/saveSentence/{topicId}")
    @RequestMapping("/admin/addNewSentence/{topicId}/admin/saveSentence")
    public String saveSentence(@PathVariable int topicId,  @ModelAttribute("sentence") Sentences sentences, Model model){
        sentencesService.saveSentence(sentences);
        model.addAttribute("topicId", topicId);

        return "redirect:/admin/showExercises/"+ topicId + "/admin/showSentences/" + sentences.getExercise().getId();
    }

    @RequestMapping("/admin/updateInfoSentences/{topicId}")
    public String updateSentence(@PathVariable int topicId, @RequestParam("sentId") int id, Model model){
        Sentences sentences = sentencesService.getSentence(id);
        //        не все аттрибуты используются в jsp
        model.addAttribute("sentence", sentences);
        model.addAttribute("topicId", topicId);

        return "admin-sentences-info";
    }

    @RequestMapping("/admin/deleteSentence/{topicId}")
    public String deleteSentence(@PathVariable int topicId, @RequestParam("sentId") int id,  Model model){
        int exerciseId = sentencesService.getSentence(id).getExercise().getId();
        model.addAttribute("topicId", topicId);
        sentencesService.deleteSentence(id);

        return "redirect:/admin/showExercises/" + topicId +"/admin/showSentences/" + exerciseId;
    }
}

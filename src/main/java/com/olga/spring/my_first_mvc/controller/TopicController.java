package com.olga.spring.my_first_mvc.controller;


import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TopicController {

    @Autowired
    private TopicsService topicsService;

    @GetMapping("/admin")
    public String showAllTopicsToAdmin(Model model){
        List<Topics> allTopics =topicsService.getAllTopics();
        model.addAttribute("allTop", allTopics);

        return "admin-topic-list";
        /* so that the view can display the values of the "topics" fields,
         you need to create a model in the controller method and add topics as attributes of this model*/
    }

    @GetMapping("/guest")
    public String showAllTopicsToGuest(Model model){
        List<Topics> allTopics =topicsService.getAllTopics();
        model.addAttribute("allTop", allTopics);

        return "guest-topic-list";
    }


    @GetMapping("/admin/addNewTopic")
    public String addNewTopic(Model model){
        Topics topics = new Topics();
        model.addAttribute("topic", topics);
        model.addAttribute("title", "Create a topic");

        return "admin-topic-creation";
    }

    @PostMapping("/admin/saveTopic")
    public String saveTopic(@ModelAttribute("topic") Topics topics){
        topicsService.saveTopic(topics);

        return "redirect:/admin";
    }

    @GetMapping("/admin/updateInfoTopic")
    public String updateTopic(@RequestParam("topId") int id, Model model){
        Topics topics = topicsService.getTopic(id);
        model.addAttribute("topic", topics);
        model.addAttribute("title", "Edit the topic");

        return "admin-topic-creation";
    }

    // HTML documentation says form selector supports only <form method="get|post">

    @PostMapping("/admin/deleteTopic/{topId}")
    public String deleteTopic( @PathVariable int topId){
        topicsService.deleteTopic(topId);

        return "redirect:/admin";
    }


}

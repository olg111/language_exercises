package com.olga.spring.my_first_mvc.controller;

import com.olga.spring.my_first_mvc.entity.Topics;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TheoryController {
    @GetMapping("/theory")
    public String showAllTheory(){

        return "guest-theory";
    }
}

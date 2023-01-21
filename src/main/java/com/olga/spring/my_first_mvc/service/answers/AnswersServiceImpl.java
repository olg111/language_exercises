package com.olga.spring.my_first_mvc.service.answers;

import com.olga.spring.my_first_mvc.dao.answers.AnswersDAO;
import com.olga.spring.my_first_mvc.dao.sentences.SentencesDAO;
import com.olga.spring.my_first_mvc.entity.Sentences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AnswersServiceImpl implements AnswersService {

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private AnswersDAO answersDAO;

    @Autowired
    private SentencesDAO sentencesDAO;










}








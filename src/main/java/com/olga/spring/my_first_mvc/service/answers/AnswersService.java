package com.olga.spring.my_first_mvc.service.answers;

import com.olga.spring.my_first_mvc.entity.Answers;
import com.olga.spring.my_first_mvc.entity.Sentences;

import java.util.List;

public interface AnswersService {




    public List<Answers> getAllAnswers();

    public void saveAnswers(Sentences sentences);

    public Answers getAnswer(int id);

}

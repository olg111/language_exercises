package com.olga.spring.my_first_mvc.dao.answers;

import com.olga.spring.my_first_mvc.entity.Answers;
import com.olga.spring.my_first_mvc.entity.Exercises;

import java.util.List;

public interface AnswersDAO {
    public List<Answers> getAllAnswers();

    public void saveAnswers(Answers answers);

    public Answers getAnswer(int id);

    public  void deleteAnswerBySentenceId(int sentenceId);



}

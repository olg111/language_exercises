package com.olga.spring.my_first_mvc.dao.sentences;

import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Sentences;

import java.util.List;

public interface SentencesDAO {

    public List<Sentences> getAllSentences();

    public List<Sentences> getSentenceByExId(int exerciseId); //

    public void saveSentence(Sentences sentences);

    public Sentences getSentence(int id);

    public void deleteSentence(int id);


}

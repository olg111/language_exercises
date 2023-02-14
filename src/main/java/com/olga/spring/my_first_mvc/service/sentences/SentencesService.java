package com.olga.spring.my_first_mvc.service.sentences;

import com.olga.spring.my_first_mvc.entity.Sentences;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SentencesService {
    public List<Sentences> getAllSentences();

    public List<Sentences> getSentenceByExId(int exerciseId); //

    public List<List<HashMap<String, String>>> splitSentence(int exerciseId);

    public void saveSentence(Sentences sentences);

    public Sentences getSentence(int id);

    public void deleteSentence(int id);

    public Map<Integer, String> createSentenceMap();

}

package com.olga.spring.my_first_mvc.service.sentences;

import com.olga.spring.my_first_mvc.dao.sentences.SentencesDAO;
import com.olga.spring.my_first_mvc.entity.Sentences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SentencesServiceImpl implements SentencesService {

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private SentencesDAO sentencesDAO;


    @Override
    @Transactional
    public List<Sentences> getAllSentences() {
        return sentencesDAO.getAllSentences();
    }

    @Override
    @Transactional
    public List<Sentences> getSentenceByExId(int exerciseId) {
        return sentencesDAO.getSentenceByExId(exerciseId);
    }

    @Override
    @Transactional
    public void saveSentence(Sentences sentences) {
        sentencesDAO.saveSentence(sentences);

    }

    @Override
    @Transactional
    public Sentences getSentence(int id) {
        return sentencesDAO.getSentence(id);
    }

    @Override
    @Transactional
    public void deleteSentence(int id) {
        sentencesDAO.deleteSentence(id);

    }
}

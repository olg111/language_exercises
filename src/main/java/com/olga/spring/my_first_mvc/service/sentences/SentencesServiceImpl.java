package com.olga.spring.my_first_mvc.service.sentences;

import com.olga.spring.my_first_mvc.dao.answers.AnswersDAO;
import com.olga.spring.my_first_mvc.dao.sentences.SentencesDAO;
import com.olga.spring.my_first_mvc.entity.Sentences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class SentencesServiceImpl implements SentencesService {

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private SentencesDAO sentencesDAO;
    @Autowired
    private AnswersDAO answersDAO;


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


    @Transactional
    public List<List<HashMap<String, String>>> splitSentence(int exerciseId) {

        //"I /{like}/ cats and he /{likes}/ dogs."
        String regex = "[{](.*?)[}]";
        String[] myText;
        String myHint;
        List<Sentences> sentencesListByExId = getSentenceByExId(exerciseId);
        List<List<HashMap<String, String>>> allListsHashMap = new ArrayList<List<HashMap<String, String>>>();

        for (int i = 0; i < sentencesListByExId.size(); i++) {

            myText = sentencesListByExId.get(i).getSentence().split("/");
            myHint = sentencesListByExId.get(i).getHint();

//            for (String s : myText ) {
//                System.out.println(s);
//
//            }
            List<HashMap<String, String>> listHashMap = new ArrayList<>();
            HashMap<String, String> hintHashMap = new HashMap<>();

            for (int f = 0; f < myText.length; f++) {
                HashMap<String, String> hashMap = new HashMap<>();
                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(myText[f]);
                if (matcher.find()) {
                    hashMap.put("type", "input");
                    hashMap.put("content", matcher.group(1));

                } else  {
                    hashMap.put("type", "text");
                    hashMap.put("content", myText[f]);

                }

                listHashMap.add(hashMap);

            }
            hintHashMap.put("type", "hint");
            hintHashMap.put("content",  myHint);
            listHashMap.add(hintHashMap);
            allListsHashMap.add(listHashMap);
        }
        System.out.println(allListsHashMap);
        return  allListsHashMap;
    }

//    @Override
//    @Transactional
//    public String getHintBySentId(int  exerciseId ) {
//
//        List<Sentences> sentencesListByExId = getSentenceByExId(exerciseId);
//        String hint = null;
//
//            for (int i = 0; i < sentencesListByExId.size(); i++) {
//                hint = sentencesListByExId.get(i).getHint();
//            }
//        return hint;
//    }

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
        answersDAO.deleteAnswerBySentenceId(id);
        sentencesDAO.deleteSentence(id);

    }
}

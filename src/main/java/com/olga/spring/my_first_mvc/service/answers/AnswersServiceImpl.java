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




    public List<Sentences> sentencesList(int exerciseId) {
        return sentencesDAO.getSentenceByExId(exerciseId);
    }

   List<List<HashMap<String, String>>> allListsHashMap = new ArrayList<List<HashMap<String, String>>>();


    //"I /{like}/ cats and he /{likes}/ dogs."
    public void splitSentence(int exerciseId) {
        String regex = "[{](.*?)[}]";
        String[] myText;
        List<Sentences> sentencesListByExId = sentencesList(exerciseId);

        for (int i = 0; i < sentencesListByExId.size(); i++) {

            myText = sentencesListByExId.get(i).toString().split("/");
            List<HashMap<String, String>> listHashMap = new ArrayList<>();

            for (int f = 0; f < myText.length; f++) {
                HashMap<String, String> hashMap = new HashMap<>();

                Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(myText[f]);
                if (matcher.find()) {
                    hashMap.put("type", "input");
                    hashMap.put("content", matcher.group(1));
                    //  listHashMap.add(hashMap);
                } else {
                    hashMap.put("type", "text");
                    hashMap.put("content", myText[f]);
                    //  listHashMap.add(hashMap);
                }
                listHashMap.add(hashMap);
            }
            allListsHashMap.add(listHashMap);
        }
        System.out.println(allListsHashMap);
    }

}








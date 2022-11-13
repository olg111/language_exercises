package com.olga.spring.my_first_mvc.service.answers;

import com.olga.spring.my_first_mvc.dao.answers.AnswersDAO;
import com.olga.spring.my_first_mvc.entity.Answers;
import com.olga.spring.my_first_mvc.entity.Sentences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class AnswersServiceImpl implements AnswersService{

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private AnswersDAO answersDAO;

    @Transactional
    @Override
    public List<Answers> getAllAnswers() {
        return answersDAO.getAllAnswers();
    }

    @Transactional
    @Override
    public void saveAnswers(Sentences sentences) {
        String myText = sentences.getSentence();
        String regex = "[{](.*?)[}]";


        Pattern pattern = Pattern.compile(regex , Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(myText);
        while (matcher.find()) {
            Answers answers = new Answers();
            String [] placeholderAndAnswer = matcher.group(1).split("=");
            answers.setPlaceholder(placeholderAndAnswer[0]);
            answers.setAnswer(placeholderAndAnswer[1]);
            //answers.setSentenceId(sentences.getId());
            answers.setSentence(sentences);
            answersDAO.saveAnswers(answers);
        }






    }

    @Transactional
    @Override
    public Answers getAnswer(int id) {
        return answersDAO.getAnswer(id);
    }
}

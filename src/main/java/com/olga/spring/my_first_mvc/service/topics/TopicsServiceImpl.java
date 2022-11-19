package com.olga.spring.my_first_mvc.service.topics;

import com.olga.spring.my_first_mvc.dao.exercises.ExercisesDAO;
import com.olga.spring.my_first_mvc.dao.topics.TopicsDAO;
import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;
import com.olga.spring.my_first_mvc.service.exercises.ExercisesService;
import com.olga.spring.my_first_mvc.service.topics.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class TopicsServiceImpl implements TopicsService {

    //чтобы вызвать метод из DAO прописываем зависимость от него
    @Autowired
    private TopicsDAO topicsDAO;

    @Autowired
    private ExercisesDAO exercisesDAO;

    @Autowired
    private ExercisesService exercisesService;


    @Override
    @Transactional
    public List<Topics> getAllTopics() {
        return topicsDAO.getAllTopics();
    }


    @Override
    @Transactional
    public void saveTopic(Topics topics) {
        topicsDAO.saveTopic(topics);

    }

    @Override
    @Transactional
    public Topics getTopic(int id) {
        return topicsDAO.getTopic(id);
    }

    @Override
    @Transactional
    public void deleteTopic(int id) {

        List<Exercises> exercisesList = exercisesDAO.getExercisesById(id);
        for (Exercises ex:exercisesList) {
            exercisesService.deleteExercise(ex.getId());
        }
        topicsDAO.deleteTopic(id);

    }

}

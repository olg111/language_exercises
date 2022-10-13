package com.olga.spring.my_first_mvc.dao.topics;

import com.olga.spring.my_first_mvc.entity.Exercises;
import com.olga.spring.my_first_mvc.entity.Topics;

import java.util.List;

public interface TopicsDAO {

    public List<Topics> getAllTopics();

    public void saveTopic(Topics topics);

    public Topics getTopic(int id);

    public void deleteTopic(int id);
}

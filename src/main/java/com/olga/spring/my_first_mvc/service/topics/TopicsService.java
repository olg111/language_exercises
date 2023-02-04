package com.olga.spring.my_first_mvc.service.topics;

import com.olga.spring.my_first_mvc.entity.Topics;

import java.util.List;
import java.util.Map;

public interface TopicsService {
    public List<Topics> getAllTopics();

    public  void saveTopic(Topics topics);

    public Topics getTopic(int id);

    public  void deleteTopic(int id);

    public Map <Integer, String> createMap();



}

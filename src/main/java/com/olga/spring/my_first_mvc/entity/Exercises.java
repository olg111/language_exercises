package com.olga.spring.my_first_mvc.entity;


import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "exercise_name")
    private String name;

//    @Column(name = "topic_id")
//    private int topicId   ;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "topic_id")
    private Topics topics;


    public Exercises() {
    }

    public Exercises(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "name='" + name + '\'' +
                '}';
    }

}

package com.olga.spring.my_first_mvc.entity;


import javax.persistence.*;
import java.util.List;

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
    private Topics topic;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE }
            , mappedBy = "exercise"
            , orphanRemoval = true
            , fetch = FetchType.LAZY)
    private List<Sentences> sentencesList ;

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



    public Topics getTopic() {
        return topic;
    }

    public void setTopic(Topics topic) {
        this.topic = topic;
    }

    public List<Sentences> getSentencesList() {
        return sentencesList;
    }

    public void setSentencesList(List<Sentences> sentencesList) {
        this.sentencesList = sentencesList;
    }

    @Override
    public String toString() {
        return "Exercises{" +
                "name='" + name + '\'' +
                '}';
    }

}

package com.olga.spring.my_first_mvc.entity;


import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercises {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

//
//    @ManyToOne(cascade = {CascadeType.ALL})
//    @JoinColumn(name = "topics_id")
//    private Topics topics;


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

//    public Topics getTopics() {
//        return topics;
//    }
//
//    public void setTopics(Topics topics) {
//        this.topics = topics;
//    }

    @Override
    public String toString() {
        return "Exercises{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

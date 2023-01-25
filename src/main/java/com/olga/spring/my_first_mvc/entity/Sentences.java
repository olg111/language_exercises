package com.olga.spring.my_first_mvc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "sentences")
public class Sentences {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "sentence")
    private String sentence;

    @Column(name = "hint")
    private String hint;

    //
    @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE })
    @JoinColumn(name = "exercise_id")
    private Exercises exercise;
    //

    public Sentences() {
    }

    public Sentences(String sentence, String hint) {
        this.sentence = sentence;
        this.hint = hint;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Exercises getExercise() {
        return exercise;
    }

    public void setExercise(Exercises exercise) {
        this.exercise = exercise;
    }




    @Override
    public String toString() {
        return "Sentences{" +
                "sentence='" + sentence + '\'' +
                ", hint='" + hint + '\'' +
                '}';
    }
}

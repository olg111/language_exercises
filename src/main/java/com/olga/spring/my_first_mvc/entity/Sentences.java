package com.olga.spring.my_first_mvc.entity;

import javax.persistence.*;

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

    @Column(name = "exercise_id")
    private int exerciseId;

    public Sentences() {
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

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return "Sentences{" +
                "id=" + id +
                ", sentence='" + sentence + '\'' +
                ", hint='" + hint + '\'' +
                ", exerciseId=" + exerciseId +
                '}';
    }
}

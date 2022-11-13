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

    @Column(name = "exercise_id")
    private int exerciseId;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE }
            , mappedBy = "sentence"
            , orphanRemoval = true
            , fetch = FetchType.LAZY)
    private List<Answers> answer ;

    public Sentences() {
    }

    public Sentences(String sentence, String hint) {
        this.sentence = sentence;
        this.hint = hint;
    }

    public  void AddAnswersToSentences(Answers answers){
        if (answer == null){
            answer = new ArrayList<>();
        }
        answer.add(answers);
        answers.setSentence(this);

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

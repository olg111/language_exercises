package com.olga.spring.my_first_mvc.entity;

import javax.persistence.*;

@Entity
@Table (name = "answers")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "placeholder")
    private String placeholder;

//    @Column(name = "sentence_id")
//    private int sentenceId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "sentence_id")
    private Sentences sentence;



    public Answers() {
    }

    public Answers(String answer, String placeholder) {
        this.answer = answer;
        this.placeholder = placeholder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

//    public int getSentenceId() {
//        return sentenceId;
//    }
//
//    public void setSentenceId(int sentenceId) {
//        this.sentenceId = sentenceId;
//    }


    public Sentences getSentence() {
        return sentence;
    }

    public void setSentence(Sentences sentence) {
        this.sentence = sentence;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "answer='" + answer + '\'' +
                ", placeholder='" + placeholder + '\'' +
                '}';
    }
}

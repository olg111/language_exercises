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

    @Column(name = "sentence_id")
    private int sentenceId;

    public Answers() {
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

    public int getSentenceId() {
        return sentenceId;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    @Override
    public String toString() {
        return "Answers{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ", sentenceId=" + sentenceId +
                '}';
    }
}

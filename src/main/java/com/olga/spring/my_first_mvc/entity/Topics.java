package com.olga.spring.my_first_mvc.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = {CascadeType.ALL}
//            , mappedBy = "topics"
//            , fetch = FetchType.LAZY)
//    private List<Exercises> ex ;


    public Topics() {
    }

    public Topics(String name) {
        this.name = name;
    }

//    public  void AddExercisesToTopics(Exercises exercises){
//        if (ex == null){
//            ex = new ArrayList<>();
//        }
//        ex.add(exercises);
//        exercises.setTopics(this);
//
//    }



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

//    public List<Exercises> getEx() {
//        return ex;
//    }
//
//    public void setEx(List<Exercises> ex) {
//        this.ex = ex;
//    }

    @Override
    public String toString() {
        return "Topics{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}


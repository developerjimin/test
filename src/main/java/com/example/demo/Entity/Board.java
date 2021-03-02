package com.example.demo.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Board {
    @Id @GeneratedValue
    private Long id;
    private String age;
    private String name;
    public Board(){

    }
    public Board(String name, String age){
        this.name = name;
        this.age = age;
    }

}

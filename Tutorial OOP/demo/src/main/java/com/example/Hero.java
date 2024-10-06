package com.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hero {
    private String name;
    private int age;
    private String type;

    Hero(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    void display(){
        System.out.println("Name: " + getName());
        System.out.println("Age: " + age);
        System.out.println("Type: " + type);
    }
}

package com.mine.reflect;

public class Human {

    private String name;
    public int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String name) {
        this.name = name;
    }

    public Human(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

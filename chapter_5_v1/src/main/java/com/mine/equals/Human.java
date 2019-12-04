package com.mine.equals;

import java.util.Objects;

public class Human {
    private String name;

    public Human(){}

    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object otherHuman) {
        Human other = (Human) otherHuman;

        System.out.println("Father equals ");
        return Objects.equals(this.name,other.name);
    }
}

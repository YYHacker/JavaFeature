package com.mine.equals;

import java.util.Objects;

public class Man extends Human{
    private String manname;

    public Man(String manname) {
        this.manname = manname;
    }

    public boolean equals(Object otherMan) {
        if(otherMan == null)return false;
        if(getClass() != otherMan.getClass())return false;
        if(!super.equals(otherMan)) return false;
        Man other = (Man)otherMan;
        System.out.println("Man : equals");
        return Objects.equals(manname,other.manname);
    }

    public String getManname(){
        return this.manname;
    }
}

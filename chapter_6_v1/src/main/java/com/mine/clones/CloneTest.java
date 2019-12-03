package com.mine.clones;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;

public class CloneTest {

    @Test
    public void method1() throws CloneNotSupportedException {
        Person p = new Person("王五",20,"男",new Work("Programer"));
        Person copy = p.clone();
        p.getWork().setJobName("adc");
        System.out.println(Objects.toString(p));
        System.out.println(copy.getWork().toString());
    }

    @Test
    public void method2(){
        String[] arr = {"aaa","ccc","ddd"};
        String[] a = arr.clone();
        System.out.println(Arrays.toString(a));
    }
}

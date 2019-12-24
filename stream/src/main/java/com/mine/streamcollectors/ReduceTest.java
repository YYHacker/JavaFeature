package com.mine.streamcollectors;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ReduceTest {

    @Test
    public void method1(){
        Integer[] t = {1,2,3};
        List<Integer> list = Arrays.asList(t);
        Optional<Integer> i = list.stream().reduce((x, y)->x-y);
        System.out.println(i.get().doubleValue());
    }

    @Test
    public void method2(){
        Stream<String> s = Stream.of("a","bb","ccc");
        int i = s.reduce(0,(total,y)->total +y.length(),(t1,t2)->t1+t2);
        System.out.println(i);
    }

    @Test
    public void method3(){
        IntStream is = IntStream.of(1,2,3,4,5);
        int[] values = {1,2,3,4,5};
        IntStream s = Arrays.stream(values,0,2);
        s.forEach(System.out::println);
    }
    @Test
    public void method4(){
        Stream<String> words = Stream.of("a","bb","ccc");
        IntStream s =words.mapToInt(String::length);
//        s.forEach(System.out::println);
        Stream<Integer> in = s.boxed();

        in.forEach(System.out::println);
    }
    @Test
    public void method5(){
        LongStream s = new Random().longs().limit(1000);
        s.forEach(System.out::println);
    }
    @Test
    public void method6(){
       Properties properties = System.getProperties();
        System.out.println(Arrays.toString(properties.entrySet().toArray()));
        System.out.println(System.getProperty("user.dir"));
        System.out.println("line.separator : "+System.getProperty("line.separator"));
    }
}

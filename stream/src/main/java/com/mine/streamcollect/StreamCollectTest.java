package com.mine.streamcollect;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectTest {

    @Test
    public void method1(){
        Stream<String> stream = Stream.of("aaa","bbb","ccc","ddd");
        List<String> list = stream.collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));
        String[] str = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(str));
    }

    @Test
    public void method2(){
        Stream<String> stream = Stream.of("aaa","bbb","ccc","ddd");
        String s = stream.collect(Collectors.joining(","));
        System.out.println(s);
    }
}

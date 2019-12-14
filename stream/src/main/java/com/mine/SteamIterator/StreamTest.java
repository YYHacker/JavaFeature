package com.mine.SteamIterator;

import com.alibaba.fastjson.JSONArray;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void method1(){
        Stream stream =  Stream.of("aaa","bbb","ccc");
        Stream s1 = stream.map(n->n == "ccc");
        Stream s2 = stream.map(n -> n == "bbb");
        System.out.println(s1.count()+" : "+s2.count());
    }
}

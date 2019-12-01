package com.mine.SteamIterator;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.params.shadow.com.univocity.parsers.common.NormalizedString.toArray;

/**
 * Stream 练习
 */
public class StreamFunction {

    /**
     * distinct 方法去重复
     */
    @Test
    public void Twriteone(){
        Stream<String> uniqueWords = Stream.of("aaa","aaa","ccc","ccc","ddd","123").limit(6).distinct();
         System.out.println(uniqueWords.count());
    }

    /**
     * 数组转换为流
     */
    @Test
    public void arraystream(){
        String[] arr = {"aa","vv","cc","ee"};
        Stream<String> stream = Arrays.stream(arr,1,3);
        System.out.println(stream.count());
    }

    /**
     * 创建空的Stream流
     */
    @Test
    public void createEmptyStream(){
        Stream<String> stream = Stream.empty();
        System.out.println(stream.count());
    }

    /**
     * stream的generate方法，产生一个无线流
     */
    @Test
    public void generate(){
        Stream<Double> d = Stream.generate(Math::random).limit(5000);
        System.out.println(d.count());
        Stream<String> s = Stream.generate(() -> "Eche").limit(10000);
        System.out.println(s.count());
    }

    /**
     * 产生无限流，包含一个种子
     */
    @Test
    public void interate(){
        Stream<BigInteger> s = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(100);
        System.out.println(s.count());
    }
}

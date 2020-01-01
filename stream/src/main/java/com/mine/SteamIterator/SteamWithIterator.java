package com.mine.SteamIterator;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: SteamWithIterator
 * @Desc: 测试Steam 和 传统迭代区别
 * @author： yanyimin
 * @date: 2019/11/23
 * @version: v1.0
 */
public class SteamWithIterator {

    private final String path="E:\\IJworkspace\\JavaFeature\\stream\\src\\main\\java\\com\\mine\\SteamIterator\\file.txt";

    /**
     * 使用传统的处理
     * @throws IOException
     */
    @Test
    public void readFileIterator() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        int count = 0;
        for(String word: words){
            System.out.println(word);
            if(word.length()>5)count++;
        }
        System.out.println(count);
    }

    /**
     * 使用stream流进行处理
     */
    @Test
    public void useStream() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        long count = words.stream().filter(e -> e.length()>5).count();
        System.out.println(count);
    }

    /**
     * 使用并发ParallelStream 操作集合
     */
    @Test
    public void useParalleStream() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        long count = words.parallelStream().limit(5).filter(w -> w.length()>5).count();
        System.out.println(count);
    }

    /**
     * 测试Stream.of 方法
     */
    @Test
    public void useStreamOf(){
        String[] str = {"aaa","bbb","ccc"};
//        long count = Stream.of("aaa","bbb","ccc").count();
        long count = Stream.of(str).count();
        System.out.println(count);
    }

    /**
     * Stream常规操作
     */
    @Test
    public void useStreamEmpty(){
        //创建一个空的Stream流
        Stream<String> empty = Stream.empty();
        //使用Stream获取一个常量
        Stream<String> WOMAN = Stream.generate(()-> "WOMAN");
        //使用Stream创建无线流
        Stream<Double> random = Stream.generate(Math::random);
    }

    /**
     * 使用Stream产生无限序列
     */
    @Test
    public void useStreamSqu(){
        Stream<BigInteger> bigInteger = Stream.iterate(BigInteger.ZERO,n -> n.add(BigInteger.ONE));
    }

    @Test
    public void method(){
        BigDecimal[] barr = new BigDecimal[]{BigDecimal.valueOf(2),BigDecimal.valueOf(4),BigDecimal.valueOf(6),BigDecimal.valueOf(8),BigDecimal.valueOf(1)};
        Arrays.stream(barr).reduce(BigDecimal::add);
    }

    @Test
    public void method4(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> m1 = new HashMap<>();
        m1.put("name","AAA");
        list.add(m1);
        Map<String,String> m2 = new HashMap<>();
        m2.put("name","AAA");
        list.add(m2);
    }
}

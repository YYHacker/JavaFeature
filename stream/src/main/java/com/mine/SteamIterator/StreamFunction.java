package com.mine.SteamIterator;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
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

    /**
     * 使用foreach 循环流中的元素
     */
    @Test
    public void foreach(){
        Stream<BigInteger> s = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(105);
        s.forEach(System.out::println);
    }

    /**
     * 使用iterator 迭代流中的元素
     */
    @Test
    public void iterator(){
        Stream<Double> s = Stream.generate(Math::random).limit(200);
        for(Iterator<Double>  it = s.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }

    /**
     * 流与数组的转换
     */
    @Test
    public void toArray(){
        Stream<String> stream = Stream.generate(()->"Each").limit(20);
//        Object[] obj = stream.toArray();
//        for(Object o: obj){
//            System.out.println(o);
//        }
        //使用数组构造器返回具有正确类型的数组
        String[] ss = stream.toArray(String[]::new);
        for(String s:ss)System.out.println("String : "+s);
    }

    /**
     * 将流中元素收集到其他容器中
     */
    @Test
    public void toList(){
        Map<String,String> map = new HashMap<>();
        Stream<String> stream =  Stream.generate(()-> {int i = 0;String s = "Exe_"+i;i++;return s;}).limit(20);
//        List<String>  list = stream.collect(Collectors.toList());
//        for(String s:list)System.out.println(s);
       Set<String> set =  stream.collect(Collectors.toSet());
       for(String s : set)System.out.println(s);
    }

    /**
     * 流排序
     */
    @Test
    public void sorted(){
        List<String> words = new ArrayList<>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("fri");

      assert  words.stream().sorted(Comparator.comparing(String::length)).count() == 5;
    }

    @Test
    public void peek(){
       Stream<String> stream = Stream.of("one","two","three");
       stream.forEach(s ->{System.out.println(s);});
       Stream<Integer> ss = Stream.iterate(1,p -> p*2).peek(e -> System.out.println("Fetching : "+e)).limit(20);
       Object[] powers = Stream.iterate(1,p -> p*2).peek(e -> System.out.println("Fetching : "+e)).limit(20).toArray( );
    }
}


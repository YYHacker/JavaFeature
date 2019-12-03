package com.mine.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.Predicate;

/**
 * Lambda 测试
 */
public class LambdaTest {

    @Test
    public void method1(){
        Comparator<String> cp = (frist,second) ->  frist.length() - second.length();
        Human<String> h = (name,password) -> name+password;
        System.out.println(h.nameAndPass("zhangsan","123456"));
    }

    @Test
    public void method2(){
        List<String> list = new ArrayList<>();
        list.add("abccc");
        list.add("ccc");
        list.add("ddd");
        list.add("fffff");
        Predicate<String> p = n-> n.contains("ccc");
        Predicate<String> p2 = p.and(n -> n.startsWith("ab"));
        list.removeIf(Predicate.isEqual("ccc"));
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * lambda 方法引用
     */
    @Test
    public void method3(){
        String[] str = {"aaa","FFf","bbb","Ccc","ddd"};
        Arrays.sort(str,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(str));
    }

    public void method4(int a, IntConsumer intConsumer){
        for (int i = 0; i < a; i++) {
            intConsumer.accept(i);
        }
    }

    @Test
    public void method5(){
        method4(5,n -> { int b = n*2;System.out.println(b);} );
    }

    @Test
    public void method6(){
        MyPrint p = System.out::println;
        p.println("123456");
    }

    @Test
    public void method7(){
        MyPrintf p = System.out::printf;
        p.printf("This is %s %s","my","printf");
    }
}

interface MyPrint{
    void println(String s);
}

interface MyPrintf{
    void printf(String format,Object... args);
}

@FunctionalInterface
interface Human<T>{
    T nameAndPass(String username,String password);

    @Override
    String toString();
}


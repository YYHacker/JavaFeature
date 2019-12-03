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



    @Test
    public void method9(){
        Human<Person> h = Person::new;
        System.out.println(h.nameAndPass("Frist","Last").toString());
        Person p = new Person("王五","李四");
        Human<String> h1 = p::getPerson;
        System.out.println(h1.nameAndPass("张胜男","雷颜"));
        Human<String> h2 = Person::get;
        System.out.println(h2.nameAndPass("何鑫" ,"张琴"));
        MyComparator mc = String::compareToIgnoreCase;
        System.out.println(mc.comparing("aaaa","bbb"));
        MyComparator mc1 =(x,y) -> x.compareToIgnoreCase(y);
        MyComparator2 m2 = (x,y) -> x.test(y);
        MyComparator2 m22 = MyTest::test;
        System.out.println(m22.comparing(new MyTest(),"bbb"));
    }
}
class MyTest{
    int test(String a){
        String  b = this.concat(a);
        return b.length();
    }
    String concat(String a){
        return this + a;
    }
}

interface MyComparator{
   int comparing(String s1,String s2);
}
interface MyComparator2{
    int comparing(MyTest s1,String s2);
}
class Person{
    private String fristname;
    private String lastname;

    public Person(String fristname, String lastname) {
        this.fristname = fristname;
        this.lastname = lastname;
    }

    public Person(String fristname) {
        this.fristname = fristname;
    }

    /**
     * lambda 调用object方法
     * @param frist
     * @param last
     * @return
     */
    public String getPerson(String frist,String last){
        return frist+last;
    }

    public static String get(String s1,String s2){
        return s1 + " : " + s2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fristname='" + fristname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
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


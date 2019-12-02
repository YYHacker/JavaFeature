package com.mine.SteamIterator;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Optional;

/**
 * Optional 操作类型
 */
public class OptionalFunc {

    public Optional<Pserson> methodone(){
            String name = "abc";
            Pserson p = new Pserson("张三",52);
            p = null;
        return Optional.of(p);
    }

    @Test
    public void callm(){
        Optional<Pserson> p = this.methodone();
        System.out.println(p.get().getName());
    }

    public Optional<String> methodtwo(){
        String name = "abc";
        return Optional.of(name);
//        return Optional.empty();
    }

    /**
     * orElse 方法，or
     */
    @Test
    public void callm2(){
        Optional<String> optional = this.methodtwo();
        //如果为空，取默认值
        String str = optional.orElse("cccc");
        //如果为空，通过计算取得默认值
        String a = optional.orElseGet(()-> "adfsafd");
        //如果为空，抛出一个异常
        String b = optional.orElseThrow(RuntimeException::new);
        System.out.println(b);
    }
    public Optional<String> method3(){
        Optional opt = null;
        opt = Optional.of("123456");
//        opt = Optional.empty();
         return opt;
    }

    /**
     * ifPresent 方法测试
     * map 方法测试
     */
    @Test
    public void callm3(){
        Optional<String> optional = this.method3();
        optional.ifPresent(v -> {System.out.println("ifPresent : "+v);});
        Optional<String> o = optional.map(v -> {v += 1;return v;});
        System.out.println(o.get());
    }

    /**
     * 设置Opational 为 ofNullable
     * @return
     */
    public Optional<String> method4(){
        String name = "";
        name = "123456";
        return Optional.ofNullable(name);
    }

    @Test
    public void callm4(){
        Optional<String> opt = this.method4();
        String str = opt.orElse("value is null");
        System.out.printf(str);
    }

    public Optional<Pserson> method5(){
        Pserson p = new Pserson("zhangsan",123);
        return Optional.ofNullable(p);
    }

    @Test
    public void callm5(){
        Optional<Integer> p = this.method5().flatMap(Pserson::getAge);
        System.out.println(p.get());
    }
}

class Pserson{

    private String name;
    private static int age;
    public Pserson(String name,int age){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Optional<Integer> getAge(){
        return Optional.ofNullable(age);
    }
}
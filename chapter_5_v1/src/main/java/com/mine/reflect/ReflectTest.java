package com.mine.reflect;

import org.junit.jupiter.api.Test;

/**
 * reflect 测试类
 */
public class ReflectTest {

    @Test
    public void method1() throws ClassNotFoundException {
        //获取类的Class
        Class clazz = Human.class;
        System.out.println(clazz.getName());
        //运行时实例对象获取Class
        Human human = new Human("张三",12);
        Class clazz1 =  human.getClass();
        System.out.println(clazz1.getName());

        //通过CLass静态方法获取Class
        Class clazz2 = Class.forName("com.mine.reflect.Human");
        System.out.println(clazz2);
    }

}

package com.mine.interfaces;

import org.junit.jupiter.api.Test;

/**
 * 测试类
 */
public class MyTest {


    @Test
    public void method(){
        /**
         * 当一个类继承了一个抽象类和实现了一个接口,接口和抽象类中包含相同的方法签名
         */
        MyInterface myinterface = new Person();
        myinterface.defaultMethod();
    }
}

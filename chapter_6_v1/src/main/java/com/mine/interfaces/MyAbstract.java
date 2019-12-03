package com.mine.interfaces;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 定义一个抽象的类，测试接口中的默认方法的二义性
 */
public abstract class MyAbstract {

    /**
     * 在接口默认方法,可以实现接口的兼容性
     */
     public void defaultMethod(){
        System.out.println("MyAbstract : defaultMethod");
    }
}

package com.mine.interfaces;


public interface MyInterface {
    //设置接口域
    String INTERFACE_NAME = "my_interface";

    /**
     * 设置静态接口方法,接口辅助方法，Java 8 之前有一些接口都有伴随类，来提供一些通用的操作方法
     * java 8 可以在接口中定义静态方法
     */
    static void staticMethod(){}

    static String Instance(){return "Instance";}
    /**
     * 在接口默认方法,可以实现接口的兼容性
     */
    default void defaultMethod(){ }
}

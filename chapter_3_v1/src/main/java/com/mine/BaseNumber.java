package com.mine;

/**
 * @ClassName: BaseNumber
 * @Desc: 测试基本数类型
 * @author： yanyimin
 * @date: 2019/11/24
 * @version: v1.0
 */
public class BaseNumber {
    public static void main(String[] args) {
        //整数除法，结果为7
        int a = 15/2;
        //浮点除法，结果为7.5
        double b = 15.0/2;
        //整数除以零，为产生异常
        //int e = 1/0;
        //浮点数除以零，会得到无穷大或NaN
        double f = 5.0/0;
        System.out.println(f);

        //解决整数余数的问题（主要是负数余数问题）
        int g = Math.floorMod(20,12);
        int h = Math.floorMod(20,-12);
        System.out.println(g+"\t"+h);

        //位运算
        int n = 20;
        int fourthBitFromRight = (n&0b1000)/0b1000;
        System.out.println(fourthBitFromRight);
    }
}

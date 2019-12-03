package com.mine.arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 数组工具类测试
 */
public class ArraysTest {

    @Test
    public void method1(){
        String[] strs = {"dddddd","aaa","bbbb","ccccc"};
        Arrays.sort(strs,new LengthComparator());
        System.out.println(Arrays.toString(strs));
    }

    /**
     * 使用lambda 表达式，实现排序
     */
    @Test
    public void method2(){
        String[] arr = {"dddddd","aaa","bbbb","ccccc"};
        Arrays.sort(arr,(first,second)->first.length() - second.length());
        System.out.println(Arrays.toString(arr));
    }
}

package com.mine.SteamIterator;

import java.util.function.IntFunction;

public class MyIntFunction implements IntFunction<Integer[]> {
    @Override
    public Integer[] apply(int value) {
        Integer[] a = {value*1,value*2,value*3};
        return a;
    }
}

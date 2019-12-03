package com.mine.comparators;

import java.util.Comparator;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public class MyConparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        
        return 0;
    }
}
class MyDoubleFunction implements ToDoubleFunction<Double>{

    public MyDoubleFunction(Integer d) {

    }

    @Override
    public double applyAsDouble(Double value) {
        double v = value*20;
        return v;
    }
}

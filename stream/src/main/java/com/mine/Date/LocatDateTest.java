package com.mine.Date;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class LocatDateTest {

    @Test
    public void method1(){
        LocalTime time = LocalTime.of(12,59);
        LocalTime time2 = LocalTime.of(14,25);
        int a = time.getMinute();
        System.out.println(a);
    }
}

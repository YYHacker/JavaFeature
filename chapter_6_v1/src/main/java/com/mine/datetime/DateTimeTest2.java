package com.mine.datetime;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Java 8 时间练习
 */
public class DateTimeTest2 {

    @Test
    public void method1() throws InterruptedException {
        Instant start = Instant.now();
        Thread.sleep(5000);
        Instant end = Instant.now();
        Duration duration = Duration.between(start,end);
        long d = duration.toMillis();
        System.out.println(d);
    }

    @Test
    public void method2(){
        LocalDateTime datetime1 = LocalDateTime.of(2019,12,10,9,21,55);
        LocalDateTime datetime2 = LocalDateTime.of(2019,12,10,10,23,00);
        Duration d = Duration.between(datetime1,datetime2);
        System.out.println(d.toMillis());
        System.out.println(d.toMinutes());
        System.out.println(d.toHours());
        long m = datetime1.until(datetime2, ChronoUnit.MINUTES);
        System.out.println(m);
        long h = datetime1.until(datetime2,ChronoUnit.HOURS);
        System.out.println(h);
    }
}

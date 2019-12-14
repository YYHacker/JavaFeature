package com.mine.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.List;

public class InstantTest {

    @Test
    public void method1(){
        Instant start = Instant.now();
        Instant start2 =  start.minus(Duration.of(12, ChronoUnit.MINUTES));
        System.out.println(start);
        System.out.println(start2);
    }

    @Test
    public void method2(){
        LocalDateTime datetime1 = LocalDateTime.of(2019,12,10,9,21,55);
        LocalDateTime datetime2 = LocalDateTime.of(2019,12,10,10,23,00);
        Duration duration = Duration.between(datetime1,datetime2);
        long l = duration.get(ChronoUnit.MINUTES);
        System.out.println(l);
    }

    @Test
    public void method3(){
        LocalDate date1 = LocalDate.of(2019,9,16);
        LocalDate date2 = LocalDate.of(2019,12,10);
        Period period = Period.between(date1,date2);
        System.out.println(period);
    }

    @Test
    public void method4(){
        LocalTime time1 = LocalTime.of(15,30,45);
        LocalTime time2 = LocalTime.of(20,30,30);
        String time1s =  time1.format(DateTimeFormatter.ofPattern("ss:mm:HH"));
        System.out.println(time1s);
        Duration d = Duration.between(time2,time1);
        System.out.println(d);
        System.out.println(d.isNegative());
        System.out.println(d.get(ChronoUnit.SECONDS));
        List<TemporalUnit> dlist = d.getUnits();
        for(TemporalUnit t : dlist){
            System.out.println(t.toString());
        }
    }
}

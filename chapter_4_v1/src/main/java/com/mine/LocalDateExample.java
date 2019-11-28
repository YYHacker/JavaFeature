package com.mine;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @ClassName: LocalDateExample
 * @Desc: TODO
 * @author： yanyimin
 * @date: 2019/11/26
 * @version: v1.0
 */
public class LocalDateExample {

    /**
     * localdate 练习
     */
    @Test
    public void localDate(){
        LocalDate localDate = LocalDate.of(2019,10,25);
        LocalDate newdate = localDate.plusDays(10);
        String date = newdate.toString();
        System.out.println(date);
        System.out.println(localDate);
    }

    @Test
    public void localDate2(){
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        int today = localDate.getDayOfMonth();

        localDate = localDate.minusDays(today - 1);
        DayOfWeek day = localDate.getDayOfWeek();
        int value = day.getValue();
        System.out.println(localDate);
        System.out.println(value);
    }

    /**
     * 打印当月的日历
     */
    @Test
    public void printClanner(){
        LocalDate date = LocalDate.now();
        int today =  date.getDayOfMonth();
        LocalDate newdate = date.minusDays(today - 1);
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s","MON","TUE","WED","THU","FRI","SAT","SUN");
        System.out.println();
        int dayWeek = newdate.getDayOfWeek().getValue();
        System.out.printf("%"+(dayWeek-1)*4+"s","");
        for (int i=1;i <=date.lengthOfMonth();i++){
            System.out.printf("%4s",i);
            if(dayWeek == 7){
                dayWeek = 0;
                System.out.println();
            }
            dayWeek++;
        }
    }
}

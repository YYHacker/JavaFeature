package com.mine.datetime;

import com.sun.scenario.effect.Offset;
import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.*;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.Locale;
import java.util.Set;

public class DateTimeTest {

    @Test
    public void method1(){
        Month month = Month.AUGUST;
        Locale locale = Locale.getDefault();
        System.out.println(month.getDisplayName(TextStyle.FULL, locale));
        System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
        System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
    }

    @Test
    public void method2(){
        LocalDate date = LocalDate.of(2017,Month.DECEMBER,25);
        LocalDate date1 = date.with(TemporalAdjusters.firstDayOfNextYear());
        TemporalAdjuster t = TemporalAdjusters.next(DayOfWeek.SUNDAY);
        LocalDate date2 = date1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(date);
        System.out.println(date1);
        System.out.println(date2);
    }

    @Test
    public void method3(){
        LocalDate date = LocalDate.now();
        int length =  date.lengthOfMonth();
        System.out.println(length);
        MonthDay md = MonthDay.of(Month.FEBRUARY,29);
        System.out.println(md);
        boolean b = md.isValidYear(2008);
        assert b == true;
        boolean leap = Year.of(2012).isLeap();
        assert leap == true;
    }

    @Test
    public void method4(){
        for (;;){
            LocalTime time = LocalTime.now();
            System.out.println(time.getHour()+" : "+time.getMinute()+" : "+time.getSecond()+" : "+time.getNano());
        }
    }

    @Test
    public void method5(){
        Set<String> zones = ZoneId.getAvailableZoneIds();
        for (String zone:zones) {
            System.out.println(zone);
        }
    }

    @Test
    public void method6(){
        LocalDateTime datetime = LocalDateTime.now();
        ZonedDateTime zdatetime = datetime.atZone(ZoneId.of("Asia/Chungking"));
        System.out.println(datetime);
        System.out.println(zdatetime);
        System.out.println(zdatetime.getOffset());
    }

    @Test
    public void method7(){
        LocalDateTime dt = LocalDateTime.now();
        ZoneOffset offset = ZoneOffset.of("-18:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(dt,offset);
        System.out.println(dt);
        System.out.println(offsetDateTime);
        int t = offsetDateTime.getDayOfMonth();
        System.out.println(t);
    }

    @Test
    public void method8(){
        System.out.println(Instant.MIN);
        System.out.println(Instant.MAX);
        LocalTime time = LocalTime.now();
    }

    @Test
    public void method9(){
        LocalTime time1 = LocalTime.of(20,30,30);
        LocalTime time2 = LocalTime.of(20,10,10);
        long minutes = ChronoUnit.MINUTES.between(time1,time2);
        System.out.println(minutes);

        Time starttime = new Time(12,30,30);
        Time endtime = new Time(12,50,30);
        long minutes2 = ChronoUnit.MINUTES.between(starttime.toLocalTime(),endtime.toLocalTime());
        System.out.println(minutes2);
    }
}

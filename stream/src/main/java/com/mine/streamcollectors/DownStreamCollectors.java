package com.mine.streamcollectors;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class DownStreamCollectors {
    public static class City{
        private String name;
        private String state;
        private int pupulation;

        public City(String name, String state, int pupulation) {
            this.name = name;
            this.state = state;
            this.pupulation = pupulation;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPupulation() {
            return pupulation;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setState(String state) {
            this.state = state;
        }

        public void setPupulation(int pupulation) {
            this.pupulation = pupulation;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", state='" + state + '\'' +
                    ", pupulation=" + pupulation +
                    '}';
        }
    }

    @Test
    public void method1(){
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> map = locales.collect(groupingBy(Locale::getCountry,toSet()));
        System.out.println(Arrays.toString(map.entrySet().toArray()));
        Map<String, Long> m2 = Stream.of(Locale.getAvailableLocales()).collect(groupingBy(Locale::getCountry,counting()));
        System.out.println(Arrays.toString(m2.entrySet().toArray()));
        Map<String,Optional<String>> m = Stream.of(Locale.getAvailableLocales()).collect(groupingBy(Locale::getCountry,mapping(n->n.getDisplayName(),maxBy(Comparator.comparing(String::length)))));
        System.out.println(Arrays.toString(m.entrySet().toArray()));
    }
}

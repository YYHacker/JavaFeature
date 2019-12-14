package com.mine.streamcollectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;
import java.util.stream.Stream;

public class CollectorsTest {

    @Test
    public void method1(){
        JSONObject obj1 = new JSONObject();
        obj1.put("name","张三");
        obj1.put("seatno","001");
        JSONObject obj2 = new JSONObject();
        obj2.put("name","李四");
        obj2.put("seatno","002");
        JSONObject obj3 = new JSONObject();
        obj3.put("name","王五");
        obj3.put("seatno","002");
        JSONArray array = new JSONArray();
        array.add(obj1);
        array.add(obj2);
        array.add(obj3);

       IntSummaryStatistics obj =  array.stream().collect(Collectors.summarizingInt(n -> ((JSONObject)n).getInteger("seatno")));
       System.out.println(obj.getCount());
    }

    @Test
    public void method2(){
       Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale:locales) {
//            System.out.println(locale.getCountry());
        }
       Map<Boolean, List<Locale>> map = Arrays.stream(locales).collect(Collectors.partitioningBy(locale -> locale.getCountry() == "CH"));
       List<Locale> list = map.get(true);
       System.out.println(Arrays.toString(list.toArray()));
       System.out.println(Arrays.toString(map.get(false).toArray()));
    }

    @Test
    public void method3(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> m1 = new HashMap<>();
        m1.put("sno","0001");
        m1.put("name","王五");
        Map<String,String> m2 = new HashMap<>();
        m2.put("sno","0002");
        m2.put("name","李四");
        list.add(m1);
        list.add(m2);
        Optional<Map<String,String>> m = list.stream().filter(n-> n.get("sno").equals("0002")).findAny();
        String name = m.get().get("name");
        System.out.println(name);
    }

    public List<Map<String,String>> getlist(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> m1 = new HashMap<>();
        m1.put("sno","0001");
        m1.put("name","王五");
        m1.put("score","60");
        Map<String,String> m2 = new HashMap<>();
        m2.put("sno","0002");
        m2.put("name","李四");
        m1.put("score","80");
        Map<String,String> m3 = new HashMap<>();
        m3.put("sno","0003");
        m3.put("name","赵谦");
        m3.put("score","70");
        Map<String,String> m4 = new HashMap<>();
        m4.put("sno","0003");
        m4.put("name","菲菲");
        m4.put("score","95");
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        return list;
    }
    public void print(Collection c){
        System.out.println(Arrays.toString(c.toArray()));
    }
    @Test
    public void method5(){
        List<Map<String,String>> list = getlist();
        Map<String,Set<Map<String,String>>> map = list.stream().collect(groupingBy(n -> n.get("sno"),toSet()));
        print(map.entrySet());
        Map<String,List<String>> m = list.stream().collect(groupingBy(n->n.get("sno"),mapping(n->n.get("name"),toList())));
        System.out.println(m.entrySet());
    }
}

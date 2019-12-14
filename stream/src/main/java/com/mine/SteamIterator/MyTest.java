package com.mine.SteamIterator;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Stream;

public class MyTest {

    @Test
    public void method(){
        List<Map<String,String>> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("id","111");
        map.put("name","王五");
        Map<String,String> map2 = new HashMap<>();
        map2.put("id","222");
        map2.put("name","李四");
        Map<String,String> map3 = new HashMap<>();
        map3.put("id","333");
        map3.put("name","李四");
        list.add(map);
        list.add(map2);
        list.add(map3);

        Optional<Map<String,String>> straam =  list.parallelStream().filter(n -> n.containsValue("李四")).findAny();
         Set<Map.Entry<String,String>> maps = straam.get().entrySet();
        for (Map.Entry<String,String> s : maps) {
            System.out.println(s.getValue());
        }
    }

    @Test
    public void method2(){
        JSONObject obj1 = new JSONObject();
        obj1.put("name","王五");
        obj1.put("seatno","001");
        JSONObject obj2 = new JSONObject();
        obj2.put("name","王五");
        obj2.put("seatno","002");
        JSONObject obj3 = new JSONObject();
        obj3.put("name","王五");
        obj3.put("seatno","002");
        List<JSONObject> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        JSONArray a = new JSONArray();
        a.add(obj1);
        a.add(obj2);
        a.add(obj3);
        List<Map> maplist =  a.toJavaList(Map.class);
        System.out.println(obj1.getString("seatno"));
        long count = list.stream().peek(n -> n.get("seatno")).distinct().count();
        long count2 = maplist.stream().peek(n -> n.get("seatno")).distinct().count();
        Stream stream = maplist.stream().peek(n -> n.get("seatno")).distinct();
        System.out.println(Arrays.toString(stream.toArray()));
        System.out.println(count);
        System.out.println(count2);
    }

    @Test
    public void method3(){
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
        List<Map> list =  array.toJavaList(Map.class);
        boolean count =   array.stream().allMatch(n-> {JSONObject b = (JSONObject) n;return b.getString("seatno") == "001";});
        long c = array.stream().peek(n -> ((JSONObject) n).getString("seatno")).distinct().count();
        System.out.println(c);
        Stream<String> s = array.stream().filter(n-> ((JSONObject)n).getString("name") == "王五" ).map(n -> ((JSONObject)n).getString("seatno"));
        System.out.println(Arrays.toString(s.toArray()));
    }

}

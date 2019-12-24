package com.mine.path;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author yanyimim
 * @since 2019/12/20 16:35
 */
public class PathTest {

    @Test
    public void method1() throws MalformedURLException {

        Path path = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","path");
        Path path1 = Paths.get(System.getProperty("user.dir"));
        URI uri = path.toUri();
        Properties props = System.getProperties();
        String s = props.getProperty("base.dir");
        Path p = path.resolve("sss");
        System.out.println(p.toString());
        Path p1 = path.resolveSibling("newpath");
        System.out.println(p1);
        Path p2 = path.relativize(path1);
        System.out.println(p2.toString());
    }

    @Test
    public void method2(){
        Path one = Paths.get("src","main","java");
        Path two = Paths.get("","src","mains","resource");
        int i = one.compareTo(two);
        System.out.println(i);
    }

    @Test
    public void method3(){
        Path p1 = Paths.get("src","main","java");
        Path p2 = Paths.get("src","main","java");
        assert p1.equals(p2) == true;
    }

    @Test
    public void method4(){
        Path p1 = Paths.get("src","main","java");
        Path p2 = Paths.get("src","main","java");
        assert p1.endsWith(p2) == true;
        assert p1.endsWith("src\\main\\java\\");
    }

    @Test
    public void method5(){
        Path p1 = Paths.get("src","main","java");
        Path p2 = Paths.get("src","main","java");
        assert p1.equals(p2);
    }

    @Test
    public void method6(){
        Path p1 = Paths.get("src","main","java","com","main","path");
        System.out.println(p1.getFileName());
        assert "path".equals(String.valueOf(p1.getFileName()));
    }

    @Test
    public void method7(){
        Path p1 = Paths.get("src","main");
        FileSystem fs = p1.getFileSystem();
        assert fs.getSeparator().equals("\\");
    }

    @Test
    public void method8(){
        Path p1 = Paths.get("src","main","java");
        Path p2 = p1.getName(0);
        System.out.println(p2.toString());
    }

    @Test
    public void method9(){
        Path p1 = Paths.get(System.getProperty("user.dir"),"src","main","java");
        System.out.println(p1.getNameCount());
        Path p2 = p1.getRoot();
        System.out.println(p2);
        assert p1.isAbsolute();
    }

    @Test
    public void method10(){
        Path p1 = Paths.get(System.getProperty("user.dir"),"src","main","java");
        Iterator it = p1.iterator();
        while(it.hasNext()){
            System.out.println(String.valueOf(it.next()));
        }
    }

    @Test
    public void method11(){
        Path p1 = Paths.get(System.getProperty("user.dir"),"src","main","..","java");
        System.out.println(p1.normalize());
    }

    @Test
    public void method12(){
        Path p1 = Paths.get("src","main");
        Path p2 = Paths.get("src","main");
        Path p3 = p1.relativize(p2);
        System.out.println(p3.toString());
        Path p4 = Paths.get(System.getProperty("user.dir"),"src","main","java");
        Path p5 = Paths.get(System.getProperty("user.dir"),"com");
        Path p6 = p4.relativize(p5);
        System.out.println(p6.toString());
    }

    @Test
    public void method13(){
        Path p1 = Paths.get("src","main","java","path");
        Path p2 = Paths.get("src","java");
        System.out.println(p1.toAbsolutePath());
        System.out.println(p1.subpath(1,2));
    }

    @Test
    public void method14(){
        Path p1 = Paths.get("src","main","java","path");
        Path p2 = Paths.get("src","main");
        System.out.println(p1.relativize(p2));
        Path p3 = Paths.get("src","main","java","path");
        Path p4 = Paths.get("src","main","test");
        System.out.println(p3.relativize(p4));
    }

    @Test
    public void method15(){
        Path p1 = Paths.get(System.getProperty("user.dir"),"src","main","java","path");
        Path p2 = Paths.get(System.getProperty("user.dir"),"src","java");
        System.out.println(p1.relativize(p2));
    }
}

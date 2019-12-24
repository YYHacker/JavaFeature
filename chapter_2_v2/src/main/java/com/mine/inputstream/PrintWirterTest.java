package com.mine.inputstream;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author yanyimim
 * @since 2019/12/19 13:23
 */
public class PrintWirterTest {

    @Test
    public void method1(){
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","out.txt");
        try(PrintWriter pw2 = new PrintWriter(outpath.toString(), String.valueOf(StandardCharsets.UTF_8));
            PrintWriter pw3 = new PrintWriter(outpath.toFile(), String.valueOf(StandardCharsets.UTF_8))){
            pw3.write("李丽丽");
            pw2.println("sadfasf");
            Map<String,String> map= new HashMap<String,String>();
            map.put("one","李四");
            map.put("two","张三");
            pw2.println(map);
            pw2.printf("%4s : %8s","姓名","默默");
            if(pw2.checkError()) System.out.println("Error");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method2() throws FileNotFoundException {
       try(PrintWriter pw = new PrintWriter(new PrintStream(""));){
           pw.write("wangwu");
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

    @Test
    public void method3() throws IOException {
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        String str = new String(Files.readAllBytes(inpath),StandardCharsets.UTF_8);
        List<String> linelist = Files.readAllLines(inpath);
        for (String s : linelist) {
            System.out.println(s);
        }
    }

    @Test
    public void method4() throws IOException {
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        Stream<String> s = Files.lines(inpath).limit(10);
        s.forEach(System.out::println);
    }

    @Test
    public void method5(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        try(InputStream in = new FileInputStream(inpath.toString());
            BufferedReader bin = new BufferedReader(new InputStreamReader(in))){
            String line;
            while((line = bin.readLine()) != null){
                System.out.println(line);
            }
            Stream<String> lines = bin.lines();
            lines.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method6(){
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","employee.dat");
        try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outpath.toString())))){
            pw.println(new Employee("黎明",1800, LocalDate.of(2019,11,16)));
            pw.println(new Employee("丽江市",1800, LocalDate.of(2019,11,16)));
            pw.println(new Employee("王鹏程",1800, LocalDate.of(2019,11,16)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void method7(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","employee.dat");
        try(Scanner sc = new Scanner(new FileInputStream(inpath.toFile()))){
            while(sc.hasNext()){
                String[] s = sc.nextLine().split("\\|");
                String name = String.valueOf(s[0]);
                double salay = Double.parseDouble(s[1]);
                LocalDate hireday = LocalDate.parse(s[2]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void method8(){
        System.out.println(Charset.defaultCharset());
//        System.out.println(System.setProperty("file.encoding","GB2312"));
        System.out.println(System.getProperty("file.encoding"));
        Charset gb2312 = Charset.forName("GB2312");
        Map<String,Charset> m = Charset.availableCharsets();
        System.out.println(StandardCharsets.UTF_8);
        String s = new String("王五".getBytes(Charset.forName("GB2312")),Charset.forName("GB2312"));
        System.out.println(s);
    }

    @Test
    public void method9(){
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","data.txt");
        Path outp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","data.txt");
        try(DataInputStream din = new DataInputStream(new FileInputStream(inp.toString()));
            DataOutputStream dout = new DataOutputStream(new FileOutputStream(outp.toFile()))){
            dout.writeBoolean(true);
            dout.writeUTF("王菲");
            dout.writeDouble(20.35);
            dout.writeUTF("王菲");
            dout.flush();
            System.out.println(din.readDouble());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.mine.inputstream;

import com.sun.deploy.util.StringUtils;
import jdk.internal.util.xml.impl.Input;
import org.junit.jupiter.api.Test;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author yanyimim
 * @since 2019/12/19 11:05
 */
public class BufferedInputStreamTest {

    @Test
    public void method1(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src_out.zip");
        try(BufferedInputStream bin = new BufferedInputStream(new FileInputStream(inpath.toString()),1024);
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(outpath.toFile()),1024)){
            Instant start = Instant.now();
            /*int i;
            while((i = bin.read()) != -1){
                bout.write(i);
            }*/
            byte[] bytes = new byte[1024];
            int len = 0;
            while((len = bin.read(bytes)) != -1){
                bout.write(bytes,0,len);
            }
            Instant end = Instant.now();
            long d = Duration.between(start,end).toMillis();
            System.out.println(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method2(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src_out.zip");
        try(FileInputStream in = new FileInputStream(inpath.toFile());
            FileOutputStream out = new FileOutputStream(outpath.toFile())){
            Instant start = Instant.now();
            int i ;
            while((i=in.read())!= -1){
                out.write(i);
            }
            Instant end = Instant.now();
            long d = Duration.between(start,end).toMillis();
            System.out.println(d);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mehtod3(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","u.txt");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src_out.zip");
        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(inpath.toString()),  StandardCharsets.UTF_8) ){
            int i ;
            while((i = reader.read()) != -1){
                System.out.println((char)i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method4() throws IOException {
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","out.dat");
        try(PrintWriter pw = new PrintWriter(outpath.toFile(),"GB2312");){
            pw.write("张三");
        }
    }

    @Test
    public void method5(){
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","out.dat");
        try(PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outpath.toString())),true)){
            Stream.generate(()-> "baby she ").limit(100).forEach(pw::write);
            if(pw.checkError()){
                System.out.println("Error");
            };
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void method6(){

    }
}

package com.mine.inputstream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author yanyimim
 * @since 2019/12/18 17:56
 */
public class FileInputStreamTest {

    @Test
    public void method1(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","inputstream","in.txt");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","inputstream","out.txt");
        Path doutpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","inputstream","dout.txt");
        try(FileInputStream in = new FileInputStream(inpath.toString());
            FileOutputStream out = new FileOutputStream(outpath.toString());
            DataInputStream din = new DataInputStream(in);
            DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(doutpath.toString())))){
            byte[] b = new byte[20];
            int i = in.read(b);
            out.write(b);
            dout.write(b);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void method2(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","out.txt");
        try(FileInputStream in = new FileInputStream(inpath.toString());
            FileOutputStream out = new FileOutputStream(outpath.toString());
            PushbackInputStream back = new PushbackInputStream(in)){
            byte[] b1 = new byte[2];
            int bb = back.read();
            assert bb == 'n';
            if(bb != 'n')back.unread(bb);
            int bd = back.read();
            assert bd == 'a';
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method3(){
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(inpath.toString()));
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(outpath.toString()))){

            zin.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method4(){
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        Path outp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","srcd.zip");
        try(FileInputStream fin = new FileInputStream(inp.toFile());
            FileOutputStream fout = new FileOutputStream(outp.toString(),true)){
            byte[] bb = new byte[1024];
            int b = 0;
            Instant start = Instant.now();
            while(b != -1){
                 b = fin.read(bb);
                fout.write(b);
            }
            Instant end = Instant.now();
            System.out.println(Duration.between(start,end).getUnits());
            System.out.println(Duration.between(start,end).get(ChronoUnit.SECONDS));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method5()  {
        Path inpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        Path outpath = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","out.txt");
        try(FileInputStream in = new FileInputStream(inpath.toString());
            FileOutputStream out = new FileOutputStream(outpath.toFile())){
                int i ;
                while((i = in.read()) != -1){
                    out.write(i);
                }
               /* byte[] bytes = new byte[in.available()];
                in.read(bytes);
                for (byte b :bytes) {
                    out.write(b);
                }*/
              /* byte[] bytes = new byte[15];
               int len = 0;
               while((len = in.read(bytes)) != -1){
                   out.write(bytes,0,len);
               }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

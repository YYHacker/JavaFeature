package com.mine.inputstream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author yanyimim
 * @since 2019/12/19 16:00
 */
public class ZipTest {

    @Test
    public void method1(){
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(inp.toFile()))){
            ZipEntry entry;
            while((entry = zin.getNextEntry()) != null){
                System.out.println(entry.getName());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method2(){
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","bnd.zip");
        Path zein = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","data.txt");
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(inp.toString()));){
            ZipEntry entry;
            while((entry = zin.getNextEntry())!= null){
                System.out.println(entry.getSize());
                System.out.println(entry.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void method3() throws IOException {
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","src.zip");
        try(ZipFile zf = new ZipFile(inp.toFile());){
            Enumeration e = zf.entries();
            System.out.println(zf.size());
           while(e.hasMoreElements()){
               ZipEntry ze = zf.getEntry(e.nextElement().toString());
               System.out.println(ze.getName());
           }
        }
    }
}

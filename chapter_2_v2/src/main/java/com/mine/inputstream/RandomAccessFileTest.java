package com.mine.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yanyimim
 * @since 2019/12/19 15:40
 */
public class RandomAccessFileTest {

    @Test
    public void method1(){
        Path inp = Paths.get(System.getProperty("user.dir"),"src","main","java","com","mine","file","in.txt");
        try(RandomAccessFile ra = new RandomAccessFile(inp.toFile(),"rw");){
            System.out.println(ra.length());
            ra.seek(ra.length());
            ra.writeChar('A');
            System.out.println(ra.getFilePointer());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

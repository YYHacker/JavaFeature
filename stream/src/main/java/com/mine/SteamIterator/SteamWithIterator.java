package com.mine.SteamIterator;


import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SteamWithIterator
 * @Desc: 测试Steam 和 传统迭代区别
 * @author： yanyimin
 * @date: 2019/11/23
 * @version: v1.0
 */
public class SteamWithIterator {

    private final String path="E:\\IJworkspace\\JavaFeature\\stream\\src\\main\\java\\com\\mine\\SteamIterator\\file.txt";

    /**
     * 使用传统的处理
     * @throws IOException
     */
    @Test
    public void readFileIterator() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        int count = 0;
        for(String word: words){
            System.out.println(word);
            if(word.length()>5)count++;
        }
        System.out.println(count);
    }

    /**
     * 使用stream流进行处理
     */
    @Test
    public void useStream() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        long count = words.stream().filter(e -> e.length()>5).count();
        System.out.println(count);
    }

    /**
     * 使用并发ParallelStream 操作集合
     */
    public void useParalleStream() throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(content.split("\\$"));
        long count = words.parallelStream().filter(w -> w.length()>5).count();
        System.out.println(count);
    }
}

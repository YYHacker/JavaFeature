package com.mine.files;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author yanyimim
 * @since 2019/12/24 13:30
 */
public class FileTest {

    @Test
    public void method1() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p2 = Paths.get("src","main","java","com","mine","file","o.txt");
        byte[] b = Files.readAllBytes(p1);
        try(FileOutputStream fout = new FileOutputStream(p2.toString())){
            fout.write(b);
        }
    }

    @Test
    public void method2() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        List<String> list = Files.readAllLines(p1);
        for (String s:list) {
            System.out.println(s);
        }
    }

    @Test
    public void method3() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p2 = Paths.get("src","main","java","com","mine","file","o.txt");
        byte[] b = Files.readAllBytes(p1);
        Files.write(p2,b, StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Test
    public void method4() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p2 = Paths.get("src","main","java","com","mine","file","o.txt");
        List<String> lines = Files.readAllLines(p1);
        Files.write(p2,lines, Charset.forName("GB2312"),StandardOpenOption.APPEND);
    }

    @Test
    public void method5() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p2 = Paths.get("src","main","java","com","mine","file","o.txt");
        @Cleanup InputStream in = Files.newInputStream(p1);
        @Cleanup OutputStream out = Files.newOutputStream(p2);
        byte[] b = new byte[in.available()];
        in.read(b);
        out.write(b);
        System.out.println(in.available());
    }

    @Test
    public void method6() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p2 = Paths.get("src","main","java","com","mine","file","o.txt");
        @Cleanup BufferedReader bf = Files.newBufferedReader(p1);
        @Cleanup BufferedWriter bw = Files.newBufferedWriter(p2);
        String line;
        while((line = bf.readLine()) != null){
            bw.write(line);
        }
    }

    @Test
    public void method7() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","newfile");
        System.out.println(PosixFilePermissions.fromString("rw-------"));
        if(Files.notExists(p1))Files.createDirectory(p1);
        Files.delete(p1);
    }
    @Test
    public void method8() throws IOException {
        Path tempp1 = Files.createTempFile("name",".txt");
        Path p1 = Paths.get("src","main","java","com","mine","file","in.txt");
        try(FileInputStream fin = new FileInputStream(p1.toString());
            FileOutputStream fout = new FileOutputStream(tempp1.toString())){
            byte[] b = new byte[fin.available()];
            fin.read(b);
            fout.write(b);
        }
    }

    @Test
    public void method9() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","newfile");
        Path p2 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p3 = Paths.get("src","main","java","com","mine","newfile","o.txt");
        Path p4 = Paths.get("src","main","java","com","mine","newfile","in.txt");
        if(Files.notExists(p1))Files.createDirectory(p1);
        if(Files.notExists(p3))Files.copy(p2,p3);
//        Files.move(p2,p4, StandardCopyOption.ATOMIC_MOVE);
        System.out.println(Files.isHidden(p4));
        System.out.println(Files.isReadable(p4));
        System.out.println(Files.isExecutable(p4));
        System.out.println(Files.isRegularFile(p4));
        System.out.println(Files.isSameFile(p2,p4));
        long size = Files.size(p4);
        System.out.println(size);
        System.out.println(Files.getOwner(p4));
    }

    @Test
    public void method10() throws IOException {
        Path p2 = Paths.get("src","main","java","com","mine","file","in.txt");
        Path p1 = Paths.get("C:\\Users\\Public\\Desktop","Navicat Premium 12.lnk");
        BasicFileAttributes attrs = Files.readAttributes(p1, BasicFileAttributes.class);
        System.out.println(attrs.isSymbolicLink());
        System.out.println(attrs.lastAccessTime());
    }

    @Test
    public void method11() throws IOException {
        Path p1 = Paths.get("C:\\Users\\Public\\Desktop","Navicat Premium 12.lnk");
        PosixFileAttributes pa = Files.readAttributes(p1, PosixFileAttributes.class);
        System.out.println(Arrays.toString(pa.permissions().toArray()));
    }

    @Test
    public void method12() throws IOException {
        Path p2 = Paths.get("src","main","java","com","mine","file");
        Stream<Path> s = Files.list(p2);
        s.forEach(System.out::println);
    }

    @Test
    public void method13() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file");
        Stream<Path> paths = Files.walk(p1,FileVisitOption.FOLLOW_LINKS);
        paths.forEach(System.out::println);
    }

    @Test
    public void method14() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","subfile");
        @Cleanup DirectoryStream<Path> ds = Files.newDirectoryStream(p1,"**.log");
        for (Path p :ds) {
            System.out.println(p);
        }
    }
    @Test
    public void method15() throws IOException {
        Path p1 = Paths.get("src","main","java","com","mine","file","subfile");
        Files.walkFileTree(p1, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println("preVisitDirectory::::"+dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("visitFile::::"+file);
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                Objects.requireNonNull(file);
                throw exc;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

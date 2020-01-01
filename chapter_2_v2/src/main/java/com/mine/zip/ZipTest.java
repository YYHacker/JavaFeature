package com.mine.zip;

import lombok.Cleanup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;
import java.util.zip.ZipInputStream;

/**
 * @author yanyimim
 * @since 2019/12/25 14:57
 */
public class ZipTest {

    @Test
    public void method1() throws IOException {
        Path path = Paths.get("src","main","java","com","mine","file","src.zip");
        Path topath = Paths.get("src","main","java","com","mine","file","Enum.java");
        try(FileSystem fs = FileSystems.newFileSystem(path,null)) {
            Files.copy(fs.getPath("java/lang/Enum.java"),topath,StandardCopyOption.REPLACE_EXISTING);
            Files.copy(fs.getPath("java","lang","Enum.java"),topath,StandardCopyOption.REPLACE_EXISTING);
        }
    }

    @Test
    public void method2() throws IOException {
        Path path = Paths.get("src","main","java","com","mine","file","src.zip");
        @Cleanup FileSystem fs = FileSystems.newFileSystem(path,null);
        Files.walkFileTree(fs.getPath("/"),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException
            {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}

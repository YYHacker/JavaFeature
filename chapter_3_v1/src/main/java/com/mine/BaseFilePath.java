package com.mine;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * @ClassName: BaseFilePath
 * @Desc: 查找文件路径
 * @author： yanyimin
 * @date: 2019/11/24
 * @version: v1.0
 */
public class BaseFilePath {
    public static void main(String[] args) throws IOException {
        StringBuffer path = new StringBuffer();
        path.append(System.getProperty("user.dir")+File.separator);
        path.append("chapter_3_v1"+File.separator);
        path.append("src"+File.separator);
        path.append("main"+ File.separator);
        path.append("java"+File.separator);
        path.append("com"+File.separator);
        path.append("mine"+File.separator);
        path.append("MyFile.txt");

        Scanner scanner = new Scanner(Paths.get(path.toString()),"UTF-8");
        String line = scanner.nextLine();
        System.out.println(line);
    }
}

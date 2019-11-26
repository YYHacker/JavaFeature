package com.mine;

import java.util.Scanner;

/**
 * @ClassName: BaseScanner
 * @Desc: 使用标准输入流
 * @author： yanyimin
 * @date: 2019/11/24
 * @version: v1.0
 */
public class BaseScanner {
    public static void main(String[] args) {
        System.out.println("what is you name ?");
        Scanner in = new Scanner(System.in);
        //读取输入的下一个单词,以空格作为分隔符
        String word = in.next();
        System.out.println("获取一个单词:"+word+" 输入一行：");
        //读取一行
        String line = in.nextLine();
        System.out.println("读取一行:"+line+" 输入整数：");
        //读取下一个整形
        int a = in.nextInt();
        System.out.println("读取下一个整数:"+a+" 输入浮点类型：");
        //读取下个整形或浮点型
        double b = in.nextDouble();
        System.out.println("读取下一个整数或浮点数:"+a+" 输入多个值：");
        //
        while(in.hasNext()) System.out.println(in.next());
        while(in.hasNextInt()) System.out.println(in.nextInt());
    }
}

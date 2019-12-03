package com.mine;


/**
 * @ClassName: BaseString
 * @Desc: TODO
 * @author： yanyimin
 * @date: 2019/11/24
 * @version: v1.0
 */
public class BaseString {
    public static void main(String[] args) {
        //使用String的join方法在字符串连接中间指定分隔符
        String str = String.join(":","aaa","bbb","ccc");
        System.out.println(str);

        System.out.println('\u0101');
        String sentence = "hi？";
        for (int i = 0; i < sentence.length(); i++) {
            char a = sentence.charAt(i);
            System.out.println("char: "+Integer.toHexString(a));
        }

        for (int i=0;i<sentence.length();){
            int cp = sentence.codePointAt(i);
            if(Character.isSupplementaryCodePoint(cp))i+=2;
            else i++;
            System.out.println(Character.toChars(cp));
        }
        //把字符串转换为码点数组，有些符号占两位char
        int[] codePoints = sentence.codePoints().toArray();
        //把码点转换为字符串
        String string = new String(codePoints,0,codePoints.length);
        System.out.println(string);
    }

    public void method2(){
        System.out.println("Test");
    }

    public void callm2(){
    }
}

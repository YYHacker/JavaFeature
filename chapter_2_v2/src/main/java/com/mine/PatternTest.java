package com.mine;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yanyimim
 * @since 2019/12/18 17:27
 */
public class PatternTest {

    @Test
    public void method1(){
        Pattern p = Pattern.compile("");
        Matcher m = p.matcher("");
        if(m.matches())System.out.printf("");
    }
}

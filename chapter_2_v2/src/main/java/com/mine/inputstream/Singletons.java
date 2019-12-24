package com.mine.inputstream;

import org.junit.platform.commons.util.StringUtils;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author yanyimim
 * @since 2019/12/20 13:15
 */
public class Singletons implements Serializable {
    public static final long serialVersionUID = -1L;
    private Singletons(){}
    public static final Singletons wangwu = new Singletons(1);
    public static final Singletons lisi = new Singletons(2);
    private int value;
    private int age;
    private Singletons(int value){
        this.value = value;
    }


    private Object readResolve() throws ObjectStreamException{
        if(value == 1)return wangwu;
        if(value == 2)return lisi;
        throw new InvalidObjectException("无效对象");
    }

    @Override
    public String toString() {
        return "Singletons{" +
                "value=" + value +
                ", age=" + age +
                '}';
    }
}

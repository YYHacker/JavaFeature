package com.mine.interfaces;

import org.omg.Messaging.SyncScopeHelper;

/**
 * 测试类
 */
public class Person implements MyInterface,InterfaceTwo{


    @Override
    public void defaultMethod() {
        System.out.println("Person : defaultMethod");
    }
}

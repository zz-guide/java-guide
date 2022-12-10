package com.xulei.singleton;

import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        Singleton1 instance = Singleton1.getInstance();
        Singleton1 instance1 = Singleton1.getInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

        Singleton2 instance3 = Singleton2.getInstance();
        Singleton2 instance4 = Singleton2.getInstance();
        System.out.println(instance3.hashCode());
        System.out.println(instance4.hashCode());
    }
}

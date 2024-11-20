package org.zz.java.guide.generic;

import org.junit.jupiter.api.Test;
import org.zz.java.guide.generic.pojo.MyGeneric;

public class MyGenericTests {

    @Test
    public void test() {
        MyGeneric<String> stringMyGeneric = new MyGeneric<>("张三");
        System.out.println(stringMyGeneric.getKey());

        MyGeneric<Integer> integerMyGeneric = new MyGeneric<>(123);
        System.out.println(integerMyGeneric.getKey());
    }
}

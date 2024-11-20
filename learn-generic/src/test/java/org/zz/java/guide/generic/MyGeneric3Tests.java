package org.zz.java.guide.generic;

import org.junit.jupiter.api.Test;
import org.zz.java.guide.generic.pojo.MyGeneric3;

public class MyGeneric3Tests {

    @Test
    public void test() {
        String name = MyGeneric3.show("张三");
        System.out.println(name);

        String name1 = MyGeneric3.show1("张三");
        System.out.println(name1);
    }
}

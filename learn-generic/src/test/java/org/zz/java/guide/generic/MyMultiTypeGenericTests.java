package org.zz.java.guide.generic;

import org.junit.jupiter.api.Test;
import org.zz.java.guide.generic.pojo.MyMultiTypeGeneric;

public class MyMultiTypeGenericTests {
    @Test
    public void test() {
        // 在创建泛型类的对象时，必须指定类型参数 T 的具体数据类型，即尖括号 <> 中传入的什么数据类型，T 便会被替换成对应的类型。
        MyMultiTypeGeneric<String,Number> stringMyGeneric = new MyMultiTypeGeneric<>("张三", 23);
        System.out.println(stringMyGeneric.getValue1());
        System.out.println(stringMyGeneric.getValue2());
    }
}

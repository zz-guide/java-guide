package org.zz.java.guide.generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Generic1Tests {
    @Test
    public void test() {
        // 如果 <> 中什么都不传入，则默认是 < Object >。
        // <> 中什么都不传入，等价于 Generic<Object> generic = new Generic<>();
        ArrayList<Object> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add(111); // 编译报错 java: 不兼容的类型: int无法转换为java.lang.String
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }

    @Test
    public void test2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        // list.add(111);// 在编译阶段,编译器会报错, java: 不兼容的类型: int无法转换为java.lang.String
        for (int i = 0; i < list.size(); i++) {
            System.out.println((String)list.get(i));
        }
    }

}

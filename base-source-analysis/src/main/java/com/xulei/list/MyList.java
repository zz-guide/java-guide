package com.xulei.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MyList {
    public static void main(String[] args) {
        System.out.println("你好");
        tArrayList();
    }

    public static void tArrayList() {
        // ArrayList

        ArrayList<Integer> list = new ArrayList<>(20);
        // add()添加元素
        list.add(1);
        list.add(2);
        list.add(3);
//        System.out.println("长度:"+ list.size());
//        System.out.println(list);
//        list.set(0,5);
        // 清除全部元素
//        list.clear();
        // 复制元素,浅拷贝，Arrays.copyOf也是浅拷贝
//        ArrayList<Integer> list2 = (ArrayList<Integer>) list.clone();
//        list2.set(0,5);
//        System.out.println(list2);
//        System.out.println(list2 == list);
//        System.out.println(list);
        // arraylist获取数组
        Object[] list3 =  list.toArray();
        list3[0] = 123;
        System.out.println(list);
        System.out.println(Arrays.deepToString(list3));

    }
}

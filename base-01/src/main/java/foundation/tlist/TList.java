package foundation.tlist;

import java.util.ArrayList;

/**
 *  ArrayList 动态数组
 *
 */


public class TList {
    public static void main(String[] args) {
        curd();
    }

    public static void curd(){
        // 不能是基本类型，需要换成包装类型
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);

        list1.set(1, 55);
        System.out.println(list1);

        list1.remove(1);
        System.out.println(list1);

        System.out.println(list1.get(1));
        System.out.println(list1.size());   // 实际个数
    }

    public static void iterator(){

    }
}

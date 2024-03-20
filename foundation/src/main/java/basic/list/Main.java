package basic.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList 动态数组
 */


public class Main {
    public static void main(String[] args) {
//        curd();
        removeList();
    }

    public static void curd() {
        // 不能是基本类型，需要换成包装类型
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);

        list1.set(1, 55);
        System.out.println(list1);

        // 传入索引或者元素本身
        list1.remove(1);
        System.out.println(list1);

        System.out.println(list1.get(1));
        System.out.println(list1.size());   // 实际个数
    }

    public static void removeList() {
        // 1、用for循环遍历List删除元素时，需要注意索引会左移的问题。
        // 2、List删除元素时，为避免陷阱，建议使用迭代器iterator的remove方式。
        // 3、List删除元素时，默认按索引删除，而不是对象删除。
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("aaa" + i);
            list.add("aaa" + i);
        }

        System.out.println(list);

        // for循环中若list有重复值，删除的时候只能删除第一个，后边重复值的元素无法删除
        // 因为删除的时候，index发生变化了，后边元素会往前移动
        // 解决办法：for循环倒着来
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).equals("aaa3")) {
//                list.remove(i);
//            }
//        }

        // 解决方案一：倒着遍历
//        for (int i = list.size() - 1; i >= 0; i--) {
//            if (list.get(i).equals("aaa3")) {
//                list.remove(i);
//            }
//        }

        // 报错与自己的实现有关，modCount，expectedModCount这俩值不相等导致
//        for (String str : list) {
//            // 报错 Exception in thread "main" java.util.ConcurrentModificationException
//            if (str.equals("aaa3")) list.remove(str);
//        }

        // 解决方案二：使用collections.removeIf()
//        list.removeIf(str -> str.equals("aaa3"));


        // 解决方案三：使用迭代器对象进行删除即可
//        Iterator<String> it = list.iterator();
//        while (it.hasNext()) {
//            if (it.next().equals("aaa3")) {
//                it.remove(); // 此处使用迭代器删除，不能使用list删除
//            }
//        }

        System.out.println(list);
    }
}

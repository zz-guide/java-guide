package org.zz.collection;

import java.util.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zz.common.entity.DemoUser;

public class MapTests {

    @Test
    void crud() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "许磊");
        map.put("age", "27");
        Assertions.assertEquals(2, map.size(), "创建一个map");
        Assertions.assertEquals("许磊", map.get("name"), "读取map");
        Assertions.assertEquals("许磊", map.remove("name"), "删除map的某一个key");
        map.put("name", "张三");
        Assertions.assertEquals("张三", map.get("name"), "修改map后再次读取");
    }

    @Test
    void iter() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // 方式一：使用 entrySet 遍历键值对
        System.out.println("使用 entrySet 遍历：");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 方式二：使用 keySet 遍历键，再通过键获取值
        System.out.println("\n使用 keySet 遍历：");
        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // 方式三：使用 forEach 方法（Java 8 及以上）
        System.out.println("\n使用 forEach 方法遍历：");
        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));

        // 方式四：使用 Iterator 方法
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    @Test
    void remove() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // for 循环中直接删除，报错
        for (String key : map.keySet()) {
            // java.util.ConcurrentModificationException
            map.remove(key);
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        // 使用iterator删除，正常
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (Objects.equals(entry.getKey(), "2")) {
                iterator.remove();
            }
        }

        // 使用entrySet.removeIf()删除，正常
        map.entrySet().removeIf(entry -> Objects.equals(entry.getKey(), "2"));

        // 通过value移除
        map.values().removeIf(value -> value != 1);
        // 通过key移除
        map.keySet().removeIf(key -> !Objects.equals(key, "name"));
        // 通过键/值的输入/组合删除
        map.entrySet().removeIf(entry -> !Objects.equals(entry.getKey(), "asd"));
    }


    @Test
    void runEqualsAndHashCode() {
        // equals默认比较的是引用，可以重写
        // hashCode 返回对象内存地址的HASH值，常用与HashMap,HashSet使用
        // 重写equals必须重写hashCode以保证相同的对象必须有相同的HashCode
//        DemoUser demoUser = new DemoUser();
//        DemoUser demoUser1 = new DemoUser();
//        System.out.println(demoUser1.equals(demoUser));
//        System.out.println(demoUser.hashCode());
//        System.out.println(demoUser1.hashCode());
//
//        System.out.println(Long.hashCode(1L));
//        System.out.println(Long.hashCode(1L));
//        System.out.println(Integer.hashCode(1));
//        System.out.println(Integer.hashCode(1));
//        System.out.println(new String("s").hashCode());
//        System.out.println(new String("s").hashCode());

        HashMap<Object, Object> map = new HashMap<>();
        map.put("1", new DemoUser());

        // 从map中读取的时候需要调用hashCode,put的时候不需要
        System.out.println(map.get("1"));
    }
}

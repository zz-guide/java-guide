package org.zz.collection;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.zz.common.entity.DemoUser;

public class MapTests {
    @Test
    void runHashMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map);
        System.out.println(map);

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


    @Test
    void runHashMapRemove() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        System.out.println(map);
        System.out.println(map);

        // 删除一
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (Objects.equals(entry.getKey(), "2")) {
                iterator.remove();
            }
        }

        // 删除二
        //map.entrySet().removeIf(entry -> Objects.equals(entry.getKey(), "2"));

        // 删除三
        for (String key : map.keySet()) {
            // java.util.ConcurrentModificationException
            map.remove(key);
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }

    public static void crud() {
        HashMap<String, String> mp = new HashMap<>();
        mp.put("name", "许磊");
        mp.put("age", "27");
        System.out.println(mp);

        System.out.println(mp.get("name"));

        String value = mp.remove("name");
        System.out.println(value);
        System.out.println(mp);
    }

    public static void iterator() {
        HashMap<String, String> mp = new HashMap<>();
        mp.put("name", "许磊");
        mp.put("age", "27");

        // 通过key进行遍历
        Set<String> keySet = mp.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {                         //利用了Iterator迭代器**
            String key = it.next();
            String value = mp.get(key);
            System.out.println(key + "=" + value);
        }

        // 推荐写法
        for (String key : keySet) { // for : 迭代
            String value = mp.get(key);
            System.out.println(key + "=" + value);
        }

        // 通过entry进行遍历
        Set<Map.Entry<String, String>> entrySet = mp.entrySet();
        //遍历Set集合
        Iterator<Map.Entry<String, String>> it1 = entrySet.iterator();
        while (it1.hasNext()) {
            //得到每一对对应关系
            Map.Entry<String, String> entry = it1.next();
            //通过每一对对应关系获取对应的key
            String key = entry.getKey();
            //通过每一对对应关系获取对应的value
            String value = entry.getValue();
            System.out.println(key + "=" + value);

            // 删除元素需要使用迭代器的remove方法，而非mp的remove方法
//            if(Objects.equals(entry.getKey(), "name")) {
//                it1.remove();//使用迭代器的remove()方法删除元素
//                 mp.remove(entry.getKey()); // 迭代器不允许使用mp自身的remove方法，ConcurrentModificationException
//            }
        }

        // 推荐写法, 此写法不支持遍历过程中修改
        for (Map.Entry<String, String> entry : entrySet) {
            //通过每一对对应关系获取对应的key
            String key = entry.getKey();
            //通过每一对对应关系获取对应的value
            String value = entry.getValue();
            System.out.println(key + "=" + value);

            mp.remove(key);
        }

        // 通过value移除
        mp.values().removeIf(value -> !value.contains("1"));
        // 通过key移除
        mp.keySet().removeIf(key -> !Objects.equals(key, "name"));
        // 通过键/值的输入/组合删除
        mp.entrySet().removeIf(entry -> !Objects.equals(entry.getKey(), "asd"));

        System.out.println(mp);
    }
}

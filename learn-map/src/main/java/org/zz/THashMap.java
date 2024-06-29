package org.zz;

import java.util.*;

public class THashMap {
    public static void main(String[] args) {
        iterator();
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

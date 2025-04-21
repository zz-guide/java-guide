package org.zz.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringTests {
    @Test
    void crud(){

    }


    public static void createString() {
        // 创建字符串的两种方式
        // 1.String 变量名=值，直接分配在虚拟机的常量池
        String str1 = "许磊";
        // 2. String 变量名 = new String(值)分=分配在堆
        String str2 = new String("许磊");
        String str3 = "许磊";
        // 3.使用char[]
        char[] data = {'许', '磊'};
        String str4 = new String(data);
        // 4.字符串的intern方法
        String str5 = str3.intern();
        // identityHashCode 直接打印出内存地址，即使hashCode方法被重写过也不影响
        System.out.println("---------内存地址--------");
        System.out.println(System.identityHashCode(str1)); // 41359092
        System.out.println(System.identityHashCode(str3)); // 41359092
        System.out.println(System.identityHashCode(str2)); // 149928006
        System.out.println(System.identityHashCode(str4)); // 713338599
        System.out.println(System.identityHashCode(str5)); // 41359092
        System.out.println("---------hashCode()--------");
        System.out.println(str1.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str5.hashCode());
        System.out.println("---------equals()--------");
        System.out.println(str1.equals(str3));
        System.out.println(str2.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str1.equals(str5));
    }

    public static void testEmpty() {
        class Student {
            // 三个都认为是false
            String name = "";
            String name1 = null;
            String name2;
            String name3 = "0";
            String name4 = "1";
            String name5 = "true";    // 只有忽略大小写的true字符串才认为是true
            String name6 = "false";

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", name1='" + name1 + '\'' +
                        ", name2='" + name2 + '\'' +
                        ", name3='" + name3 + '\'' +
                        ", name4='" + name4 + '\'' +
                        ", name5='" + name5 + '\'' +
                        ", name6='" + name6 + '\'' +
                        '}';
            }
        }
        System.out.println("------字符串转布尔类型---------");
        Student student = new Student();
        System.out.println(student);
        // Boolean.parseBoolean 返回基本类型
        // Boolean.valueOf 返回包装类型
        System.out.println("name:" + student.name + "," + Boolean.parseBoolean(student.name) + "," + Boolean.valueOf(student.name));
        System.out.println("name1:" + student.name1 + "," + Boolean.parseBoolean(student.name1) + "," + Boolean.valueOf(student.name1));
        System.out.println("name2:" + student.name2 + "," + Boolean.parseBoolean(student.name2) + "," + Boolean.valueOf(student.name2));
        System.out.println("name3:" + student.name3 + "," + Boolean.parseBoolean(student.name3) + "," + Boolean.valueOf(student.name3));
        System.out.println("name4:" + student.name4 + "," + Boolean.parseBoolean(student.name4) + "," + Boolean.valueOf(student.name4));
        System.out.println("name5:" + student.name5 + "," + Boolean.parseBoolean(student.name5) + "," + Boolean.valueOf(student.name5));
        System.out.println("name6:" + student.name6 + "," + Boolean.parseBoolean(student.name6) + "," + Boolean.valueOf(student.name6));
        System.out.println("------判断字符串为空---------");
        // isBlank 还会判断是不是只有空格
        System.out.println("空字符串isBlank:" + "".isBlank());
        System.out.println("空格isBlank:" + " ".isBlank());
        // isEmpty判断的是长度
        System.out.println("空字符串isEmpty:" + "".isEmpty());
        System.out.println("空格isEmpty:" + " ".isEmpty());
    }

    public static void testHashCodeAndEquals() {
        // hashCode()
        // equals()
    }

    public static void testIntern() {
        // native方法 intern作用：如果字符串常量池中已经包含了一个等于此String对象的字符串，
        // 则返回代表池中的这个字符串额String对象的引用；否则，会将此String对象的包含的字符串添加到常量池当中，
        // 并且返回此String对象的引用。
    }

    public static void t1() {
//        String str; // Variable 'str' might not have been initialized
        String str1 = null;
        String str2 = "";
        String str3 = "";
//        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        System.out.println(str2 == str3);
        System.out.println(str1 == str3);

        class S {
            public String name; // 默认就是null
            public String name1 = null;
            public String name2 = "";
        }
        S s = new S();
        System.out.println(s.name);
        System.out.println(s.name1);
        System.out.println(s.name2);
    }

    public static void test() {
        /*
         * 结论：
         * 1、若只是几个有限的简单的字符串拼接，可直接使用+；
         * 2、在for循环中推荐使用StringBuilder/StringBuffer；
         * 3、若为list或数组，首先考虑StringJoiner相关方法。
         */

        // 字符串拼接的几种方式
        // + 运算符直接拼接
        System.out.println("姓名:" + "许磊");
        // StringBuilder 非线程安全
        StringBuilder builder = new StringBuilder();
        builder.append("姓名:");
        builder.append("许磊");
        System.out.println(builder);

        // StringBuffer 线程安全
        StringBuffer buffer = new StringBuffer();
        buffer.append("姓名:");
        buffer.append("许磊");
        System.out.println(buffer);

        // StringJoiner 底层使用StringBuilder
        String[] strS = {"姓名", "许磊"};
        StringJoiner sj = new StringJoiner(":");
        for (String str : strS) {
            sj.add(str);
        }
        System.out.println(sj);

        // 底层使用StringJoiner
        String[] strS1 = {"姓名", "许磊"};
        String str = String.join(":", strS1);
        System.out.println(str);

        // 使用Collectors.joining 【不推荐使用】
        String str1 = Arrays.stream(strS).collect(Collectors.joining(","));
        System.out.println(str1);
    }
}

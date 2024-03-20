package basic.string;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringContactMain {
    public static void main(String[] args) {
        test();
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

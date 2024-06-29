package org.zz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        t1();
        t2();
    }

    public static void t1() {
        String content = "你好123世界";
        boolean isMatch = Pattern.matches(".*123.*", content);
        System.out.println("是否匹配:" + isMatch);

    }

    public static void t2() {
        String content = "你12界";
        Pattern pattern = Pattern.compile("(.*)(\\d+)(.*)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }

    }
}

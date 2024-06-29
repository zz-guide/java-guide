package org.zz;

import org.junit.jupiter.api.Test;


class StringTests {

    @Test
    void testEmptyString() {
        // isBlank会去掉空格, \t, 0x00007000, 0x00004000 以后判断
        String str1 = ""; // 空字符串
        System.out.println("str1 is empty:"+ str1.isEmpty());
        System.out.println("str1 is empty:"+ str1.isBlank());

        String str2 = " "; // 空格
        System.out.println("str2 is empty:"+ str2.isEmpty());
        System.out.println("str2 is empty:"+ str2.isBlank());

        String str3 = " "; // \t
        System.out.println("str3 is empty:"+ str3.isEmpty());
        System.out.println("str4 is empty:"+ str3.isBlank());
    }
}

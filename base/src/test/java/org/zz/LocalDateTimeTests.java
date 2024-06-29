package org.zz;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

class LocalDateTimeTests {

    @Test
    void testFormatCurrentDatetime() {
        String nowStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("now str: " + nowStr);
    }

    @Test
    void testStrToLocalDatetime() {
        // 参考: https://blog.csdn.net/JiuQianWan/article/details/126118218
//        String datetime = "2024-02-02 22:22:22";
//        String datetime = "0000-00-00 00:00:00"; // 无法解析
        String datetime = "1970-01-01 00:00:00";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH).withResolverStyle(ResolverStyle.SMART);

        LocalDateTime localDateTime = LocalDateTime.parse(datetime, dateTimeFormatter);
        String str = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("日期时间: " + str);
    }

    @Test
    void testCurrentTimestamp() {
        System.out.println("当前时间戳(毫秒):"+System.currentTimeMillis());
        System.out.println("当前时间戳(毫秒):"+ Instant.now().toEpochMilli());
    }

    @Test
    void testStrToTimestamp() {
        String dateTimeString = "2024-06-20 12:34:56";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
        Instant timestamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long timestampInMillis = timestamp.toEpochMilli();
        System.out.println("时间戳（毫秒）: " + timestampInMillis);
    }
}

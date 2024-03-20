package org.zz.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class DateTimeTests {

    @Test
    void formatCurrentDatetime() {
        String nowStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("now str: " + nowStr);
    }

}

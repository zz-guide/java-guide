package basic.date.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Calendar
 * 为了实现在时间基础上计算多一个月，少一个月这种需求，出现
 */

public class Main {
    public static void main(String[] args) {
        t1();
//        tCompare();
    }

    public static void t1() {
        // 1.抽象类，不能直接new
        // 2.底层根据不同时区来获取日历对象，默认表示当前时间
        // 3.时间中的纪元，年，月，日，时，分，秒，星期都存到一个数组中
        // 4.月份: 0-11，,0代表1月
        // 5.星期: 1-7,1是星期日，7是星期六，老外习惯
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(0L);
        calendar.setTime(date);
        System.out.println(calendar);

        int year = calendar.get(Calendar.YEAR); // 其实就是个索引，或者是枚举值
        int month = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DATE);
        System.out.println("year=" + year + ",month=" + month + 1 + ",date=" + d);
    }

    public static void tCompare() {
        // 比较时间大小
        class Compare {
            private static void compareTime(String time1, String time2) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                Calendar calendar1 = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                try {
                    calendar1.setTime(dateFormat.parse(time1));
                    calendar2.setTime(dateFormat.parse(time2));
                } catch (java.text.ParseException e) {
                    System.out.println("----> Exception=" + e.toString());
                }
                int result = calendar1.compareTo(calendar2);
                if (result == 0) {
                    System.out.println("----> time1等于time2");
                } else if (result < 0) {
                    System.out.println("----> time1小于time2");
                } else {
                    System.out.println("----> time1大于time2");
                }
            }
        }

        String str1 = "2022-12-12 12:12:12";
        String str2 = "2022-12-11 12:12:12";
        Compare.compareTime(str1, str2);
    }
}

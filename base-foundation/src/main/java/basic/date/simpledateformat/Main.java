package basic.date.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * SimpleDateFormat
 * 1.非线程安全，可配合ThreadLocal解决
 * 2.格式和字符串不匹配，不报错，返回的是其他日期
 * 3.推荐使用java8的DateTimeFormatter解决
 */
public class Main {
    public static void main(String[] args) {
//        tFormat();
//        tParse();
        tTimeStamp();
    }

    public static void tFormat() {
        // 时间格式化
        System.out.println(Locale.getDefault());//zh_CN_#Hans
        // SimpleDateFormat无参构造，默认模式
        SimpleDateFormat sdf = new SimpleDateFormat(); // 1970/1/1 上午8:00
        Date date = new Date(0L); // 注意，此处应该使用long数据类型

        String str = sdf.format(date);
        System.out.println(str);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date1 = new Date();

        String str1 = sdf1.format(date1); // 2022-12-22 18:26:13
        System.out.println(str1);
    }

    public static void tParse() {
        // 时间字符串->Date对象
        String str = "2022-12-22 12:12:12";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(str);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tTimeStamp() {
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date(timeStamp);
        String time = simpleDateFormat.format(date);

        System.out.println("----> 将时间戳转换为字符串: " + time);
        System.out.println("----------------------------------");

        long javaTimeStamp = System.currentTimeMillis(); // 毫秒时间戳
        long unixTimeStamp = javaTimeStamp / 1000; // 秒时间戳
        System.out.println("----> java时间戳: " + javaTimeStamp + ", unix时间戳：" + unixTimeStamp);
        System.out.println("----------------------------------");
    }
}

package org.zz.date.dateTimeFormatter;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Set;

/**
 * jdk8 以后新增 DateTimeFormatter
 * 1.代码层面相比以前简单，比较时间不需要转成时间戳才能比较
 * 2.线程安全，日期对象不可变
 * 3.建议新的项目直接使用DateTimeFormatter即可
 * 4.Date类，ZoneId,Instant,ZoneDateTime
 * 5.SimpleDateFormat: DateTimeFormatter
 * 6.Calendar:LocalDate,LocalTime,LocalDateTime
 * 7.工具类：Duration,Period,ChronoUnit
 */
public class Main {
    public static void main(String[] args) {
//        tZoneId();
//        tInstant();
//        tZoneDateTime();
//        tDateTimeFormatter();
//        tLocalDate();
//        tLocalTime();
//        tLocalDateTime();
//        tDuration();
//        tPeriod();
        tChronoUnit();
    }

    public static void tZoneId() {
        // getAvailableZoneIds 获取所有支持的时区集合
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds);

        // systemDefault 获取系统默认时区
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        // 根据指定时区获取ZoneId对象
        ZoneId zoneId2 = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId2);
    }

    public static void tInstant() {
        // now() 获取当前时间，标准时间，与时区无关
        Instant now = Instant.now();
        System.out.println(now.toString());

        // 根据秒，毫秒，纳秒获取Instant对象
        Instant instant = Instant.ofEpochMilli(0L);
        System.out.println(instant);

        Instant instant1 = Instant.ofEpochSecond(1L);
        System.out.println(instant1);

        Instant instant3 = Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant3);

        // atZone 返回一个带时区的时间对象
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime.toString());

        // isBefore,isAfter 比较
        boolean before = instant1.isBefore(instant3);
        System.out.println(before);

        // minus减少时间
        Instant instant5 = Instant.ofEpochSecond(2L);
        Instant instant6 = instant5.minusSeconds(2L);
        System.out.println(instant5);
        System.out.println(instant6);

        // plus 增加时间
        Instant instant7 = Instant.ofEpochSecond(2L);
        Instant instant8 = instant7.plusSeconds(2L);
        System.out.println(instant7);
        System.out.println(instant8);
    }

    public static void tZoneDateTime() {
        // 获取当前时间
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        // 获取指定时间的时间对象
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2023, 10, 1, 11, 12, 12, 0, ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
        // 通过Instant+时区指定获取对象
        Instant instant = Instant.ofEpochSecond(0L);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zonedDateTime1);
        // withXXX 修改时间
        ZonedDateTime zonedDateTime2 = zonedDateTime1.withYear(2000);
        System.out.println(zonedDateTime2);
        // plusXXX增加时间
        ZonedDateTime zonedDateTime3 = zonedDateTime1.plusSeconds(10L);
        System.out.println(zonedDateTime3);
        // minusXXX减少时间
        ZonedDateTime zonedDateTime4 = zonedDateTime3.minusSeconds(10L);
        System.out.println(zonedDateTime4);
    }

    public static void tDateTimeFormatter() {
        // 时间格式化成字符串，根据pattern
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EE a");
        String str = dateTimeFormatter.format(zonedDateTime);
        System.out.println(str);
        // 时间戳解析成字符串
//        Long ll = System.currentTimeMillis();
//        dateTimeFormatter.parse(ll.toString(), dateTimeFormatter);
    }

    public static void tLocalDate() {
        // 年月日对象
        // 获取今天的日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 根据指定日期获取对象
        LocalDate of = LocalDate.of(2022, 12, 22);
        System.out.println(of);

        // 获取年
        int year = of.getYear();
        System.out.println("年：" + year);
        // 获取月
        Month month = of.getMonth();
        int month1 = of.getMonthValue();
        System.out.println("月：" + month.getValue());
        System.out.println("月：" + month1);
        // 获取日
        int day = of.getDayOfMonth();
        System.out.println("天：" + day);

        // 获取一年当中的第几天
        int dayOfYear = of.getDayOfYear();
        System.out.println(dayOfYear);

        // 获取一周中的第几天
        DayOfWeek dayOfWeek = of.getDayOfWeek();
        System.out.println(dayOfWeek);

        // isXXX判断
        // withXXX修改
        // plusXXX 增加
        // minusXXX 减少

        // MonthDay 封装月日
        MonthDay of1 = MonthDay.of(of.getMonth(), of.getDayOfMonth());
        MonthDay from = MonthDay.from(now);
        System.out.println(of.equals(from));
    }

    public static void tLocalTime() {
        // 时分秒对象
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }

    public static void tLocalDateTime() {
        // 时分秒对象
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());
    }

    public static void tDuration() {
        // 侧重秒，纳秒计算
        // 所有日期时间对象都可以
        LocalDateTime now = LocalDateTime.of(2022, 12, 22, 21, 42);
        LocalDateTime of = LocalDateTime.of(2022, 12, 22, 21, 43);
        Duration duration = Duration.between(now, of);
        System.out.println(duration);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toSeconds());
        System.out.println(duration.toNanos());
    }

    public static void tPeriod() {
        // 计算日期间隔（年，月，日）
        // 必须是日期对象
        LocalDate now = LocalDate.of(2022, 11, 22);
        LocalDate of = LocalDate.of(2022, 12, 23);
        // between 是有先后顺序的，顺序不对可能出现负的结果，第二个减去第一个
        Period period = Period.between(now, of);
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
        System.out.println(period.toTotalMonths());
    }

    public static void tChronoUnit() {
        // 所有都能计算
        LocalDateTime now = LocalDateTime.of(2022, 12, 22, 21, 42);
        LocalDateTime of = LocalDateTime.of(2023, 12, 22, 21, 43);
        System.out.println("相差的年数:" + ChronoUnit.YEARS.between(now, of));
        System.out.println("相差的月数:" + ChronoUnit.MONTHS.between(now, of));
        System.out.println("相差的周数:" + ChronoUnit.WEEKS.between(now, of));
        System.out.println("相差的日数:" + ChronoUnit.DAYS.between(now, of));
        System.out.println("相差的小时数:" + ChronoUnit.HOURS.between(now, of));
        System.out.println("相差的分钟数:" + ChronoUnit.MINUTES.between(now, of));
        System.out.println("相差的微秒数:" + ChronoUnit.MICROS.between(now, of));
        System.out.println("相差的纳秒数:" + ChronoUnit.NANOS.between(now, of));
        System.out.println("相差的半天数:" + ChronoUnit.HALF_DAYS.between(now, of));
        System.out.println("相差的十年数:" + ChronoUnit.DECADES.between(now, of));
        System.out.println("相差的世纪（百年）数:" + ChronoUnit.CENTURIES.between(now, of));
        System.out.println("相差的千年数:" + ChronoUnit.MILLENNIA.between(now, of));
        System.out.println("相差的纪元数:" + ChronoUnit.ERAS.between(now, of));
    }
}

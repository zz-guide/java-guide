package org.zz.date.date;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        Date date = new Date();
        System.out.println(date.getTime());

        Date d = new Date(0L);
        System.out.println(d.getTime());
    }
}

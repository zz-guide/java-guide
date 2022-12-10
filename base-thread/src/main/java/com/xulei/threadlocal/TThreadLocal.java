package com.xulei.threadlocal;

public class TThreadLocal {
    public static int num = 0;
    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1(){
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                num++;
                System.out.println(Thread.currentThread().getName()+":num="+num);
            }).start();
        }
    }

    public static void test2(){
        ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> {
            System.out.println("当前的线程id：" + Thread.currentThread().getId());
            return 0;
        });

        System.out.println("在主线程中获取threadLocal的值：" + threadLocal.get());

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                int num = threadLocal.get();
                num++;
                threadLocal.set(num);
                System.out.println(Thread.currentThread().getName()+":num="+num);
            }).start();
        }
    }
}

package com.xulei.thread;

// 匿名函数形式的线程（Thread）
public class Boot {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "线程1").start();

    }
}

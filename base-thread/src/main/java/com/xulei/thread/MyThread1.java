package com.xulei.thread;

// 1.实现Runnable接口，重写run方法，创建一个Thread对象，传入自定义线程对象，调用start开启线程
// 优点：避免单继承局限，同一个对象可以被多个线程复用
public class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {
        System.out.println("------main------");

        // 线程交替执行，执行顺序不确定
        MyThread1 myThread = new MyThread1();
        Thread thread = new Thread(myThread, "MyThread1");
        thread.start();

        System.out.println("-----end-----");
    }
}
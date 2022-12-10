package com.xulei.thread;

import java.util.concurrent.*;

// 1.实现Callable接口，重写call方法
public class MyThread3 implements Callable<Boolean> {

    @Override
    public Boolean call() {
        System.out.println("sssss");
        return true;
    }

    public static void main(String[] args) {
        System.out.println("------main start------");

        MyThread3 myThread = new MyThread3();
        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(1);
        // 提交执行
        Future<Boolean> f1 = ser.submit(myThread);
        // 获取结果
        try {
            Boolean res1 = f1.get();
            System.out.println("res1:"+res1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 关闭服务
        ser.shutdownNow();
        System.out.println("-----main end-----");
    }
}
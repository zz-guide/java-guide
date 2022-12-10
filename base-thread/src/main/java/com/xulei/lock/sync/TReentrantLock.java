package com.xulei.lock.sync;

import java.util.concurrent.locks.ReentrantLock;

class Stu {
    public int count = 0;
    ReentrantLock lock = new ReentrantLock();

    public void addCount() {
        lock.lock();
        this.count++;
        lock.unlock();
    }
}

// 利用ReentrantLock进行同步
class TReentrantLock {
    final static int count = 100000;

    public static void main(String[] args) {
        Stu stu = new Stu();
        System.out.println("ReentrantLock(可重入锁)->初始count值=:" + stu.count);

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "读取前:" + stu.count);
                stu.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu.count);

            }

        }, "线程1").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "读取前:" + stu.count);
                stu.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu.count);

            }
        }, "线程2").start();

        try {
            // 运行2秒后得出结论
            Thread.sleep(2000);
            System.out.println("-------------------");
            System.out.println("count最终结果:" + stu.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

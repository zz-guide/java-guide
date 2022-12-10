package com.xulei.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

// 1】什么是可重入，什么是可重入锁? 它用来解决什么问题?
//【2】ReentrantLock 的核心是 AQS，那么它怎么来实现的，继承吗? 说说其类内部结构关系。
// class AbstractQueuedSynchronizer
//说明：ReentrantLock 类内部总共存在Sync、NonfairSync、FairSync三个类，NonfairSync与 FairSync类继承自 Sync类，Sync类继承自 AbstractQueuedSynchronizer抽象类。下面逐个进行分析。
//【3】ReentrantLock 是如何实现公平锁的?
//【4】ReentrantLock 是如何实现非公平锁的?
//【5】ReentrantLock 默认实现的是公平还是非公平锁?
//【6】使用ReentrantLock 实现公平和非公平锁的示例?
//【7】ReentrantLock 和 Synchronized的对比?
// 参考网址：https://blog.csdn.net/zhengzhaoyang122/article/details/110847701
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

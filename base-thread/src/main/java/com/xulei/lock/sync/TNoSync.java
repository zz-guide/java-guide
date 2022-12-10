package com.xulei.lock.sync;

// 不加锁的话结果不对
class Stu3 {
    public int count = 0;

    public void addCount() {
        this.count++;
    }
}

// 利用ReentrantLock进行同步
class TNoSync {
    final static int count = 100000;

    public static void main(String[] args) {
        Stu3 stu3 = new Stu3();
        System.out.println("未加锁->初始count值=:" + stu3.count);

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "读取前:" + stu3.count);
                stu3.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu3.count);

            }

        }, "线程1").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "读取前:" + stu3.count);
                stu3.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu3.count);

            }
        }, "线程2").start();

        try {
            // 运行2秒后得出结论
            Thread.sleep(2000);
            System.out.println("-------------------");
            System.out.println("count最终结果:" + stu3.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

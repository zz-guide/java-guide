package com.xulei.lock.sync;

// 利用synchronized 修饰this对象

class Stu2 {
    public int count = 0;

    public void addCount() {
        synchronized (this) {
            count++;
        }

    }
}

class TSynchronizedInstance {
    final static int count = 100000;

    public static void main(String[] args) {

        Stu2 stu2 = new Stu2();
        System.out.println("Synchronized(修饰this对象)->初始count值=:" + stu2.count);

        // 创建2个线程访问同一个类常量，观察数据
        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                System.out.println(Thread.currentThread().getName() + "读取前:" + stu2.count);
                stu2.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu2.count);
            }

        }, "线程1").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                System.out.println(Thread.currentThread().getName() + "读取前:" + stu2.count);
                stu2.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu2.count);
            }
        }, "线程2").start();

        try {
            // 运行2秒后得出结论
            Thread.sleep(2000);
            System.out.println("-------------------");
            System.out.println("count最终结果:" + stu2.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

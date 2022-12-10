package com.xulei.lock.sync;

// synchronized 修饰方法
class Stu1 {
    public int count = 0;

    public synchronized void addCount(){
        count++;
    }
}
class TSynchronizedFunc {
    final static int count = 100000;

    public static void main(String[] args) {
        Stu1 stu1 = new Stu1();
        System.out.println("Synchronized(修饰函数)->初始count值=:"+stu1.count);
        // 创建2个线程访问同一个类常量，观察数据
        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                System.out.println(Thread.currentThread().getName() + "读取前:" + stu1.count);
                stu1.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu1.count);
            }

        }, "线程1").start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                System.out.println(Thread.currentThread().getName() + "读取前:" + stu1.count);
                stu1.addCount();
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu1.count);
            }
        }, "线程2").start();

        try {
            // 运行2秒后得出结论
            Thread.sleep(2000);
            System.out.println("-------------------");
            System.out.println("count最终结果:"+ stu1.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

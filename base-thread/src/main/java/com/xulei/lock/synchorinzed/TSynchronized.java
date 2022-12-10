package com.xulei.lock.synchorinzed;

// 括方法锁(默认锁对象为this,当前实例对象)和同步代码块锁(自己指定锁对象)
//代码块形式：手动指定锁定对象，也可以是this，也可以是自定义的锁
//方法锁形式：synchronized修饰普通方法，锁对象默认为this
// 指synchronize修饰静态的方法或指定锁对象为Class对象
//synchronize修饰静态方法,synchronized用在静态方法上，默认的锁就是当前所在的Class类，所以无论是哪个线程访问它，需要的锁都只有一把
// 可重入原理：加锁次数计数器
//
//锁的重入性，即在同一锁程中，线程不需要再次获取同一把锁。
//
//Synchronized先天具有重入性。每个对象拥有一个计数器，当线程获取该对象锁后，计数器就会加一，释放锁后就会将计数器减一。
// 保证可见性的原理：内存模型和happens-before规则
//Synchronized的happens-before规则，即监视器锁规则：对同一个监视器的解锁，happens-before于对该监视器的加锁。

// 参考网址：https://zhuanlan.zhihu.com/p/453571682
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

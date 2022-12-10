package com.xulei.lock.sync;

// 满足以下两点，那么volatile修饰的共享变量，不用加锁也能保证线程安全：
// 1.运算结果不依赖变量的当前值（即变量计算的结果和当前的值没有关系，
// 比如一个boolean变量的改变，但是i++这种运算就存在依赖关系，以为新值是在旧值的基础上加1），或者能够确保只有单一的线程修改变量的值
// 2.变量不需要与其他的状态变量共同参与不变性约束（即该变量不和其他变量关联）
class Stu4 {
    public volatile int count = 0;
}

public class TVolatile {
    final static int count = 100000;

    public static void main(String[] args) {
        Stu4 stu4 = new Stu4();
        System.out.println("Synchronized(修饰this对象)->初始count值=:" + stu4.count);

        // 创建2个线程访问同一个类常量，观察数据
        new Thread(() -> {
            for (int i = 0; i < count; i++) {

                System.out.println(Thread.currentThread().getName() + "读取前:" + stu4.count);
                stu4.count = i;
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu4.count);
            }

        }, "线程1").start();

        new Thread(() -> {
            for (int i = count; i < 2 * count; i++) {

                System.out.println(Thread.currentThread().getName() + "读取前:" + stu4.count);
                stu4.count = i;
                System.out.println(Thread.currentThread().getName() + "修改后:" + stu4.count);
            }
        }, "线程2").start();

        try {
            // 运行2秒后得出结论
            Thread.sleep(2000);
            System.out.println("-------------------");
            System.out.println("count最终结果:" + stu4.count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

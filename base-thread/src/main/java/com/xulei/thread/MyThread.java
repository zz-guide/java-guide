package com.xulei.thread;

// 1.继承Thread类，重写run方法，调用start开启线程
// 缺点：单继承局限，不建议使用
// 线程状态：new,runnable,TERMINATED,BLOCKED,WAIT,TIMED_WAITING
// 停止线程不建议使用stop方法
public class MyThread extends Thread{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("sssssssss");
            try {
                System.out.println("run 状态:" + getState());
                Thread.sleep(1000);
                System.out.println("run 状态:" + getState());
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("------main------");

        // 线程交替执行，执行顺序不确定
        MyThread myThread = new MyThread();
        System.out.println("new 状态:"+myThread.getState());
        myThread.start();

        try {
            Thread.sleep(5000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        try {
//            // 等待线程执行结束
//            myThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("end 状态:"+myThread.getState());

        System.out.println("-----end-----");
    }
}

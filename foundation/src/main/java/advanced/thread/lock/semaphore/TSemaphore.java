package advanced.thread.lock.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

// 信号量（英语：Semaphore）又称为信号量、旗语，是一个同步对象，用于保持在0至指定最大值之间的一个计数值。
//在系统中，给予每一个进程一个信号量，代表每个进程目前的状态，未得到控制权的进程会在特定地方被强迫停下来，等待可以继续进行的信号到来。
// 1.二进制类型的信号量：信号量只有二进制的0或1，称为二进制信号量（binary semaphore）。比如控制某一时刻只能有一个线程获取到指定的资源。
//在linux系统中，二进制信号量（binary semaphore）又称互斥锁，也叫互斥量。互斥量的加锁和解锁必须由同一个线程分别对应使用。
//2.计数类型的信号量：信号量是一个任意的整数，通常被称为计数信号量（Counting semaphore），或一般信号量（general semaphore）。比如控制某一时刻只能指定线程数目运行。

public class TSemaphore {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        // 设置最大同时访问线程数目
        Semaphore semp = new Semaphore(3);
        // 多个线程同时访问
        for (int index = 0; index < 30; index++) {
            final int threadId = index;
            Runnable run = () -> {
                try {
                    // 申请信号量，信号量的值-1
                    semp.acquire();
                    System.out.println("Thread_id: " + threadId + " enter.");
                    Thread.sleep((threadId % 3) * 10000);
                    // 释放信号量，信号量的值+1
                    semp.release();
                    System.out.println("Thread_id: " + threadId + " drop out. Remaining application space: " + semp.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.submit(run);
        }
        exec.shutdown();
    }
}

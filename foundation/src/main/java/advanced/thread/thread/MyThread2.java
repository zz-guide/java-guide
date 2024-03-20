package advanced.thread.thread;

// 1.并发问题,多个线程操作同一个资源的情况下，数据混乱，线程不安全
public class MyThread2 implements Runnable {
    private int ticket = 10;

    @Override
    public void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "--->拿到了第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        System.out.println("------main start------");

        // 线程交替执行，执行顺序不确定
        MyThread2 myThread = new MyThread2();
        Thread thread1 = new Thread(myThread, "MyThread1");
        Thread thread2 = new Thread(myThread, "MyThread2");
        thread1.start();
        thread2.start();

        System.out.println("-----main end-----");
    }
}
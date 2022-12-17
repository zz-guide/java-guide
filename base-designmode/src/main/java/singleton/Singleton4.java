package singleton;

/**
 * 懒汉式线程安全的[线程安全，效率低不推荐使用]
 * <p>
 * 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 * 而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */
public class Singleton4 {
    private static Singleton4 instance = null;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {

        if (instance == null) {
            instance = new Singleton4();
        }

        return instance;
    }
}

/**
 * 懒汉式线程安全的[线程安全，效率低不推荐使用]
 */
class Singleton5 {
    private static Singleton5 instance = null;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            // 多线程的话，此处有可能同时进入
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}

package singleton;

/**
 * 单例模式的懒汉式
 * 缺点: 线程不安全，不可用
 */
public class Singleton3 {
    private static Singleton3 instance = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {

        if (instance == null) {
            instance = new Singleton3();
        }

        return instance;
    }
}

package singleton;

/**
 * 单例模式懒汉式双重校验锁[推荐用]
 * 优点：线程安全；延迟加载；效率较高。
 */
public class Singleton6 {
    private static Singleton6 instance = null;

    private Singleton6() {
    }

    public static Singleton6 getInstance() {

        // 双重检查
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }

        return instance;
    }
}

package singleton;

/**
 * 饿汉式单例
 * <p>
 * 优点：从它的实现中我们可以看到，这种方式的实现比较简单，在类加载的时候就完成了实例化，避免了线程的同步问题。
 * <p>
 * 缺点：由于在类加载的时候就实例化了，所以没有达到Lazy Loading(懒加载)的效果，也就是说可能我没有用到这个实例，但是它
 * <p>
 * 也会加载，会造成内存的浪费(但是这个浪费可以忽略，所以这种方式也是推荐使用的)。
 */
public class Singleton1 {
    // 初始化的时候直接new好，直接return
    private static final Singleton1 instance = new Singleton1();

    // 私有化构造器，外部无法通过new进行构造
    private Singleton1() {
    }

    // 提供一个外部可以访问的入口
    public static Singleton1 getInstance() {
        return instance;
    }
}

// 另一种写法
class Singleton2 {
    private static Singleton2 instance = null;

    static {
        instance = new Singleton2();
    }

    // 私有化构造器，外部无法通过new进行构造
    private Singleton2() {
    }

    // 提供一个外部可以访问的入口
    public static Singleton2 getInstance() {
        return instance;
    }
}

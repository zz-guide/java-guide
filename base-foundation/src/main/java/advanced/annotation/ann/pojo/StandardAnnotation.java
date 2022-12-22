package advanced.annotation.ann.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准注解
 *
 * @Override
 * @FunctionalInterface
 * @Deprecated
 * @SuppressWarnings
 * @SafeVarargs
 */

public class StandardAnnotation extends Person {
    // 函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。
    @FunctionalInterface
    public interface DemoFunctionalInterface {

        void getUser(Long userId); // 默认就是public abstract

        // 默认方法，可以用多个默认方法
        public default void setUser() {
        }

        // 静态方法
        public static void saveUser() {
        }

        // 覆盖Object中的equals方法
        public boolean equals(Object obj);
    }

    @Deprecated
    public void deprecated() {
    }

    /**
     * 简单来说@override注解是告诉编译器，下面的方法是重写父类的方法
     * 如果不写@override注解去直接重写方法，编译器是不会判断你是不是正确重写了父类中的方法的。
     * 如重写方法时参数与父类不同，程序是不会提示报错的。这会留下一个潜在的bug。
     * 当你写了@override注解时，程序会判断你是否正确的重写了父类的对应方法。
     * 而且加上此注解后，程序会自动屏蔽父类的方法。
     * Method does not override method from its superclass
     */
    @Override
    public void who() {
        System.out.println("我是student");
    }

    //  抑制单类型："unchecked"
    //  抑制多类型：value = {"unchecked", "rawtypes"}
    // 抑制全部："all"
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public void addItems(String item) {
        @SuppressWarnings("rawtypes")
        List items = new ArrayList();
        items.add(item);
    }

    /**
     * @param array
     * @param <T>
     * @SafeVarargs注解不适用于非 static 或非 final 声明的方法，
     * 对于未声明为 static 或 final 的方法，如果要抑制 unchecked 警告，
     * 可以使用 @SuppressWarnings 注解。
     * <p>
     * 如果开发人员确信某个使用了可变长度参数的方法，在与泛型类一起使用时不会出现类型安全问题，就可以用这个注解进行声明
     * 可变长度的方法参数的实际值是通过数组来传递的，而数组中存储的是不可具体化的泛型类对象，自身存在类型安全问题。因此编译器会给出相应的警告信息。
     */
    @SafeVarargs
    public static <T> void display(T... array) {
        for (T arg : array) {
            System.out.println(arg.getClass().getName() + ":" + arg);
        }
    }
}
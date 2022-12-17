package basic.tclass.extend;

/**
 * 1.被final修饰的类不能继承
 * 2.Cannot assign a value to final variable 'AAA'
 * 被final修饰的变量不能修改
 * <p>
 * 3. final static 不能修改
 * 4.方法被final修饰无法被重写，但是可以被继承
 */
public class Animal {
    final int AAA = 123;
    final static int BBB = 123;

    public final int test() {
        int a = 456;
        a++;
        return a;
    }
}

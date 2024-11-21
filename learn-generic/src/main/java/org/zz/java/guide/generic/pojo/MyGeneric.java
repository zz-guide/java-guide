package org.zz.java.guide.generic.pojo;

/**
 * 泛型类中，类型参数定义的位置有三处
 * 1.非静态的成员属性类型
 * 2.非静态方法的形参类型（包括非静态成员方法和构造器）
 * 3.非静态的成员方法的返回值类型
 */

/**
 * 泛型标识是任意设置的（如果你想可以设置为 Hello都行），Java 常见的泛型标识以及其代表含义如下：
 *
 *   T ：代表一般的任何类。
 *   E ：代表 Element 元素的意思，或者 Exception 异常的意思。
 *   K ：代表 Key 的意思。
 *   V ：代表 Value 的意思，通常与 K 一起配合使用。
 *   S ：代表 Subtype 的意思，文章后面部分会讲解示意。
 * @param <T>
 */

public class MyGeneric<T> {
    // key 这个成员变量的数据类型为 T, T 的类型由外部传入
    private T key;

    // 泛型构造方法形参 key 的类型也为 T，T 的类型由外部传入
    public MyGeneric(T key) {
        this.key = key;
    }

    // 泛型方法 getKey 的返回值类型为 T，T 的类型由外部指定
    public T getKey(){
        return key;
    }
}
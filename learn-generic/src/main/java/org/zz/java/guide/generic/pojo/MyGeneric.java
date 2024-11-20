package org.zz.java.guide.generic.pojo;

/**
 * 泛型类中，类型参数定义的位置有三处
 * 1.非静态的成员属性类型
 * 2.非静态方法的形参类型（包括非静态成员方法和构造器）
 * 3.非静态的成员方法的返回值类型
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
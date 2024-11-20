package org.zz.java.guide.generic.pojo;

/**
 * 泛型类
 * 1. 泛型类不只接受一个类型参数，它还可以接受多个类型参数
 * @param <E>
 * @param <T>
 */
public class MyMultiTypeGeneric <E,T> {
    E value1;
    T value2;

    public MyMultiTypeGeneric(E value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public E getValue1(){
        return value1;
    }

    public T getValue2(){
        return value2;
    }
}

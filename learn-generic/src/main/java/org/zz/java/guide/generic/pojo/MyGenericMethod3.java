package org.zz.java.guide.generic.pojo;

/**
 * 泛型方法中的类型推断
 * 1. 在调用泛型方法的时候，可以显式地指定类型参数，也可以不指定。
 * 2. 当泛型方法的形参列表中有多个类型参数时，在不指定类型参数的情况下，方法中声明的的类型参数为泛型方法中的几种类型参数的共同父类的最小级，直到 Object。
 * 3. 在指定了类型参数的时候，传入泛型方法中的实参的数据类型必须为指定数据类型或者其子类。
 *
 * @param <U>
 */
public class MyGenericMethod3<U> {
    public <T, S> T testMethod(T t, S s) {
        return null;
    }
}
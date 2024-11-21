package org.zz.java.guide.generic.pojo;

/**
 * 泛型方法
 * @param <T>
 */
public class MyGenericMethod<T> {
    // 该方法只是使用了泛型类定义的类型参数，不是泛型方法
    public void testMethod(T t){
        System.out.println(t);
    }

    // <T> 真正声明了下面的方法是一个泛型方法
    public <E> E testMethod1(E e){
        return e;
    }
}
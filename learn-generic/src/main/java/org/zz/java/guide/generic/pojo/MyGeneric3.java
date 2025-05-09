package org.zz.java.guide.generic.pojo;

/**
 * 泛型类
 * 1. 静态泛型方法中可以使用自身的方法签名中新定义的类型参数（即泛型方法，后面会说到），而不能使用泛型类中定义的类型参数。
 */

public class MyGeneric3<T> {
    // 虽然与类上声明的参数类型都叫T,但本质上还是不一样
    public static <T> T show1(T one){
        return one;
    }

    // 泛型类定义的类型参数 T 不能在静态方法中使用
    public static <E> E show(E one){ // 这是正确的，因为 E 是在静态方法签名中新定义的类型参数
        return one;
    }
}
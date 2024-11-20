package org.zz.java.guide.generic.pojo;

/**
 * 泛型类
 * 1. 泛型类中的静态方法和静态变量不可以使用泛型类所声明的类型参数
 * 2. 编译报错
 * 3. 泛型类中的类型参数的确定是在创建泛型类对象的时候，就是new 的时候
 * 4. 静态变量和静态方法在类加载时已经初始化，直接使用类名调用；在泛型类的类型参数未确定时，静态成员有可能被调用，因此泛型类的类型参数是不能在静态成员中使用的。
 */

public class MyGeneric2<T> {
//    public static T one;   // 编译错误
//    public static T show(T one){ // 编译错误
//        return null;
//    }
}
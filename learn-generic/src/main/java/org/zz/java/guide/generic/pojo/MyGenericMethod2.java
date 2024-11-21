package org.zz.java.guide.generic.pojo;

/**
 * 泛型方法
 * 1. 虽然泛型类中定义的类型参数标识和泛型方法中定义的类型参数标识都为< T >，但它们彼此之间是相互独立的。也就是说，泛型方法始终以自己声明的类型参数为准。
 * 注意:
 *  1. < T >表明该方法声明了一个类型参数 T，并且这个类型参数 T 只能在该方法中使用。
 *  2. 为了避免混淆，如果在一个泛型类中存在泛型方法，那么两者的类型参数最好不要同名。
 *  3. 与泛型类的类型参数定义一样，此处泛型方法中的 T 可以写为`任意标识`，常见的如 T、E、K、V 等形式的参数常用于表示泛型。
 *
 * @param <U>
 */
public class MyGenericMethod2<U> {
    public <T, S> T testMethod(T t, S s) {
        return null;
    }
}
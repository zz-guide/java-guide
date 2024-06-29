package org.zz.dao;

import java.lang.reflect.InvocationTargetException;


/**
 * 泛型
 * 分类：泛型类，泛型方法，泛型接口；本质上就是类型参数话，动态类型
 * 边界：上下边界 T extends Number ? super Number
 */
public class Calculator implements ICalculator<Integer> { // 一对尖括号包裹，就是泛型类

    @Override
    public Number add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Number sub(Integer a, Integer b) {
        return null;
    }

    /**
     * 泛型方法的基本介绍
     *
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T instance = tClass.getDeclaredConstructor().newInstance();
        return instance;
    }

    // 此处’？’是类型实参，而不是类型形参。 可以把？看成所有类型的父类。是一种真实的类型
    // 当操作类型时，不需要使用类型的具体功能时，只使用Object类中的功能。那么可以用 ? 通配符来表未知类型。
    //public void wildcardFunc(Calculator<?> obj) {
    //System.out.println(obj.getName());
//    }
}

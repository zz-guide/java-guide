package foundation.tgeneric;

//泛型有三种使用方式，分别为：泛型类、泛型接口和泛型方法。本质上就是类型参数话，动态类型

// 泛型类,是在实例化类的时候指明泛型的具体类型；

import java.lang.reflect.InvocationTargetException;

// 上下边界 T extends Number ? super Number
public class GenericStudent<T> {
    private T name;

    public GenericStudent(T name) {
        this.name = name;
    }

    public T getName() {
        return name;
    }

    public <E> void show_1(E name) {
        System.out.println("泛型类中的泛型方法");
    }

    public <T1> void show_2(T t){
        System.out.println(t.toString());
    }

    // 泛型方法，是在调用方法的时候指明泛型的具体类型。
    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        T instance = tClass.getDeclaredConstructor().newInstance();
        return instance;
    }
}

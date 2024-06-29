package org.zz;

import basic.reflect.pojo.Cat;
import basic.reflect.pojo.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
//        t1();
//        t2();
        t4();
    }

    public static void t1() {
        String classFullPath = "basic.reflect.pojo.Cat";
        String methodName = "say";

        try {
            Class<?> aClass = Class.forName(classFullPath);
            Object obj = aClass.getDeclaredConstructor().newInstance();
            System.out.println(obj.getClass());
            Method method = aClass.getMethod(methodName);
            // 关闭安全访问检查，可以提高性能
            method.setAccessible(false);
            method.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void t2() {
        // 一个类只有一个Class对象，在堆中，包含了类的全部信息
        Class<Cat> aClass1 = Cat.class;
        Class<Cat> aClass2 = Cat.class;
        System.out.println(aClass1 == aClass2);
        System.out.println(aClass1.toString());
        System.out.println(aClass2.toString());
    }

    public static void t3() {
        // 泛型，类名.class
        Class<Cat> aClass = Cat.class;
        Cat cat = new Cat();
        // 通过对象获取
        Class<?> aClass1 = cat.getClass();
        // 通过类加载器获取
        ClassLoader classLoader = cat.getClass().getClassLoader();
        try {
            Class<?> aClass2 = classLoader.loadClass("basic.reflect.pojo.Cat");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void t4() {
        System.out.println(int.class); // 基本类型
        System.out.println(Number.class); // 类
        System.out.println(Integer.TYPE); // 包装类型
        System.out.println(Thread.State.class); // 枚举
        System.out.println(Class.class); // Class的class
    }

    public static void testReflect() {
        Class<Dog> clazz = Dog.class;
        Dog obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
//            obj.test1("asdasd");
            Method m = clazz.getDeclaredMethod("test1", int.class);
            m.setAccessible(true);
            m.invoke(obj, 123);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 构造器
        Constructor<?>[] constructors = clazz.getConstructors();      // 只返回public修饰的
//        Constructor<?>[] constructors = clazz.getDeclaredConstructors();    // 返回所有构造函数
        for (Constructor<?> constructor : constructors) {
            System.out.println("参数数量:" + constructor.getParameterCount());
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("参数类型:" + parameterType);
            }
            System.out.println("----------");
        }


        // 方法
        Method[] methods = clazz.getMethods();  //
        for (Method method : methods) {
            System.out.println("method:" + method.getName());
            System.out.println("class:" + method.getClass());
        }

        // 属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名字:" + field.getName());
            System.out.println("属性类型:" + field.getType());
            System.out.println("----------");
        }

        // 提高反射新能的方式
        // 1.链式调用拆解，class.forName的结果提前缓存
        // 2.开启method.setAccessible(true),减少安全性检查
        // 3.字节码方向
    }

    public static void getClassObject() {
        // 获取class对象的几种方式
        Class<?> clazz = Dog.class;
        System.out.println("1.类名.class 调用方式: " + clazz);

        try {
            Class<?> clazz1 = Class.forName("basic.reflect.pojo.Dog");
            System.out.println("2.Class.forName(包名)调用方式: " + clazz1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Dog dog = new Dog();
        Class<?> clazz2 = dog.getClass();
        System.out.println("3.对象.getClass()调用方式: " + clazz2);
    }
}

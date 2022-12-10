package foundation.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClazz {
    public static void main(String[] args) {
//        getClassObject();
        testReflect();
    }

    public static void testReflect(){
        Class<MyTest> clazz = MyTest.class;
        MyTest obj = null;
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
//            obj.test1("asdasd");
            Method m = clazz.getDeclaredMethod("test1", int.class);
            m.setAccessible(true);
            m.invoke(obj, 123);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        // 构造器
        Constructor<?>[] constructors = clazz.getConstructors();      // 只返回public修饰的
//        Constructor<?>[] constructors = clazz.getDeclaredConstructors();    // 返回所有构造函数
        for (Constructor<?> constructor : constructors) {
            System.out.println("参数数量:"+constructor.getParameterCount());
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("参数类型:"+parameterType);
            }
            System.out.println("----------");
        }


        // 方法
        Method[] methods = clazz.getMethods();  //
        for (Method method : methods) {
            System.out.println("method:"+method.getName());
            System.out.println("class:"+method.getClass());
        }

        // 属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性名字:"+field.getName());
            System.out.println("属性类型:"+field.getType());
            System.out.println("----------");
        }

        // 提高反射新能的方式
        // 1.链式调用拆解，class.forName的结果提前缓存
        // 2.开启method.setAccessible(true),减少安全性检查
        // 3.字节码方向
    }

    public static void getClassObject(){
        // 获取class对象的几种方式
        Class<?> clazz = MyTest.class;
        System.out.println("1.类名.class 调用方式: "+clazz);

        try {
            Class<?> clazz1 = Class.forName("foundation.clazz.MyTest");
            System.out.println("2.Class.forName(包名)调用方式: "+clazz1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        MyTest myTest = new MyTest();
        Class<?> clazz2 = myTest.getClass();
        System.out.println("3.对象.getClass()调用方式: "+clazz2);
    }
}


class MyTest {
    private String name;
    private int age;
    public String birthday;

    public MyTest() {}
    private MyTest(int age, String name) {}
    public MyTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void test(){
        System.out.println("----test----");
    }

    private void test1(int a){
        System.out.println("----test1----"+a);
    }

    protected void test2(String name){
        System.out.println("----test2----");
    }
}
package org.zz;

/**
 * java class
 * 1.首先会初始化静态代码块。
 * 2.若new了对象，则调用对应构造函数。
 * 3.如果直接使用静态内部类属性，则不会初始化外部类。
 * 4.static不能修饰局部变量
 * 5.static修饰的变量为静态变量，被所有对象共享,并且内存地址唯一
 * 6.static修饰import语句可以省略包名进行调用
 * 导包：
 * import static java.lang.System.*;     或者
 * import static java.lang.System.out;
 * 使用：
 * out.println("lyy");
 * <p>
 * 7.static代码块只会被执行一次
 * 8.static修饰类只是静态内部类，静态内部类可以被实例化，也可以有非静态的方法
 * 9.静态方法内部不能有this指向
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Student.NUM);
//        System.out.println(Student.A.NNN);
//        Student stu = new Student();
//        Student.A a = new Student.A();
//        System.out.println(a.BBB());
    }
}

class Student {
    // 四种权限，default,public,protected,private
    public String name = "";
    protected int Age = 0;
    private String smallName = "";
    String birthday = "";

    // 静态属性
    public static int NUM = 0;

    // 静态代码块
    static {
        // 内部定义变量无法被外部访问
        int aaa = 0;
        System.out.println("静态代码块");
    }

    // 静态内部类：静态内部类就是被static修饰的内部类，而且如果一个类被static修饰了，那么这个类就只能是一个内部类。
    static class A {
        public static int NNN = 0;

        static {
            System.out.println("静态内部类~静态代码块");
        }

        static int AAA() {
            {
                System.out.println("静态内部类~普通代码块");
            }

            return 345;
        }

        int BBB() {
            return 987;
        }
    }

    // 无参构造函数
    public Student() {
        System.out.println("无参构造函数");
    }

    public static void log() {
        // static不能修饰局部变量
//        static int a = 0;
        System.out.println("静态函数");
        {
            System.out.println("普通代码块");
        }
    }
}
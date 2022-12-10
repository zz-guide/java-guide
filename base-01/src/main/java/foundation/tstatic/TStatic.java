package foundation.tstatic;

/**
 * 1.static不能修饰局部变量
 * 2.static修饰的变量为静态变量，被所有对象共享,并且内存地址唯一
 * 3.static修饰import语句可以省略包名进行调用
 *  导包：
 *     import static java.lang.System.*;     或者
 *     import static java.lang.System.out;
 * 使用：
 *     out.println("lyy");
 *
 * 4.static代码块只会被执行一次
 * 5.static修饰类智能是静态内部类，静态内部类可以被实例化，也可以有非静态的方法
 * 6.静态方法内部不能有this指向
 *
 */

public class TStatic {
    /* public void t1(){
        static int a = 0;
    }*/

    public static class An1 {
        static int NUM = 20;

        static {
            System.out.println("静态代码块");
        }

        static int AAA(){
            {
                System.out.println("普通代码块");
            }

            return 345;
        }

        int BBB(){
            return 987;
        }
    }

    public static void main(String[] args) {
        System.out.println("NUM:" + An1.NUM);
    }
}



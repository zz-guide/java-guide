package basic.datatype;

import java.util.Arrays;

/**
 * java数据类型
 * 基本数据类型：
 * 整数型 byte [1]、short[2] 、int[4] 、long[8]
 * 浮点型 float [4]、 double[8]
 * 字符型 char[2]，存放单个字符，如’a’、‘男’，单个字母占1个字节，单个汉字占2个字节
 * 布尔型 boolean[1]，存放true、false
 * 引用类型：
 * class,interface,arr,enum
 */

public class Main {
    public static void main(String[] args) {
        type();
    }

    public interface T {
    }

    public class Student {
    }

    enum Color {
        // 系统会自动添加 public static final 修饰
        RED, GREEN, BLUE;
    }

    public static void type() {
        // 基本数据类型
        // 整数型 byte [1]、short[2] 、int[4] 、long[8]
        byte b = 1;
        short s = 2;
        int i = 128;
        long ll = 22222222;

        // 浮点型 float [4]、 double[8]
        float f = 0.1F;
        double d = 12.22D;

        // 字符型 char[2]，存放单个字符，如’a’、‘男’，单个字母占1个字节，单个汉字占2个字节
        char sex = '男';
        // 布尔型 boolean[1]，存放true、false
        boolean bl = true;

        // 引用数据类型
        // class,interface,arr,enum
        int[] arr = {1, 2, 3};
    }


    public static void createArray() {
        // 静态数组，定义好长度之后不能超出

        // 1.声明初始化,不指定长度
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));

        // 2.声明初始化，指定长度
        int[] b = new int[3];
        b[0] = 1;
        b[1] = 1;
        System.out.println(Arrays.toString(b));
        System.out.println(b.length);

        // 3.声明初始化，不指定长度，指定初始化元素
        int[] c = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(c));
        System.out.println(c.length);
    }
}

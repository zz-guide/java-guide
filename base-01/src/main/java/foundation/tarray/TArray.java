package foundation.tarray;

import java.util.Arrays;

public class TArray {
    public static void main(String[] args) {
        // 声明初始化,不指定长度
        int[] arr = {1,2,3};
        System.out.println(Arrays.toString(arr));

        // 声明初始化，指定长度
        int[] b = new int[3];
        b[0] = 1;
        b[1] = 1;
        System.out.println(Arrays.toString(b));
        System.out.println(b.length);

        // 声明初始化，不指定长度，指定初始化元素
        int[] c = new int[]{1,2,3};
        System.out.println(Arrays.toString(c));
        System.out.println(c.length);
    }
}

package basic.array;

import java.util.Arrays;

/**
 * java 数组
 */
public class Main {
    public static void main(String[] args) {
    }

    public static void createTwoDimensionalArray() {
        // 二维数组创建,3种方式

//        int[][] arr = new int[3][3];
        int[][] arr = new int[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
//        int[][] arr = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};

        System.out.println(Arrays.deepToString(arr));
        System.out.println(arr.length);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = -1;
            }
        }

        System.out.println(Arrays.deepToString(arr));
        System.out.println(arr.length);
    }
}

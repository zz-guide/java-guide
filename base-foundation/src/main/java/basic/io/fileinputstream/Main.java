package basic.io.fileinputstream;

import java.io.File;
import java.io.FileInputStream;

/**
 * 测试FileInputStream
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/fileinputstream/";

    public static void main(String[] args) {
//        t1();
//        t2();
        t3();
    }

    public static void t1() {
        // FileInputStream 读取文件内容
        File file = new File(currentDirPath + "t.txt");
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // inputStream.read() 读取一个字节数据,读不到数据返回-1，可能发生异常
            int res = inputStream.read(); //
            System.out.println(res);
            System.out.println((char) res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void t2() {
        // FileInputStream 读取文件内容
        File file = new File(currentDirPath + "t.txt");
        int res = 0;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // 一直调用read，每次读取一个字节数据
            // 缺点：1.频繁调用read，一次一个字节，效率低；2.中文等多字节数据会乱码
            while ((res = inputStream.read()) != -1) {
                System.out.println(res);
                System.out.println((char) res);
            }

            System.out.println("----------读取完毕----------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void t3() {
        File file = new File(currentDirPath + "t.txt");
        int res = 0;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[4]; // 一次1kb
            String str = "";
            while ((res = inputStream.read(bytes)) != -1) {
                // 注意此处 不能使用 new String(bytes),如果是图片的话可能读取数据异常，因为有不够1kb的情况
                String temp = new String(bytes, 0, res);
                System.out.println("每次读取数据：" + temp + "," + res);
                str += temp;
            }
            System.out.println("1kb数据：" + str);

            System.out.println("----------读取完毕----------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

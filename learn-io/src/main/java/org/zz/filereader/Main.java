package org.zz.filereader;

import java.io.File;
import java.io.FileReader;

/**
 * 字符流,FileReader,节点流
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/fileoutputstream/";

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        File file = new File(currentDirPath + "t.txt");
        int res = 0;
        try (FileReader fileReader = new FileReader(file)) {
            // 读取一个字符,用法和字节流一模一样
            res = fileReader.read();
            System.out.println((char) res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

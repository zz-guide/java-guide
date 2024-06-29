package org.zz.filewriter;

import java.io.File;
import java.io.FileWriter;

/**
 * 字符流,FileWriter,节点流
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/fileoutputstream/";

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        // 字符流
        File file = new File(currentDirPath + "t.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            // 写入字符串数据
            fileWriter.write("ab我ba");
            // 写入字符数组数据
            fileWriter.write("我是你die".toCharArray());
            // 还能指定位置，长度写入
            fileWriter.write("ab我ba", 1, 4);
            // flush和close作用一样，把内存数据刷到磁盘，内部调用的同一个持久化方法
//            outputStream.flush();
//            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

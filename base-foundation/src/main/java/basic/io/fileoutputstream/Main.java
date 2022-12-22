package basic.io.fileoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 测试FileOutputStream
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/fileoutputstream/";

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        File file = new File(currentDirPath + "t.txt");
        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            // 写入具体的字节数据
            outputStream.write(97);
            // string 转 byte
            outputStream.write("我是你die".getBytes());
            // flush和close作用一样，把内存数据刷到磁盘，内部调用的同一个持久化方法
//            outputStream.flush();
//            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

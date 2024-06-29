package org.zz.file;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 测试File
 */
public class Main {
    public static void main(String[] args) {
//        t1();
//        t2();
        createFile();
    }

    public static void t1() {
        // /Users/xulei/jungle/javaworkspace/java-guide
        // 获取根项目路径
        File file = new File("");
        String path = file.getAbsolutePath();
        System.out.println(path);

        try {
            String path1 = file.getCanonicalPath(); // 获取一个规范化路径
            System.out.println(path1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String path2 = System.getProperty("user.dir");
        System.out.println(path2);

        // 获取类加载的根路径 Users/xulei/jungle/javaworkspace/java-guide/base-foundation/target/classes/
        String path3 = Objects.requireNonNull(Main.class.getResource("/")).getPath().substring(1);
        System.out.println(path3);

        // 获取当前类的所在工程路径,区别在于不加"/"
        // Users/xulei/jungle/javaworkspace/java-guide/base-foundation/target/classes/basic/io/file/
        String path4 = Objects.requireNonNull(Main.class.getResource("")).getPath().substring(1);
        System.out.println(path4);

        //获取所有的类路径 包括jar包的路径
        // /Users/xulei/jungle/javaworkspace/java-guide/base-foundation/target/classes:/Users/xulei/.m2/repository/cglib/cglib/3.3.0/cglib-3.3.0.jar:/Users/xulei/.m2/repository/org/ow2/asm/asm/7.1/asm-7.1.jar
        String path5 = System.getProperty("java.class.path");
        System.out.println(path5);
    }

    public static void t2() {
        File file = new File("");
    }

    public static void createFile() {
        File file = new File("./base-foundation/src/main/java/basic/io/file/" + "t.txt");
        try {
            // 创建文件createNewFile()
            boolean res = file.createNewFile();
            if (res) {
                System.out.println("创建成功");
            } else {
                System.out.println("创建失败");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package org.zz;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 测试加载properties文件的几种方式
 * 1.加载properties文件的方式
 * 结论：本质上需要load一个文件的stream，获取stream的方式非常多
 * 2.properties文件读取中文乱码问题，ISO-8859-1,修改idea配置
 */
public class Main {
    public static void main(String[] args) {
//        f1();
        f2();
//        f3();
    }

    public static void f1() {
        // 使用java.util.Properties类的load()
        try {
            // 如果直接使用stream类读取，那么需要传入相对路径或者绝对路径，可能因为服务器地址不同而发生改变
            // 编译的时候会把resources目录下的文件拷贝到classes目录下,所以先获取绝对路径然后进行拼接
            String resourcePath = Objects.requireNonNull(Main.class.getResource("/")).getPath();// 切记加/表示classes根路径
            // 等价于
            String resourceFilePath = Objects.requireNonNull(Main.class.getResource("/")).getFile();// 切记加/表示classes根路径
            System.out.println("resourceFilePath:" + resourceFilePath);
            String filePath = URLDecoder.decode(resourcePath, StandardCharsets.UTF_8);//如果路径中带有中文会被URLEncoder,因此这里需要解码
            System.out.println("filePath:" + filePath);
            // /Users/xulei/jungle/javaworkspace/java-guide/base-foundation/target/classes/
            InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath + "db.properties"));
            Properties p = new Properties();
            p.load(inputStream);
            System.out.println(p.getProperty("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void f2() {
        // 使用ClassLoader.getResourceAsStream()读取
        // 使用该方法不需要提前获取路径，适合jar包程序
        try {
            Properties p = new Properties();

//            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("db.properties");// 不需要加/
//            p.load(inputStream);

            InputStream inputStream1 = ClassLoader.getSystemResourceAsStream("db.properties");
            p.load(inputStream1);

//            InputStream inputStream2 = Main.class.getResourceAsStream("/db.properties");// 直接使用class.getResourceAsStream()
//            p.load(inputStream2);
            System.out.println(p.getProperty("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void f3() {
        // 使用ResourceBundle.getBundle()读取,该方法默认读取的是resources文件夹下的以.properties为后缀的文件
        // 使用这种方式，getBundle() 的参数不需要带路径，也不需要带扩展名，但是 db.properties 文件必须在被标记为Resource Root的文件夹之下。
        try {
            // 使用父类
            ResourceBundle bundle = ResourceBundle.getBundle("db");//不需要后缀
            System.out.println(bundle.getString("url"));

            // 使用子类
            ResourceBundle bundle1 = PropertyResourceBundle.getBundle("db");
            System.out.println(bundle.getString("url"));
            System.out.println(bundle.getString("aaa"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f11() {
        // spring框架建议使用ClassPathResource->stream
        // 或者使用ResourceUtils，但是要注意，getFile()不能嵌套在jar文件中
        // https://blog.csdn.net/engineer_zoey/article/details/90172663
//        try {
//            ClassPathResource classPathResource = new ClassPathResource("db.properties");
//            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(classPathResource.getInputStream());
//            Properties p = new Properties();
//            p.load(inputStream);
//            System.out.println(p.getProperty("url"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

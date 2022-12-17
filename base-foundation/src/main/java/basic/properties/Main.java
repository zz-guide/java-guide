package basic.properties;

import java.util.ResourceBundle;

/**
 * 测试加载properties文件的几种方式
 */
public class Main {
    public static void main(String[] args) {


    }

    public static void t1() {
        /**
         * 加载properties一共2种方式：
         *  1.ResourceBundle 不需要加后缀
         *  2.Properties
         *      inputstream
         */

        //            InputStream inputStream = new BufferedInputStream(new FileInputStream(new File("src/main/java/db/db.properties")));
//            InputStream inputStream = ClassLoader.getSystemResourceAsStream("db/db.properties");;

         /*ResourceBundle bundle = ResourceBundle.getBundle("db.db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");*/

    }
}

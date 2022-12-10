package db.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class DB {
    static Connection conn;

    /**
     * 加载properties一共2种方式：
     *  1.ResourceBundle 不需要加后缀
     *  2.Properties
     *      inputstream
     */
    static {
        String driver = "";
        String url = "";
        String user = "";
        String password = "";

        Properties prop = new Properties();
        try {
//            InputStream InputStream = new BufferedInputStream(new FileInputStream(new File("src/main/java/db/db.properties")));
//            InputStream InputStream = ClassLoader.getSystemResourceAsStream("db/db.properties");;
            InputStream InputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db/db.properties");;
            prop.load(InputStream);
            driver = prop.getProperty("driver");
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");

        } catch (IOException e) {
            e.printStackTrace();
        }


        /*ResourceBundle bundle = ResourceBundle.getBundle("db.db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        user = bundle.getString("user");
        password = bundle.getString("password");*/

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("jdbc jar没有加载成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }

    public static Connection getConnection() {
        return conn;
    }

}

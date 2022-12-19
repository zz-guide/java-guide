package dbutils.db;

import org.apache.commons.dbutils.DbUtils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 自己封装的jdbc工具类
 */
public class JDBCUtil {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtil.class.getResourceAsStream("/db.properties");
            properties.load(inputStream);
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 连接数据库
     *
     * @return 一个数据库的连接
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭数据库连接
     *
     * @param connection 数据库连接
     *                   需要关闭资源就传入对象，否则传入null即可
     */
    public static void close(Connection connection) {
        DbUtils.closeQuietly(connection);
    }
}

package jdbc.db;

import java.io.FileInputStream;
import java.io.IOException;
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
            properties.load(new FileInputStream("db.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
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
     * @param resultSet  结果集
     * @param statement  用于执行sql语句的对象
     * @param connection 数据库连接
     *                   需要关闭资源就传入对象，否则传入null即可
     */
    public static void close(Statement statement, Connection connection, ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public static void close(Statement statement, Connection connection) {
        close(statement, connection, null);
    }

    /**
     * insert,update,delete统一操作
     *
     * @param sql sql语句
     * @param obj 参数
     * @return bool
     */
    public static boolean cud(String sql, Object... obj) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            for (int i = 1; i <= obj.length; i++) {
                ps.setObject(i, obj[i - 1]);
            }

            System.out.println("执行sql:" + sql);
            int res = ps.executeUpdate();
            return res > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(ps, conn, null);
        }

        return false;
    }


}

package c3p0.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 自己封装的jdbc工具类
 */
public class JDBCUtil {
    private static final DataSource dataSource;

    static {
        try {
            dataSource = new ComboPooledDataSource("myC3p0");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DataSource getDataSource() {
        return dataSource;
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

package druid.db;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

/**
 * 自己封装的jdbc工具类
 */
public class JDBCUtil {
    private static final DataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            InputStream inputStream = JDBCUtil.class.getResourceAsStream("/druid.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

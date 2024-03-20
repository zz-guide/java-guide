package c3p0.db;

import c3p0.pojo.Store;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class MyC3p0DbUtils {
    static DataSource dataSource = JDBCUtil.getDataSource();

    public static void query() {
        Connection conn = null;
        /**
         * MapHandler：单行处理器！把结果集转换成Map<String,Object>，其中列名为键！
         * BeanHandler：单行处理器！把结果集转换成Bean，该处理器需要Class参数，即Bean的类型；
         * MapListHandler：多行处理器！把结果集转换成List<Map<String,Object>>；
         * BeanListHandler：多行处理器！把结果集转换成List<Bean>；
         * ColumnListHandler：多行单列处理器！把结果集转换成List<Object>，使用ColumnListHandler时需要指定某一列的名称或编号，例如：new ColumListHandler("name")表示把name列的数据放到List中。
         * ScalarHandler：单行单列处理器！把结果集转换成Object。一般用于聚集查询，例如select count(*) from tab_student。
         *
         */
        String sql = "select * from store where id=?";
        QueryRunner qr = new QueryRunner(dataSource);
        // 把一行记录转换成一个Map，其中键为列名称，值为列值
        try {
            conn = dataSource.getConnection();
//            Map<String, Object> map = qr.query(conn, sql, new MapHandler(), 82);
//            System.out.println("查询成功:" + map);
            Store store = qr.query(sql, new BeanHandler<>(Store.class), 82);
            System.out.println(store.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }
}

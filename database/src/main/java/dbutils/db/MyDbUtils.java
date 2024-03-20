package dbutils.db;

import dbutils.pojo.Store;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

/**
 * 参考网站：https://www.cnblogs.com/xy-ouyang/p/16195001.html
 * https://blog.csdn.net/lianghecai52171314/article/details/102995870
 */
public class MyDbUtils {
    static Connection conn = JDBCUtil.getConnection();

    public static void query() {
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
        QueryRunner qr = new QueryRunner();
        // 把一行记录转换成一个Map，其中键为列名称，值为列值
        try {
//            Map<String, Object> map = qr.query(conn, sql, new MapHandler(), 82);
//            System.out.println("查询成功:" + map);
            Store store = qr.query(conn, sql, new BeanHandler<>(Store.class), 82);
            System.out.println(store.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void count() {
        String sql = "select count(*),name from store";
        QueryRunner qr = new QueryRunner();
        try {
            // ScalarHandler 主要用于聚合函数
            Number num = qr.query(conn, sql, new ScalarHandler<Number>());
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void batchInsert() {
        String sql = "insert into store(name) values(?)";
        Object[][] params = new Object[10][];//表示 要插入10行记录
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{"河北校区" + i,};
        }

        QueryRunner qr = new QueryRunner();
        try {
            int[] res = qr.batch(conn, sql, params);
            System.out.println(Arrays.toString(res));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }

    public static void cud() {
        // 统一的增删改方法
        QueryRunner qr = new QueryRunner();
        try {
//            String sql1 = "insert into store(name) values(?)";
//            int res1 = qr.update(conn, sql1, "哈哈校区");
//            System.out.println(res1);

//            String sql2 = "update store set name = ? where id = ?";
//            int res2 = qr.update(conn, sql2, "哈哈校区1", 82);
//            System.out.println(res2);
//
            String sql3 = "delete from store where id = ?";
            int res3 = qr.update(conn, sql3, 83);
            System.out.println(res3);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(conn);
        }
    }
}

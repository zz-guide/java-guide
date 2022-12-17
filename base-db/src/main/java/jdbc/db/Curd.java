package jdbc.db;

import java.sql.*;
import java.util.Arrays;
import java.util.Date;

/**
 * jdbc curd
 * 参考官方文档：https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html
 */
public class Curd {
    static Connection conn = JDBCUtil.getConnection();

    public static void insert() {
        String name = "单店校区";
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        int res = 0;
        try {
            String sql = "insert into store(name,created_at) values(?,?)";
            pStmt = conn.prepareStatement(sql);

            pStmt.setString(1, name);
            pStmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            res = pStmt.executeUpdate();
            if (res > 0) {
                System.out.println("插入成功");
            } else {
                System.out.println("插入失败");
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            JDBCUtil.close(pStmt, conn);
        }
    }

    public static void batchInsert() {
        // 没有使用事务
        String name = "单店校区";
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        int[] res;
        try {
            String sql = "insert into store(name,created_at) values(?,?)";
            pStmt = conn.prepareStatement(sql);
            // 测试批量插入
            for (int i = 0; i < 100; i++) {
                pStmt.setObject(1, name + i);
                pStmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
                pStmt.addBatch();
                // 每500条数据执行一次插入
                if (i % 20 == 0) {
                    res = pStmt.executeBatch();
                    System.out.println("批量插入结果:" + Arrays.toString(res));
                    if (res.length == 0) {
                        System.out.println("插入失败");
                    } else {
                        System.out.println("插入成功");
                    }

                    pStmt.clearBatch();
                }
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            JDBCUtil.close(pStmt, conn);
        }
    }

    public static void query() {
        int id = 1;
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        ResultSet resultSet = null;
        try {
            String sql = "select * from store where id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setObject(1, id);
            resultSet = pStmt.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
                System.out.printf("结果:%s,%s, %s\n",
                        resultSet.getString("id"),
                        resultSet.getString("name"),
                        resultSet.getString("created_at"));
                System.out.println();
            }

            if (count == 0) {
                System.out.println("未查询到数据");
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            JDBCUtil.close(pStmt, conn, resultSet);
        }
    }

    public static void update() {
        int id = 1;
        String name = "更新校区";
        int res = 0;
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        try {
            String sql = "update store set name = ? where id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setObject(1, name);
            pStmt.setObject(2, id);
            res = pStmt.executeUpdate();
            if (res == 0) {
                System.out.println("修改失败");
            } else {
                System.out.println("修改成功");
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            JDBCUtil.close(pStmt, conn);
        }
    }

    public static void delete() {
        int id = 6;
        int res = 0;
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        try {
            String sql = "delete from store where id = ?";
            pStmt = conn.prepareStatement(sql);
            pStmt.setObject(1, id);
            res = pStmt.executeUpdate();
            if (res == 0) {
                System.out.println("删除失败");
            } else {
                System.out.println("删除成功");
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            JDBCUtil.close(pStmt, conn);
        }
    }

    public static void transaction() {
        //开启事务: setAutoCommit(boolean autoCommit) : 调用该方法设置参数为false,即开启事务
        //提交事务: commit()
        //回滚事务: rollback()

        String name = "单店校区";
        PreparedStatement pStmt = null; // 预编译，防止sql注入
        int[] res;
        try {
            conn.setAutoCommit(false);  // 关闭自动提交；
            String sql = "insert into store(name,created_at) values(?,?)";
            pStmt = conn.prepareStatement(sql);
            // 测试批量插入
            for (int i = 0; i < 100; i++) {
                pStmt.setObject(1, name + i);
                pStmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
                pStmt.addBatch();
                // 每500条数据执行一次插入
                if (i % 20 == 0) {
                    res = pStmt.executeBatch();
                    System.out.println("批量插入结果:" + Arrays.toString(res));
                    if (res.length == 0) {
                        System.out.println("插入失败");
                        throw new Exception("插入失败");
                    } else {
                        System.out.println("插入成功");
                    }

                    pStmt.clearBatch();
                }
            }

            conn.commit();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception e) {
            //事务回滚
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pStmt, conn);
        }
    }


}

package db.jdbc;

import java.sql.Connection;

/**
 * 1.https://dev.mysql.com/downloads/connector/j/
 * 2.
 */
public class TJdbc {
    public static void main(String[] args) {
        Connection conn = DB.getConnection();
        System.out.println(conn);
    }
}

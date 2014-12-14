package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** jdbc管理连接工具类,可以获取连接喝关闭连接 */
public class DBUtil {
    /** 获取连接对象 */
    public static Connection getConnection() throws Exception {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:orcl", "scott", "123456");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return con;
    }

    /**
     * 关闭连接对象
     *
     * @throws java.sql.SQLException
     */
    public static void close(Connection con) throws SQLException {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getConnection());
    }
}

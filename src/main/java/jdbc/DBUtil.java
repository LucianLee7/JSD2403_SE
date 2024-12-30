package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用当前类管理数据库链接
 */
public class DBUtil {
    static {
        try {
            //当前类第一次加载时,将数据库驱动导入,驱动导入一次即可
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException {
       return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );
    }
}
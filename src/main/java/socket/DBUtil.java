package socket;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 使用当前类管理数据库链接
 */
public class DBUtil {
    private static DruidDataSource ds;
    static {
        ds = new DruidDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        ds.setUsername("root");
        ds.setPassword("root");
        ds.setInitialSize(5);//初始连接数
        ds.setMaxActive(10);//最大连接数
    }
    public static Connection getConnection() throws SQLException {
        /*
            返回连接池中的一条空闲链接
            如果连接池中没有连接此方法会阻塞
            外面连接使用完毕后直接调用连接的close方法即可,此时该链接不会被关闭而是相当于
            还给了连接池
         */
        return ds.getConnection();
    }
}
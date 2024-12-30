package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
            使用JDBC与数据库进行操作的基本步骤:
            1:加载驱动:Class.forName("com.mysql.jdbc.Driver");
            2:使用驱动管理器与数据库建立连接，此时要指定数据库的IP,PORT，用户名和密码
              驱动管理器与数据库建立连接后会返回一个Connection对象，表示与该数据库的连接
            3:通过连接对象Connection创建执行语句对象Statement
            4:通过Statement执行SQL语句
            5:如果自行的是DQL语句则会得到查询结果集ResultSet
            6:遍历结果集得到查询数据
            7:关闭连接
         */
        //1加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2建立连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );
        System.out.println("与数据库建立连接!");

        //3创建执行语句对象Statement
        Statement state = connection.createStatement();
        /*
            在tedu库中创建一张名为userinfo的表

            CREATE TABLE userinfo(
                id INT PRIMARY KEY AUTO_INCREMENT,
                username VARCHAR(20),
                password VARCHAR(20),
                nickname VARCHAR(20),
                age INT(3)
            );
         */
        String sql = "CREATE TABLE userinfo( " +
                "          id INT PRIMARY KEY AUTO_INCREMENT, " +
                "          username VARCHAR(20), " +
                "          password VARCHAR(20), " +
                "          nickname VARCHAR(20), " +
                "          age INT(3) " +
                "     )";
        /*
            执行SQL
            boolean execute(String sql)
            用来向数据库执行SQL语句的。返回值表达执行该SQL后是否产生了查询结果集
            由于执行DML和DQL都有专门的execute方法，因此当前这个execute通常用来
            执行DDL语句
         */
        state.execute(sql);
        System.out.println("执行完毕!");
        //关闭连接
        connection.close();
    }
}








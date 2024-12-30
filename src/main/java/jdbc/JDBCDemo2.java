package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 执行DML语句
 */
public class JDBCDemo2 {
    public static void main(String[] args)throws Exception {
        /*
            向userinfo表中插入一条记录
         */
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/tedu?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true",
                "root",
                "root"
        );
        Statement state = connection.createStatement();
        /*
            INSERT INTO userinfo(username,password,nickname,age)
            VALUES('张三','123456','阿三',22)
         */
        String sql = "INSERT INTO userinfo(username,password,nickname,age) " +
                     "VALUES('张三','123456','阿三',22)";
        /*
            专门用来执行DML语句的(INSERT,UPDATE,DELETE)
            int executeUpdate(String sql)
            执行sql后返回值表示影响了表中多少条记录
         */
        int d = state.executeUpdate(sql);
        if(d>0){
            System.out.println("插入成功");
        }
        connection.close();

    }
}

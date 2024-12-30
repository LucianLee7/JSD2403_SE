package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行DQL语句
 */
public class JDBCDemo5 {
    public static void main(String[] args) {
        try (
                Connection connection = DBUtil.getConnection();
        ){
            Statement state = connection.createStatement();
            String sql = "SELECT id,name,salary,title " +
                         "FROM teacher";
            /*
                Statement提供执行DQL语句的方法:
                ResultSet executeQuery(String sql)
                执行给定的DQL语句并获取查询结果集
             */
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int salary = rs.getInt("salary");
                String name = rs.getString("name");
                String title = rs.getString("title");
                System.out.println(id+","+name+","+salary+","+title);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





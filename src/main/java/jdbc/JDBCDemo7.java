package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 字段别名
 */
public class JDBCDemo7 {
    public static void main(String[] args) {
        try (
                Connection connection = DBUtil.getConnection();
        ){
            Statement state = connection.createStatement();
            //查看1年级1班的人数
            String sql = "SELECT COUNT(*) count " +
                         "FROM class c " +
                         "JOIN student s ON s.class_id=c.id " +
                         "WHERE c.name='1年级1班'";
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                int count = rs.getInt("count");
                System.out.println("人数:"+count);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}









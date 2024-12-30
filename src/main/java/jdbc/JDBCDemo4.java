package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除表中数据
 */
public class JDBCDemo4 {
    public static void main(String[] args) {
        //根据给定的id删除用户
        try (
                Connection connection = DBUtil.getConnection();
        ){
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM userinfo " +
                         "WHERE id=1 ";//删除id为1的用户
            int d = statement.executeUpdate(sql);
            if(d>0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}






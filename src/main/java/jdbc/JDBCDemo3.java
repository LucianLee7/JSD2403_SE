package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 修改表中数据
 */
public class JDBCDemo3 {
    public static void main(String[] args) {
        //将"王克晶"的密码改为666666
        try(
            Connection connection = DBUtil.getConnection();
        ){
            String sql = "UPDATE userinfo " +
                         "SET password='666666' " +
                         "WHERE username='王克晶' ";
            Statement state = connection.createStatement();
            int d = state.executeUpdate(sql);
            if(d>0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}

package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用预编译SQL完成用户注册
 */
public class JDBCDemo9 {
    public static void main(String[] args) {
        User user = InputUtil.getInputObject(new User(),"欢迎注册","注册");

        try (
                Connection connection = DBUtil.getConnection();
        ){

            String sql = "INSERT INTO userinfo (username,password,nickname,age) " +
                         "VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            ps.setInt(4, user.getAge());
            int d = ps.executeUpdate();
            if(d>0){
                System.out.println("注册成功");
            }else{
                System.out.println("注册失败");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}






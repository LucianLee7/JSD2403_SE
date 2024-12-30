package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 执行预编译SQL
 */
public class JDBCDemo8 {
    public static void main(String[] args) {
        User user = InputUtil.getInputObject(new User(),"欢迎登录","登录");

        try (
                Connection conn = DBUtil.getConnection();
        ){
           //预编译SQL,用"?"占位代替值,但是语义已经明确
           String sql = "SELECT id,username,password,nickname,age " +
                        "FROM userinfo " +
                        "WHERE username=? AND password=? ";
           //创建PS时会先将预编译SQL发送给数据库,让其理解语义
           PreparedStatement ps = conn.prepareStatement(sql);
           //设置两个?实际表示的值
           ps.setString(1,user.getUsername());
           // asdasd' OR 'a'='a
           ps.setString(2,user.getPassword());
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               System.out.println("登录成功");
           }else{
               System.out.println("登录失败");
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

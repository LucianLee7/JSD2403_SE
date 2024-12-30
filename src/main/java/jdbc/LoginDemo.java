package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用户登录
 */
public class LoginDemo {
    public static void main(String[] args) {
        User user = InputUtil.getInputObject(new User(),"欢迎登录","登录");

        try (
                Connection connection = DBUtil.getConnection();
        ){
            Statement state = connection.createStatement();
            /*
                SELECT id,username,password,nickname,age
                FROM userinfo
                WHERE username = '范传奇' AND password = '666666'
             */
            String sql = "SELECT id,username,password,nickname,age " +
                         "FROM userinfo " +
                         "WHERE username = '"+user.getUsername()+"' " +
                         "AND password = '"+user.getPassword()+"'";
            System.out.println(sql);
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                System.out.println("登录成功!");
            }else{
                System.out.println("登录失败,用户名或密码不正确");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}






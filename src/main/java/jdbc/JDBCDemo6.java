package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 执行关联查询
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        //王克晶所带班级的信息，列出老师的名字，老师的性别，班级名，所在楼层
        try (
            Connection connection = DBUtil.getConnection();
        ){
            Statement state = connection.createStatement();
//            String sql = "SELECT t.name,t.gender,c.name,c.floor " +
//                         "FROM teacher t,class c " +
//                         "WHERE t.id=c.teacher_id " +
//                         "AND t.name='王克晶' ";
            String sql = "SELECT t.name,t.gender,c.name,c.floor " +
                         "FROM teacher t " +
                         "JOIN class c ON t.id=c.teacher_id " +
                         "WHERE t.name='王克晶' ";
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()){
                String tname = rs.getString("t.name");
                String tgender = rs.getString("t.gender");
                String cname = rs.getString("c.name");
                int cfloor = rs.getInt("c.floor");
                System.out.println(tname+","+tgender+","+cname+","+cfloor);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}






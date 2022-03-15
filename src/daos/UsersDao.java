package daos;

import Beans.Users;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//从数据库中获得用户信息，返回相关信息
public class UsersDao {
    public Users getUser(String username, String password) {
        System.out.println(username+""+password);
        Connection conn = null;
        Users user = null;
        try {
            conn = DBFactory.INSTANCE.getConnection();
            String sql = "select *  from zhuce where username=? and password=?";
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setString( 1, username );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Users();
                user.setUsername( rs.getString( 1 ) );
                user.setPassword( rs.getString( 2 ) );
                System.out.println(rs.getString(1)+" "+rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            DBFactory.INSTANCE.closeConnection( conn );
            DBFactory.INSTANCE.closeConnection(conn);
        }
        return user;
    }
}

package daos;

import Beans.Student;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Student {
    public List<Student> getStusByName(String sname,String sclass) {

        Connection conn = null;
        List<Student> list = new ArrayList<Student>();
        try {
            conn = DBFactory.INSTANCE.getConnection();
            System.out.println(4);
            String sql = "select * from login1 where sname~ '^"+sname+"' and sclass~ '^"+sclass+"'";
            PreparedStatement ps = conn.prepareStatement( sql );

//            ps.setString( 1, sname );
//            ps.setString( 2, sclass );
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while (rs.next()) {
                Student s = new Student();
                s.setSno( rs.getString( 1 ) );
                s.setSname( rs.getString( 2 ) );
                s.setSclass( rs.getString( 3 ) );
                s.setContact( rs.getString( 4 ) );
                list.add( s );
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null)
                DBFactory.INSTANCE.closeConnection( conn );
        }
        return list;
    }
}

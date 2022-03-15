package daos;


import Beans.com.hw.Students;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Students {
    public List<Students> getStudents(String sname, String classname) {
        Connection conn;
        List<Students> stu = new ArrayList<Students>();
        conn = DBFactory.INSTANCE.getConnection();
//        String sql = "select * from students where sname ~^? or classname ~^? ";
        String sql = "select * from students where sname like '%"+sname+"%' and classname like '%"+classname+"%' ";
        try {
            PreparedStatement ps = conn.prepareStatement( sql );
//            ps.setString( 1,sname );
//            ps.setString( 2,classname );
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Students s = new Students();
                    s.setSid( rs.getInt( 1 ) );
                    s.setSname( rs.getString( 2 ) );
                    s.setSex( rs.getString( 3 ) );
                    s.setClassname( rs.getString( 4 ) );
                    stu.add( s );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            DBFactory.INSTANCE.closeConnection( conn );
        }
        return stu;
    }
}

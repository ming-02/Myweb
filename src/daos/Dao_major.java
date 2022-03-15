package daos;
import Beans.major;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Dao_major {
    public  List<major> getmajor(String sname){
    Connection conn;
    List<major> major=new ArrayList<major>(  );
    conn=DBFactory.INSTANCE.getConnection();
    String sql1="select sid from school where sname=?";
    int sid=0;
    String sql2="select * from major where sid=?";
        try {
            PreparedStatement ps1=conn.prepareStatement( sql1 );
            ps1.setString( 1, sname );
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next()){
                sid=rs1.getInt( 1 );
                System.out.println("sid="+sid);
            }
            PreparedStatement ps2=conn.prepareStatement( sql2 );
            ps2.setInt( 1, sid );
            System.out.println(ps2);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()){
                major m=new major();
                m.setSid(rs2.getInt( 1 )  );
                m.setMid( rs2.getInt( 2 ) );
                m.setName( rs2.getString(3 ));
                System.out.println(rs2.getInt( 1 ) +" "+rs2.getInt( 2 ) +" "+rs2.getString(3 ));
                major.add( m );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return major;
    }
}
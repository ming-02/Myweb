package daos;

import Beans.school;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Dao_school {
    public List<school> getschool(){
        Connection conn;
        List<school> shool=new ArrayList<school>();
        conn= DBFactory.INSTANCE.getConnection();
        String sql="select * from school ";
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                school s=new school();
                s.setSid( rs.getInt( 1 ) );
                s.setSname( rs.getString( 2 ) );
                shool.add( s );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn!=null){
            DBFactory.INSTANCE.closeConnection( conn );
        }
        return shool;
    }

}

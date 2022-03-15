package daos;


import Beans.SchoolMajor;
import tools.DBFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getSchoolMajor {
    public List<SchoolMajor> getAll()  {
        List<SchoolMajor> list = new ArrayList<SchoolMajor>();
        Connection conn = DBFactory.INSTANCE.getConnection();
        String sql = "select school.sid,sname,to_json(array_agg(major))as majors from school,major where school.sid=major.sid group by school.sid";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            SchoolMajor s=new SchoolMajor();
            s.setSid(rs.getInt(1));
            s.setSname(rs.getString(2));
            s.setMajors(rs.getString(3));
            list.add(s);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBFactory.INSTANCE.closeConnection(conn);
        }
    return list;
    }
}

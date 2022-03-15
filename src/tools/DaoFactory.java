package tools;

import Beans.*;
import Beans.com.hw.Students;
import daos.*;

import javax.inject.Singleton;
import java.util.List;
@Singleton
public class DaoFactory {
    public static DaoFactory INSTANCE=new DaoFactory();
    //用户登录
    public Users login(String username,String password){
        return new UsersDao().getUser( username,password );
    }
    public Users loginVindex(String username,String password){
        return new Dao_vindex().getVindex(username,password);
    }
    //查询指定姓名的学生信息
    public List<Student>findStudentsByName1(String uname){
        return new Dao_Student1().getStusByName1(uname);
    }
    public List<Student>findStudentsByName(String uname,String sclass){
        return new Dao_Student().getStusByName(uname,sclass);
    }
    public List<Students>findStudents(String name,String classname){
        return new Dao_Students().getStudents( name,classname );
    }
    public List<school>getschool(){
        return  new Dao_school().getschool(  );
    }
    public List<major>getMajor(String sname){
        return  new Dao_major().getmajor( sname);
    }
    public List<SchoolMajor>getSchoolMajors(){
        return  new getSchoolMajor().getAll();
    }
}

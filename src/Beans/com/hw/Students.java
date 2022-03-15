package Beans.com.hw;

public class Students {
   private int sid;
   private String sname;
   private String sex;
   private String classname;
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getSname() { return sname; }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getClassname() { return classname; }
    public void setClassname(String classname) { this.classname = classname; }
    @Override
    public String toString() {
        return "Students{" + "sid=" + sid + ", sname='" + sname + '\'' + ", sex='" + sex + '\'' +
                ", classname='" + classname + '\'' +
                '}';
    }
}

package Beans;

public class SchoolMajor {
    private int sid;
    private String sname;
    private String majors;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getMajors() {
        return majors;
    }



    public void setMajors(String majors) {
        this.majors = majors;
    }
    @Override
    public String toString() {
        return "SchoolMajor{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", majors='" + majors + '\'' +
                '}';
    }

}

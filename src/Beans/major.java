package Beans;

public class major {
    private int sid;
    private int mid;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "major{" +
                "sid=" + sid +
                ", mid=" + mid +
                ", name='" + name + '\'' +
                '}';
    }
}

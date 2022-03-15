package Beans;



public class OnlineCounter {
    private static long onlineUser = 0L;

    public OnlineCounter() {
    }

    public static long getOnlineUser() {
        return onlineUser;
    }

    public static void UserIn() {
        ++onlineUser;
        System.out.println(onlineUser);
    }

    public static void UserOut() {
        --onlineUser;
        System.out.println(onlineUser);
    }
}
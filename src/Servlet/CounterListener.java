package Servlet;
import Beans.OnlineCounter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class CounterListener implements HttpSessionListener {
    public CounterListener() {
    }

    public void sessionCreated(HttpSessionEvent event) {
        synchronized(this) {
            OnlineCounter.UserIn();
        }
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        synchronized(this) {
            OnlineCounter.UserOut();
        }
    }
}
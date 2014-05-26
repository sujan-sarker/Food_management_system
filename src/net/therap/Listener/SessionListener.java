package net.therap.Listener;

/**
 * Created with IntelliJ IDEA.
 * User: sujan.sarkar
 * Date: 5/25/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
    private static int totalUser;
    static int total=0;

    public void sessionCreated(HttpSessionEvent e) {
        HttpSession httpSession = e.getSession();
        if(httpSession.getAttribute("verifiedUser") == null ) {
            synchronized (this) {
                total++;
            }
            totalUser = total;
            System.out.println(totalUser);
        }
    }

    public void sessionDestroyed(HttpSessionEvent e) {
        synchronized (this) {
            total--;
        }
        totalUser = total;
        System.out.println(totalUser);
    }

    public static int getTotalUser() {
       return totalUser;
    }

}

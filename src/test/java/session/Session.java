package session;

import browser.ChromeProxy;
import org.openqa.selenium.WebDriver;

public class Session {
    private static Session session = null;
    private WebDriver browser;

    private Session(){
        browser = new ChromeProxy().create();
    }
    public static Session getSession(){
        if (session == null)
            session = new Session();

        return session;
    }

    public WebDriver getBrowser() {
        return browser;
    }


}

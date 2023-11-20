package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class MainPage {

    public WebElement loginButton;
    public WebElement cartButton;


    public MainPage(){
        loginButton = Session.getSession().getBrowser().findElement(By.id("login2"));
        cartButton = Session.getSession().getBrowser().findElement(By.id("cartur"));

    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import session.Session;

public class LoginPage {
    public WebElement userName;
    public WebElement userPassword;
    public WebElement loginBtn;

    public LoginPage(){
        userName = Session.getSession().getBrowser().findElement(By.id("loginusername"));
        userPassword = Session.getSession().getBrowser().findElement(By.id("loginpassword"));
        loginBtn = Session.getSession().getBrowser().findElement(By.xpath("//button[contains(text(),'Log in')]"));
    }


}

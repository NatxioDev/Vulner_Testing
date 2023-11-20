package testSuite;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;


import pages.MainPage;
import session.Session;

import java.time.Duration;

public class LoginTest {
    String user = "testMod4";
    String password = "1234";

    @BeforeEach
    public void openBrowser(){
        Session.getSession().getBrowser().get("https://www.demoblaze.com");
    }

    @Test
    @Order(1)
    public void verifyLogin() throws InterruptedException {
        MainPage mainPage = new MainPage();
        mainPage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(Session.getSession().getBrowser(), Duration.ofSeconds(20));

        LoginPage loginPage = new LoginPage();
        wait.until(ExpectedConditions.visibilityOf(loginPage.userName));
        loginPage.userName.sendKeys(user);
        loginPage.userPassword.sendKeys(password);
        loginPage.loginBtn.click();

        MainPage mainPage1 = new MainPage();
        wait.until(ExpectedConditions.visibilityOf(mainPage1.cartButton));

        Assertions.assertTrue(mainPage1.cartButton.isDisplayed(),
                "ERROR> no se pudo iniciar sesion");
    }
    @AfterEach
    public void closeBrowser(){
        Session.getSession().getBrowser().quit();
    }

}

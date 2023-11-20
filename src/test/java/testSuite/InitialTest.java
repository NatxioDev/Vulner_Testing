package testSuite;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class InitialTest {

    String user = "testMod4";
    String password = "1234";

    
    WebDriver chrome;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver");
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:9092");
        proxy.setSslProxy("127.0.0.1:9092");


        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("ignore-certificate-errors");

        Map<String,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);

        chromeOptions.setExperimentalOption("prefs",prefs);
        chromeOptions.setProxy(proxy);

        chrome = new ChromeDriver(chromeOptions);
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://www.demoblaze.com");

    }


    public void verifyLogin() throws InterruptedException {

        chrome.findElement(By.id("login2")).click();
        Thread.sleep(2000);
        chrome.findElement(By.id("loginusername")).sendKeys(user);
        chrome.findElement(By.id("loginpassword")).sendKeys(password);
        chrome.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Thread.sleep(7000);
        Assertions.assertTrue(chrome.findElement(By.id("logout2")).isDisplayed(),
                "ERROR> no se pudo iniciar sesion");



    }

    @AfterEach
    public void tearDown() {
        chrome.quit();
    }

}

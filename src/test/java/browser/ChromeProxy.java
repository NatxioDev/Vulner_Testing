package browser;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class ChromeProxy {

    public WebDriver create(){
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

        WebDriver chrome = new ChromeDriver(chromeOptions);

        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        return chrome;

    }


}

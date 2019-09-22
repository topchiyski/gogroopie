package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class TestManager {

    private WebDriver webDriver;
    private static final String PATH_TO_CHROME_DRIVER = ".\\src\\main\\resources\\chromedriver.exe";

    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        int defaultImpliocitWaitInterval = 30;
        webDriver.manage().timeouts().implicitlyWait(defaultImpliocitWaitInterval, TimeUnit.SECONDS);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void navigate(String urlToBeNavigated) {
        webDriver.get(urlToBeNavigated);
    }

    public void closeBrowser() {
        webDriver.quit();
    }
}
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

    WebDriver webDriver;

    static final int FIVE_SECONDS = 5;
    private static final int TEN_SECONDS = 10;


    Page(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public boolean waitForElementToLoad(By locator, int timeOutInSeconds) {
        boolean result = true;
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (TimeoutException timeoutException) {
            result = false;
        }
        return result;
    }

    public boolean waitForElementToBeClickable(By locator, int timeOutInSeconds) throws InterruptedException {
        boolean result = true;
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            Thread.sleep(1000);
        }
        catch (TimeoutException timeoutException) {
            result = false;
        }
        return result;
    }

    public void click(By locator) throws InterruptedException {
        waitForElementToBeClickable(locator, TEN_SECONDS);
        webDriver.findElement(locator).click();
    }

    public boolean isElementDisplayed(final By locator) {
        return isElementPresented(locator) ? webDriver.findElement(locator).isDisplayed() : false;
    }

    private boolean isElementPresented(final By locator) {
        return !webDriver.findElements(locator).isEmpty();
    }
}

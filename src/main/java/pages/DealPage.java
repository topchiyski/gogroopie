package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DealPage extends Page {

    private static final By buyButton = By.cssSelector(".button-buy-deal-page");
    private static final By authenticationSection = By.cssSelector(".buy-auth-view");
    private static final By signInTab = By.cssSelector(".tabset-tab.ng-binding.ng-scope.login");
    private static final By newCustomerTab = By.cssSelector(".tabset-tab.ng-binding.ng-scope.register");
    private static final By signUpButton = By.xpath("//a//span[text()='Sign up']");
    private static final By keepMeSignedInOnThisDeviceLabel = By.xpath("//*[text()='Keep me signed in on this device']");

    public DealPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickBuyNowButton() throws InterruptedException {
        click(buyButton);
    }

    public boolean isAuthenticationSectionPresent() {
        return isElementDisplayed(authenticationSection);
    }

    public boolean isSignInTabPresent() {
        return isElementDisplayed(signInTab);
    }

    public boolean isNewCustomerTabPresent() {
        return isElementDisplayed(newCustomerTab);
    }

    public boolean isSignUpButtonPresent() {
        return isElementDisplayed(signUpButton);
    }

    public boolean iskeepMeSignedInOnThisDeviceLabelPresent() {
        return isElementDisplayed(keepMeSignedInOnThisDeviceLabel);
    }
}

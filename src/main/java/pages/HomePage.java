package pages;

import enums.NavigationTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.abstraction.Page;

public class HomePage extends Page {

    private static final By subscribeToGoGroopiePopUp = By.cssSelector(".modal-view-dialog.ng-isolate-scope.step-join-view");
    private static final By homePage = By.cssSelector(".home-page-top-content");
    private static final By subscribeToGoGroopiePopUpCloseButton = By.cssSelector("div.close");
    private static final By deals = By.cssSelector("img.deal-image");

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isSubscribeToGoGroopiePopUpDisplayed(int timeout) {
        return waitForElementToLoad(subscribeToGoGroopiePopUp, timeout);
    }

    public boolean isHomePageDisplayed(int timeout) {
        return waitForElementToLoad(homePage, timeout);
    }

    public void closeSubscribeToGoGroopiePopUp() throws InterruptedException {
        click(subscribeToGoGroopiePopUpCloseButton);
    }

    public void selectFirstDeal() throws InterruptedException {
        click(deals);
    }

    public void clickOnNavigationTab(NavigationTab desiredTab) throws InterruptedException {
        By tabLocator = By.xpath("//span[text()='" + desiredTab.toString() + "']");
        click(tabLocator);
        click(tabLocator); // to close the opened menu
    }
}

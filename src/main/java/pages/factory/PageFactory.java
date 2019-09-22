package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.DealPage;
import pages.HomePage;
import pages.ProductPage;
import pages.abstraction.Page;

public class PageFactory {
    public static Page getPage(PageType pageType, WebDriver webDriver) {
        switch (pageType) {
            case HOME:
                return new HomePage(webDriver);
            case DEAL:
                return new DealPage(webDriver);
            case PRODUCT:
                return new ProductPage(webDriver);
            default:
                return null;
        }
    }
}

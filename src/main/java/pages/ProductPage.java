package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

    private static final By dropDownSelectionTitle = By.cssSelector("div.dropdown-selection-title");
    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getValueOfSortByDropdown() {
        waitForElementToLoad(dropDownSelectionTitle, FIVE_SECONDS);
        return webDriver.findElement(dropDownSelectionTitle).getText();
    }
}

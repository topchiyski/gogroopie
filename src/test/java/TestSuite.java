import enums.NavigationTab;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DealPage;
import pages.HomePage;
import pages.ProductPage;
import pages.factory.PageFactory;
import pages.factory.PageType;
import utils.TestManager;

public class TestSuite {

    private TestManager testManager = new TestManager();
    private static final String BASE_ADDRESS = "https://www.gogroopie.com/";
    private static final int ONE_SECOND = 1;
    private static final int FIVE_SECONDS = 5;

    @Test
    public void homePageReachable() {
        HomePage homePage = (HomePage) PageFactory.getPage(PageType.HOME,testManager.getWebDriver());
        Assert.assertTrue("Home Page is not displayed", homePage.isHomePageDisplayed(FIVE_SECONDS));
        Assert.assertTrue("Subscribe to GoGroopie pop up is missing", homePage.isSubscribeToGoGroopiePopUpDisplayed(ONE_SECOND));
        Assert.assertEquals(BASE_ADDRESS, homePage.getCurrentUrl());
        String expectedPageTitle = "GoGroopie Feel Good Deals";
        Assert.assertEquals(expectedPageTitle, homePage.getPageTitle());
    }

    @Test
    public void signInPageReachableThroughBuyPage() throws InterruptedException {
        HomePage homePage = (HomePage) PageFactory.getPage(PageType.HOME,testManager.getWebDriver());
        homePage.closeSubscribeToGoGroopiePopUp();
        homePage.selectFirstDeal();
        DealPage dealPage = (DealPage) PageFactory.getPage(PageType.DEAL, testManager.getWebDriver());
        dealPage.clickBuyNowButton();
        Assert.assertTrue("URL does not contains /buy/", dealPage.getCurrentUrl().contains(BASE_ADDRESS + "buy/"));
        Assert.assertTrue("Authentication section is not present", dealPage.isAuthenticationSectionPresent());
        Assert.assertTrue("New Customer tab is not present", dealPage.isNewCustomerTabPresent());
        Assert.assertTrue("Sign in tab is not present", dealPage.isSignInTabPresent());
        Assert.assertTrue("Sign up button is not present", dealPage.isSignUpButtonPresent());
        Assert.assertTrue("Keep me signed in on this device label is missing", dealPage.iskeepMeSignedInOnThisDeviceLabelPresent());
    }

    @Test
    public void verifyDefaultValueIsSelectedOnProductPage() throws InterruptedException {
        HomePage homePage = (HomePage) PageFactory.getPage(PageType.HOME,testManager.getWebDriver());
        homePage.closeSubscribeToGoGroopiePopUp();
        homePage.clickOnNavigationTab(NavigationTab.PRODUCTS);
        ProductPage productPage = (ProductPage) PageFactory.getPage(PageType.PRODUCT, testManager.getWebDriver());
        String actualSortByDefaultValue = productPage.getValueOfSortByDropdown();
        String expectedSortByDefaultValue = "Selected";
        Assert.assertEquals(expectedSortByDefaultValue, actualSortByDefaultValue);
    }

    @Before
    public void startTest() {
        testManager.startBrowser();
        testManager.navigate(BASE_ADDRESS);
    }

    @After
    public void endTest() {
        testManager.closeBrowser();
    }
}

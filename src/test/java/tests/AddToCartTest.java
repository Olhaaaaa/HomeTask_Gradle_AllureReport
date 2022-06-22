package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import util.AllureListener;
import util.DriverFactoryMultiton;

import java.time.Duration;
@Listeners({AllureListener.class})
@Epic("Regression Tests")
@Feature("Add to cart Test")
public class AddToCartTest extends BaseTest {
    private static final Logger log = Logger.getLogger(AddToCartTest.class);
    WebDriver driver = DriverFactoryMultiton.getInstance().getDriver();


    @Test(suiteName = "AddToCartTestSuite")
    @Parameters({"search", "brand", "price"})
    @Description("Method Description: Check total price in cart")
    @Severity(value = SeverityLevel.CRITICAL)
    public void checkTotalPriceInCart(String searchKeyword, String brandKeyword, String totalPrice) throws InterruptedException {
        log.debug("Test successfully started");
        Reporter.log("Test successfully started");
        HomePage homePage = new HomePage();
        homePage.waitVisibilityOfElement(Duration.ofSeconds(30), homePage.getSearchByKeyword());
        homePage.searchByKeyword(searchKeyword);
        homePage.clickSearchButton();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.waitForPageLoadComplete(Duration.ofSeconds(30));
        searchResultsPage.searchByBrand(brandKeyword);
        searchResultsPage.clickOnBrandButton();
        searchResultsPage.clickOnFilterButton();
        searchResultsPage.clickOnExpensiveFilterButton();
        searchResultsPage.waitForPageLoadComplete(Duration.ofSeconds(30));
        searchResultsPage.clickOnProductButton();
        ProductPage productPage = new ProductPage();
        productPage.waitForPageLoadComplete(Duration.ofSeconds(30));
        productPage.clickOnAddToCartButton();
        productPage.checkPopUp();
        productPage.waitForPageLoadComplete(Duration.ofSeconds(30));
        Assert.assertFalse(productPage.getTotalPriceText(), totalPrice);
    }

    @Test(suiteName = "FailedTestsSuite")
    public void simpleFailedTest(){
        Assert.fail();
    }
}
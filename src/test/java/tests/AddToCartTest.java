package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultsPage;
import util.DriverFactoryMultiton;

import java.time.Duration;

@Listeners
public class AddToCartTest extends BaseTest {

    WebDriver driver = DriverFactoryMultiton.getInstance().getDriver();

    @Parameters({"search", "brand", "price"})
    @Test(suiteName = "AddToCartTestSuite")
    public void checkTotalPriceInCart(String searchKeyword, String brandKeyword, String totalPrice) throws InterruptedException {
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
}
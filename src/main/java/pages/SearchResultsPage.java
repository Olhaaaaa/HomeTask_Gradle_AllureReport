package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import util.DriverFactoryMultiton;

import java.time.Duration;


public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//select[contains(@class,'select-css')]")
    private WebElement filterButton;

    @FindBy(xpath = "//option[contains(@value,'expensive')]")
    private WebElement filterExpensiveButton;

    @FindBy(xpath = "//a[contains(@class,'tile__heading')]")
    private WebElement productButton;

    @FindBy(xpath = "//div[@data-filter-name='producer']//input[contains(@class,'sidebar-search__input')]")
    private WebElement searchBrand;

    @FindBy(xpath = "//div[@data-filter-name='producer']//a[contains(@href,'producer')]")
    private WebElement brandButton;

    @FindBy(xpath = "//a[contains(@class,'tile__heading')]")
    private WebElement productButtonVisible;

    @FindBy(xpath = "//div[@data-filter-name='producer']//input[contains(@class,'sidebar-search__input')]")
    private WebElement searchBrandVisible;

    @FindBy(xpath = "//ul[@class='checkbox-filter'][count(p)=1]")
    private WebElement brandButtonVisible;

    Actions actions = new Actions(DriverFactoryMultiton.getInstance().getDriver());

    public SearchResultsPage() {
        super(DriverFactoryMultiton.getInstance().getDriver());
    }

    public void searchByBrand(String brand) throws InterruptedException {
//        waitVisibilityOfElement(Duration.ofSeconds(30), searchBrandVisible);
        Thread.sleep(2000);
        actions.moveToElement(searchBrand).perform();
        searchBrand.sendKeys(brand);
    }

    public void clickOnBrandButton() throws InterruptedException {
        Thread.sleep(2000);
        actions.moveToElement(brandButton).perform();
        brandButton.click();
    }

    public void clickOnFilterButton() {
        waitVisibilityOfElement(Duration.ofSeconds(30), filterButton);
        filterButton.click();
    }

    public void clickOnExpensiveFilterButton() {
        filterExpensiveButton.click();
    }

    public void clickOnProductButton() {
//        waitVisibilityOfElement(30, productButton);
        actions.moveToElement(productButton).perform();
        productButton.click();
    }
}

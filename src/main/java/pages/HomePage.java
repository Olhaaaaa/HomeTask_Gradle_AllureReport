package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.DriverFactoryMultiton;


public class HomePage extends BasePage {

    @FindBy(xpath = "//input[contains(@class,'search-form')]")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(@class,'submit')]")
    private WebElement searchButton;

    public HomePage() {
        super(DriverFactoryMultiton.getInstance().getDriver());
    }

    public WebElement getSearchByKeyword() {
        return searchInput;
    }

    public void searchByKeyword(String keyword) {
        searchInput.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
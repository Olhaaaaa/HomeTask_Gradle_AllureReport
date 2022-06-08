package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import util.DriverFactoryMultiton;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//li[contains(@class,'buttons__item ng')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//rz-cart//button[@opencart]")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='modal__content']")
    private WebElement popUpContent;

    @FindBy(xpath = "//button[@class='modal__close']")
    private WebElement popUpClose;

    @FindBy(xpath = "//li[contains(@class,'buttons__item ng')]")
    private WebElement totalPrice;

    Actions actions = new Actions(DriverFactoryMultiton.getInstance().getDriver());

    public ProductPage() {
        super(DriverFactoryMultiton.getInstance().getDriver());
    }

    public void clickOnAddToCartButton() {
        actions.moveToElement(addToCartButton).perform();
        addToCartButton.click();
    }

    public boolean getTotalPriceText() {
        totalPrice.getText();
        return false;
    }

    public void checkPopUp() {
        if (popUpContent.isDisplayed()) {
            popUpClose.click();
            cartButton.click();
        } else {
            cartButton.click();
        }
    }

}
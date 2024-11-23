package pl.coderslab.myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HumigBirdSweaterPage {
    private final WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement sizeSelector;

    @FindBy (id = "quantity_wanted")
    private WebElement quantitySelector;

    @FindBy (className = "add-to-cart")
    private WebElement addToCartBtn;

    @FindBy (css = "#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a")
    private WebElement proceedToCheckOutLink;

    @FindBy (id = "product-availability")
    private WebElement productAvailability;


    public HumigBirdSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectSize(String size){
        Select dropDownMenu = new Select(sizeSelector);
        dropDownMenu.selectByVisibleText(size);


    }

    public void quantityWanted(String quantity){
        quantitySelector.clear();
        quantitySelector.sendKeys(Keys.BACK_SPACE, quantity);
    }

    public void selectAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();


    }

    public void proceedToCheckOut(){
        proceedToCheckOutLink.click();
    }
}

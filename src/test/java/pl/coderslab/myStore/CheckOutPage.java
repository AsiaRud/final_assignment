package pl.coderslab.myStore;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckOutPage {
    private final WebDriver driver;

    @FindBy(className = "address")
    private List<WebElement> addressesTiles;

    @FindBy(className = "address")
    private WebElement myAddress;

    @FindBy(name = "confirm-addresses")
    private WebElement continueBtn;

    @FindBy (xpath = "//*[contains(text(), 'Pick up in-store')]")
    private WebElement pickUpInStore;

    @FindBy (name = "confirmDeliveryOption")
    private WebElement confirmDeliverBtn;

    @FindBy (xpath = "//*[contains(text(), 'Pay by Check')]")
    private WebElement payByCheck;

    @FindBy (id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfServiceCheckBox;

    @FindBy (xpath = "//*[contains(text(), 'Place order')]")
    private WebElement placeOrderBtn;



    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void checkAndSelectAddress(String firstName, String lastName, String address, String city, String postCode, String country) {
        boolean success = false;
        for (WebElement addressTile : addressesTiles) {
            String addressText = addressTile.getText();
            success = addressText.contains(firstName)
                    && addressText.contains(lastName)
                    && addressText.contains(address)
                    && addressText.contains(city)
                    && addressText.contains(postCode)
                    && addressText.contains(country);
            if (success) {
                addressTile.click();
                break;
            }
        }
        Assertions.assertTrue(success);
        continueBtn.click();
    }

    public void setPickUpInStore(){
        pickUpInStore.click();
        confirmDeliverBtn.click();

    }

    public void selectPaymentByCheck(){
        payByCheck.click();
    }

    public void agreeToTheTermsOfService(){
        termsOfServiceCheckBox.click();
    }

    public void placeOrder(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));
        placeOrderBtn.click();
    }


}

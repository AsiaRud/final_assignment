package pl.coderslab.myStore;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesPage {
    private final WebDriver driver;

    @FindBy(className = "address")
    private WebElement existingAddress;

    @FindBy(className = "address")
    private List<WebElement> allAddresses;

    @FindBy(css = "[data-link-action='add-address']")
    private WebElement createNewAddressLink;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void hasAddresses() {
        Assertions.assertNotEquals(existingAddress, null);
    }

    public void createNewAddress(){
        createNewAddressLink.click();
    }

    public void checkAddress(String alias, String firstName, String lastName, String address, String city, String postCode, String country, String phone){
        boolean success=false;
        for (WebElement addressTile:allAddresses){
            String addressText = addressTile.getText();
            success = addressText.contains(alias)
                    && addressText.contains(firstName)
                    && addressText.contains(lastName)
                    && addressText.contains(address)
                    && addressText.contains(city)
                    && addressText.contains(postCode)
                    && addressText.contains(country)
                    && addressText.contains(phone);
            if (success) {
                break;
            }
        }
        Assertions.assertTrue(success);

    }
}


//List<WebElement> controls = driver.findElements(by.className("form-control"));

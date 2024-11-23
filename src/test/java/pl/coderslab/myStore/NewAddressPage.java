package pl.coderslab.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {
    private final WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-firstname")
    private WebElement firstNameInput;

    @FindBy(id = "field-lastname")
    private WebElement lasttNameInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement postCodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countrySelect;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(className = "form-control-submit")
    private WebElement submitNewAddress;


    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void fillInNewAddress(String alias, String firstName, String lastName, String address, String city, String postCode, String country, String phone) {
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lasttNameInput.clear();
        lasttNameInput.sendKeys(lastName);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);

        Select dropDown = new Select(countrySelect);
        dropDown.selectByVisibleText(country);

        phoneInput.clear();
        phoneInput.sendKeys(phone);

        submitNewAddress.click();

    }
}




















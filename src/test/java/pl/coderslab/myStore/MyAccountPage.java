package pl.coderslab.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private final WebDriver driver;

    @FindBy(id = "addresses-link")
    private WebElement addressesLink;



    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToAddresses(){
        addressesLink.click();
    }
}

package pl.coderslab.myStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private final WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement loginEmailInput;

    @FindBy(id = "field-password")
    private WebElement loginPasswdInput;

    @FindBy(id = "submit-login")
    private WebElement signInBtn;

    @FindBy(id = "_desktop_logo")
    private WebElement navigateToManePageLink;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void signInAs(String email, String passwd){
        loginEmailInput.clear();
        loginEmailInput.sendKeys(email);

        loginPasswdInput.clear();
        loginPasswdInput.sendKeys(passwd);

        signInBtn.click();
    }

    public void goToManePage(){
        navigateToManePageLink.click();
    }
}

package pl.coderslab.myStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.xpath;

public class MainPage {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id='_desktop_user_info']/div/a")
    private WebElement signInLink;

    @FindBy(css = "#content > section > div > div:nth-child(2) > article > div > div.thumbnail-top > a")
    private WebElement selectProduktLink;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToSignIn() {
        signInLink.click();
    }

    public void selectProduct(){
        selectProduktLink.click();
    }
}
package pl.coderslab.myStore;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.io.File;
import java.io.IOException;

public class OrderConfirmationPage {
    private final WebDriver driver;


    @FindBy (id = "content")
    private WebElement orderDetails;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void takeOrderDetailsScreenShot() {
        File sweetFocia = orderDetails.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(sweetFocia, new File("sweet_focia.png"));
        } catch(IOException exception) {
            System.out.println("Couldn't write screenshot:" + exception );
        }
    }
}

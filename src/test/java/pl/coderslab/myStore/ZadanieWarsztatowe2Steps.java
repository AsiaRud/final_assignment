package pl.coderslab.myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class ZadanieWarsztatowe2Steps {
    private WebDriver driver;

    @Given("I am on sign in page")
    public void imOnSignInPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");


    }

    @And("I log in to my account")
    public void iLogInToMyAccount() {
        SignInPage signIn = new SignInPage(driver);
        signIn.signInAs("pssfeocumhtzzcgmgz@hthlm.com", "dupa123");
    }

    @When("I navigate to my store main page")
    public void iNavigateToMyStoreMainPage() {
        SignInPage goToMainPage = new SignInPage(driver);
        goToMainPage.goToManePage();
    }

    @And("I choose Hummingbird Printed Sweater")
    public void selectHumingbirdSweater() {
        MainPage selectMainPageProduct = new MainPage(driver);
        selectMainPageProduct.selectProduct();

    }

    @And("I select size {word}")
    public void iSelectSize(String size) {
        HumigBirdSweaterPage mySize = new HumigBirdSweaterPage(driver);
        mySize.selectSize(size);

    }

    @And("I set quantity {word}")
    public void iSetQuantityTo(String quantity) {
        HumigBirdSweaterPage selectQuantity = new HumigBirdSweaterPage(driver);
        selectQuantity.quantityWanted(quantity);
    }


    @And("I add to cart")
    public void iAddToCart() {
        HumigBirdSweaterPage addToCart = new HumigBirdSweaterPage(driver);
        addToCart.selectAddToCart();
    }

    @And("I navigate to checkout")
    public void iNavigateToCheckout() {
        HumigBirdSweaterPage goToCheckOutTile = new HumigBirdSweaterPage(driver);
        goToCheckOutTile.proceedToCheckOut();

        ShoppingCartPage goToCheckOut = new ShoppingCartPage(driver);
        goToCheckOut.checkOut();

    }

    @And("I confirm and select address")
    public void iConfirmAndSelectAddress() {
        CheckOutPage confirmAddress = new CheckOutPage(driver);
        confirmAddress.checkAndSelectAddress("Sara", "Mara", "Kąkolska", "Pcim", "22-222", "United Kingdom");

    }

    @And("I select delivery option")
    public void iSelectDeliveryOption() {
        CheckOutPage delivery = new CheckOutPage(driver);
        delivery.setPickUpInStore();

    }

    @And("I select payment method")
    public void iSelectPaymentMethod() {
        CheckOutPage paymentMethode = new CheckOutPage(driver);
        paymentMethode.selectPaymentByCheck();

    }

    @And("I place my order")
    public void iPlaceMyOrder() {
        CheckOutPage checkOut = new CheckOutPage(driver);
        checkOut.agreeToTheTermsOfService();
        checkOut.placeOrder();
    }

    @And("I take a screenshot of my order")
    public void iTakeAScreenshotOfMyOrder() {
        OrderConfirmationPage screenShot = new OrderConfirmationPage(driver);
        screenShot.takeOrderDetailsScreenShot();


    }

    @Then("I will close the browser")
    public void iWillCloseTheBrowser() {
            driver.quit();
    }
}

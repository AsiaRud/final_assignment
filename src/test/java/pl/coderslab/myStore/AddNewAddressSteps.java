package pl.coderslab.myStore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddNewAddressSteps {
    private WebDriver driver;

    @Given("I am on My Store main page")
    public void imOnMyStoreMainPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I navigate to log in page")
    public void navigateToLogIn() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToSignIn();

    }

    @And("I log in")
    public void iLogIn() {
        SignInPage signIn = new SignInPage(driver);
        signIn.signInAs("pssfeocumhtzzcgmgz@hthlm.com", "dupa123");
    }

    @And("I navigate to Addresses")
    public void iNavigateToAddresses() {
        MyAccountPage myAccount = new MyAccountPage(driver);
        myAccount.goToAddresses();
    }

    @And("I can see existing addresses")
    public void iCanSeeExistingAddresses() {
        AddressesPage existingAddresses = new AddressesPage(driver);
        existingAddresses.hasAddresses();
    }

    @And("I navigate to create new address")
    public void iNavigateToCreateNewAddress() {
        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.createNewAddress();
    }

    @And("I enter alias {word} first name {word} last name {word} address {word} city {word} post code {word} country {string} phone {word}")
    public void iFillInAddressForm(String alias, String firstName, String lastName, String address, String city, String postCode, String country,String phone) {
        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillInNewAddress(alias, firstName, lastName, address, city, postCode, country, phone);
    }


    @Then("I can see added alias {word} first name {word} last name {word} address {word} city {word} post code {word} country {string} phone {word}")
    public void addressCheck(String alias, String firstName, String lastName, String address, String city, String postCode, String country,String phone) {
        AddressesPage addressesPageCheck = new AddressesPage(driver);
        addressesPageCheck.checkAddress(alias, firstName, lastName, address, city, postCode, country, phone);

    }


    @And("I close the browser")
    public void iCloseTheBrowser() {
            driver.quit();
    }
}

















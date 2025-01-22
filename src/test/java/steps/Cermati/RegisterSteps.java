package steps.Cermati;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pageobject.cermati.RegisterPO;
import utilities.ThreadManager;

public class RegisterSteps {

    private static final Logger log = LoggerFactory.getLogger(RegisterSteps.class);
    private WebDriver driver = ThreadManager.getDriver();
    private RegisterPO register = new RegisterPO(driver);


    @When("user input mobilePhone {string}")
    public void user_input_mobile_phone(String phone) {
        register.enterMobilePhone(phone);
    }

    @When("user input email {string}")
    public void user_input_email(String email) {
        register.enterEmail(email);
    }

    @When("input First Name {string}")
    public void input_first_name(String firstName) {
        register.enterFirstName(firstName);
    }

    @When("input Last Name {string}")
    public void input_last_name(String lastName) {
        register.enterLastName(lastName);
    }

    @When("users click on Daftar button")
    public void users_click_on_daftar_button() throws InterruptedException {
        register.clickOnRegisterButton();
    }

    @Then("system display OTP Page")
    public void system_display_otp_page() {
        Assert.assertTrue(register.isOtpPageDisplayed(),"OTP Page not displayed after registration.");
    }

}

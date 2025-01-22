package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

public class CommonSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user access page {string}")
    public void user_access_page(String url) {
        selenium.navigateToPage(url);
    }

    @Then("compare current url with {string}")
    public void compare_url(String url){
        Assert.assertEquals(url, selenium.getURL());
   }
}
package pageobject.cermati;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class RegisterPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
        this.selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(xpath = "//input[@id='mobilePhone']")
    private WebElement MobilePhoneEditText;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement EmailEditText;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement FirstNameEditText;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement LastNameEditText;

    @FindBy(xpath = "//button[normalize-space()='Daftar']")
    private WebElement RegisterButton;

    @FindBy(xpath = "//h2[normalize-space()='Kode OTP Terkirim']")
    private WebElement OtpPage;

    /**
     * Enter MobilePhone
     * @param mobilePhone
     */
    public void enterMobilePhone(String mobilePhone) {
        selenium.enterText(MobilePhoneEditText, mobilePhone, true);
    }

    /**
     * Enter email
     * @param email
     */
    public void enterEmail(String email) {
        selenium.enterText(EmailEditText, email, true);
    }

    /**
     * Enter First Name
     * @param firstName
     */
    public void enterFirstName(String firstName) {
        selenium.enterText(FirstNameEditText, firstName, true);
    }

    /**
     * Enter Last Name
     * @param lastName
     */
    public void enterLastName(String lastName) {
        selenium.enterText(LastNameEditText, lastName, true);
    }

    /**
     * Click on register button
     * @throws InterruptedException
     */
    public void clickOnRegisterButton() throws InterruptedException {
        selenium.clickOn(RegisterButton);
    }

    /**
     * Is OTP Page Displayed
     * @return true if OTP Page visible
     */
    public boolean isOtpPageDisplayed() {
        return selenium.isElementAppeared(OtpPage);
    }
}

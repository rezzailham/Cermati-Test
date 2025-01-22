package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelpers {
    int webDriverDuration = 60;
    WebDriver driver;
    Actions actions;

    public SeleniumHelpers(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    /**
     * Open url
     * @url Website main page
     */
    public void navigateToPage(String url) {
        driver.get(url);
    }

    /**
     * o wait until element is visible
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsVisible(WebElement e)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(e));
        return e;
    }

    /**
     * To wait until element is clickable
     * @param e WebElement object
     * @return WebElement object
     */
    public WebElement waitTillElementIsClickable(WebElement e) {
        //WebDriverWait wait = new WebDriverWait(driver, webDriverDuration);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverDuration));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }

    /**
     * This function will wait for page to load (waiting for java script to finish loading) before moving further
     * @throws InterruptedException
     * @paramWaitTime Maximum time is the time out time. if the page loading completes before timeout, code will process
     */
    public void waitForJavascriptToLoad() throws InterruptedException {
        Thread.sleep(1000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(webDriverDuration));
        try {
            wait.until(expectation);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    /**
     * Enter text to input field
     * @param e     WebElement object
     * @param text  input text
     * @param clear set true if want to clear field else set false
     */
    public void enterText(WebElement e, String text, boolean clear) {
        e = waitTillElementIsClickable(e);
        if (clear) {
            e.clear();
        }
        e.sendKeys(text);
    }

    /**
     * Click on Element
     * @param e WebElement object
     * @throws InterruptedException
     */
    public void clickOn(WebElement e) throws InterruptedException {
        waitTillElementIsClickable(e).click();
        waitForJavascriptToLoad();
    }

    /**
     * Click on Element
     * @param e WebElement object
     * @throws InterruptedException
     */
    public void click(WebElement e) throws InterruptedException {
        e.click();
        waitForJavascriptToLoad();
    }

    /**
     * Verify element is displayed
     *
     * @param el WebElement object
     * @return boolean
     */
    public Boolean isElementAppeared(WebElement el) {
        try {
            el.isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get Current URL
     */
    public String getURL() {
        return driver.getCurrentUrl();
    }

    /**
     * Get Text from field
     * @param e WebElement object
     * @return text from field
     */
    public String getText(WebElement e)
    {
        return waitTillElementIsVisible(e).getText().trim();
    }
}

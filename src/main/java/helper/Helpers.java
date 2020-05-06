package helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Helpers {
    private static Helpers HELPER_INSTANCE;

    private WebDriver driver;
    private WebDriverWait driverWait;
    private Actions actions;

    private Helpers() {
        configuration();
    }

    public static Helpers get() {
        if (HELPER_INSTANCE == null)
            HELPER_INSTANCE = new Helpers();
        return HELPER_INSTANCE;
    }

    public String getFilePathFromResources(String relativePath) {
        try {
            if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
                return URLDecoder.decode(getClass().getResource("/" + relativePath).getPath(), "UTF-8").replaceFirst("/", "");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public void configuration() {
        String resourcesDrivesPath = "drives/%s";
        if (System.getProperty("os.name").toUpperCase().contains("WINDOWS")) {
            System.setProperty("webdriver.chrome.driver", getFilePathFromResources(String.format(resourcesDrivesPath, "chromedriver.exe")));
        }
        finish();
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
    }

    public void openPath(String path) {
        driver.get(path);
    }

    /* Basic Functions */

    public boolean checkElementXPathIfExist(String elementXpath) {
        try {
            driver.findElement(By.xpath(elementXpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement waitElementXPathPresence(String elementXpath) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        return driver.findElement(By.xpath(elementXpath));
    }

    public WebElement waitElementXPath(String elementXpath) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return driver.findElement(By.xpath(elementXpath));
    }

    public void mouseHover(String elementXpath) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        actions.moveToElement(waitElementXPath(elementXpath)).build().perform();
    }

    public void finish() {
        if (driver != null) {
            driver.quit();
        }
    }

    /* Access Functions */

    public void clickAndWait(String elementXpath) {
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        waitElementXPath(elementXpath).click();
    }

    public void waitAndSendKeys(String elementXpath, String text, int timerAfter) {
        waitElementXPath(elementXpath).sendKeys(text);
    }

    /* Assertions Functions */

    public void elementMatchText(String expectedMsg, String elementXpath) {
        driverWait.until(ExpectedConditions.textToBe(By.xpath(elementXpath), expectedMsg));
        Assert.assertEquals(expectedMsg, waitElementXPath(elementXpath).getText());
    }

    public void elementMatchAttribute(String expectedMsg, String actualMsg) {
        elementMatchAttribute(expectedMsg, actualMsg, "src");
    }

    public void elementMatchAttribute(String expectedMsg, String actualMsg, String fieldLocted) {
        Assert.assertEquals(expectedMsg, waitElementXPath(actualMsg).getAttribute(fieldLocted));
    }

    public void elementMatchCssValue(String expectedMsg, String actualMsg, String elementValue) {
        Assert.assertEquals(expectedMsg, waitElementXPath(actualMsg).getCssValue(elementValue));
    }

    public void waitElementComboBox(String valueComboBox, String elementXpath) {
        Select combo = new Select(waitElementXPath(elementXpath));
        combo.selectByVisibleText(valueComboBox);
    }
}


package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import runner.ConfigurationDriver;

public abstract class BasePage {

    private ConfigurationDriver configDriver;

    public BasePage(ConfigurationDriver configDriver) {
        this.configDriver = configDriver;
    }

    protected WebElement presentedById(String elementId) {
        this.configDriver.driverWait().until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
        return this.configDriver.driver().findElement(By.id(elementId));
    }

    protected WebElement presentedByXPath(String elementXpath) {
        this.configDriver.driverWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
        return this.configDriver.driver().findElement(By.xpath(elementXpath));
    }

    protected WebElement locatedByXPath(String elementXpath) {
        this.configDriver.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        return this.configDriver.driver().findElement(By.xpath(elementXpath));
    }

    protected WebElement locatedById(String elementId) {
        this.configDriver.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
        return this.configDriver.driver().findElement(By.id(elementId));
    }

    protected void clickById(String elementId) {
        locatedById(elementId).click();
    }

    protected void clickByXPath(String elementXPath) {
        locatedByXPath(elementXPath).click();
    }

    protected void containsText(String elementXPath, String text) {
        if (!locatedByXPath(elementXPath).getText().contains(text)) {
            throw new Error("Error ocurred, because the text not located");
        }
    }

    protected void enterTextById (String elementId, String text) {
        locatedById(elementId).sendKeys(text);
    }

    protected void matchText(String elementXPath, String expectedText){
        this.configDriver.driverWait().until(ExpectedConditions.textToBe(By.xpath(elementXPath), expectedText));
        Assert.assertEquals(expectedText, locatedByXPath(elementXPath).getText());

    }

    protected void matchTextBYId(String elementId, String expectedText){
        this.configDriver.driverWait().until(ExpectedConditions.textToBe(By.id(elementId), expectedText));
        Assert.assertEquals(expectedText, locatedById(elementId).getText());

    }

    public void matchAttribute(String elementId, String expectedText, String fieldLocted) {
        Assert.assertEquals(expectedText, locatedById(elementId).getAttribute(fieldLocted));
    }

    public void matchAttributeByXPath (String elementXPath, String expectedText, String fieldLocted) {
        Assert.assertEquals(expectedText, locatedByXPath(elementXPath).getAttribute(fieldLocted));
    }
}


package pages;

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
        return this.configDriver.driver().findElement(By.xpath(elementId));
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
}


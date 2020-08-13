package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ConfigurationDriver {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public ConfigurationDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drives/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driverWait = new WebDriverWait(driver, 5);
    }

    public void openURL(String url) {
        this.driver.get(url);
    }

    public void finish() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }

    public WebDriver driver() {
        return this.driver;
    }

    public WebDriverWait driverWait() {
        return this.driverWait;
    }
}

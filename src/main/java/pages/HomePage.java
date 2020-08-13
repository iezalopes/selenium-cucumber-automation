package pages;

import elements.HomeElements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.ConfigurationDriver;

public class HomePage extends BasePage {

    public HomePage(ConfigurationDriver configDriver) {
        super(configDriver);
    }

    public void validateHomeElements(){
        presentedByXPath(HomeElements.SMARTPHONES_CATEGORY);
        presentedByXPath(HomeElements.TVS_CATEGORY);
        presentedByXPath(HomeElements.COMPUTING_CATEGORY);
        presentedByXPath(HomeElements.HOME_APPLIANCES_CATEGORY);
        presentedByXPath(HomeElements.GAMES_CATEGORY);
        presentedByXPath(HomeElements.BOOKS_CATEGORY);
        presentedByXPath(HomeElements.PERSONAL_CARES_CATEGORY);
        presentedByXPath(HomeElements.GIFT_VOUCHER_CATEGORY);
        presentedByXPath(HomeElements.DISCOUNT_BANNER);
        presentedByXPath(HomeElements.CASHBACK_BANNER);

    }
}

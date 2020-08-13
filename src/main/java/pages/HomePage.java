package pages;

import elements.ElementsLocator;
import runner.ConfigurationDriver;

public class HomePage extends BasePage {

    public HomePage(ConfigurationDriver configDriver) {
        super(configDriver);
    }

    public void validateHomeElements() {
        presentedByXPath(ElementsLocator.HOME_SMARTPHONES_CATEGORY);
        presentedByXPath(ElementsLocator.HOME_GIFT_VOUCHER_CATEGORY);
        presentedByXPath(ElementsLocator.HOME_DISCOUNT_BANNER);
        presentedByXPath(ElementsLocator.HOME_CASHBACK_BANNER);
    }
}

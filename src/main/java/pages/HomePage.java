package pages;

import elements.ElementsLocator;
import runner.ConfigurationDriver;

public class HomePage extends BasePage {

    public HomePage(ConfigurationDriver configDriver) {
        super(configDriver);
    }

    public void validateHomeScreen() {
        presentedByXPath(ElementsLocator.HOME_SMARTPHONES_CATEGORY);
        presentedByXPath(ElementsLocator.HOME_GIFT_VOUCHER_CATEGORY);
        presentedByXPath(ElementsLocator.HOME_DISCOUNT_BANNER);
        presentedByXPath(ElementsLocator.HOME_CASHBACK_BANNER);
        presentedById(ElementsLocator.SEARCHBAR);

    }

    public void validateClickOnCartIcon(){
        clickById(ElementsLocator.MINICART_ICON);
    }

    public void validateAlertEmptyCart(){
        presentedByXPath(ElementsLocator.HOME_ALERT_EMPTY_CART);
        matchText(ElementsLocator.HOME_ALERT_EMPTY_CART, "Seu carrinho está vazio");
    }

    public void validateTypesOnSearchbar(String product){
        enterTextById(ElementsLocator.SEARCHBAR, product);
    }

    public void validateClickOnSearchButton(){
        clickById(ElementsLocator.SEARCH_BTN);
    }
}

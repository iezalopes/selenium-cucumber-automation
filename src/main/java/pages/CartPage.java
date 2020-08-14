package pages;

import elements.ElementsLocator;
import runner.ConfigurationDriver;

public class CartPage extends BasePage{

    public CartPage(ConfigurationDriver configDriver) {
        super(configDriver);
    }

    public void validateProductOnCartPage(){
        presentedByXPath(ElementsLocator.CART_PRODUCT_FIELD);
        matchText(ElementsLocator.CART_TITLE, "Meu carrinho");
        containsText(ElementsLocator.CART_PRODUCT_ADDED, "Caneca");
    }
}

package pages;

import elements.ElementsLocator;
import runner.ConfigurationDriver;

public class ProductPage extends BasePage {

    public ProductPage(ConfigurationDriver configDriver){
        super(configDriver);
    }

    public void validateClickOnBuyButoon(){
        clickById(ElementsLocator.PRODUCT_BUY_BTN);
    }
}

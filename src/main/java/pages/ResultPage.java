package pages;

import elements.ElementsLocator;
import runner.ConfigurationDriver;

public class ResultPage extends BasePage {

    public ResultPage(ConfigurationDriver configDriver){
        super(configDriver);
    }

    public void validateWithoutResultScreen(){
        presentedByXPath(ElementsLocator.NO_RESULT_OPS_IMAGE);
        presentedByXPath(ElementsLocator.NO_RESULT_TEXT);
        matchText(ElementsLocator.NO_RESULT_TEXT, "Não encontramos nenhum resultado na sua busca.");
    }

    public void validateSearchResultScreen(String product){
        presentedByXPath(ElementsLocator.RESULT_FIRST_PRODUCT);
        matchAttribute(ElementsLocator.SEARCHBAR, product, "value");
        matchText(ElementsLocator.RESULT_PRODUCT_TITLE, product);
    }

    public void validateClickOnFirstResult(){
        clickByXPath(ElementsLocator.RESULT_FIRST_PRODUCT);
    }
}

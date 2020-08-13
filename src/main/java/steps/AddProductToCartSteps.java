package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import elements.BaseUrl;
import pages.HomePage;
import runner.ConfigurationDriver;

public class AddProductToCartSteps {

    private ConfigurationDriver configDriver;

    public AddProductToCartSteps() {
        this.configDriver = new ConfigurationDriver();
    }

    @Before
    public void before(){
        this.configDriver.openURL(BaseUrl.SITE_HOME);
    }

    @Given("user on the home page of the Submarino website")
    public void user_on_home() {
        new HomePage(this.configDriver)
                .validateHomeElements();
    }

    @After
    public void close() {
        this.configDriver.finish();
    }

    @Given("user searches for bottle")
    public void search_for_product() {
        System.out.println("deu certo");
    }
}

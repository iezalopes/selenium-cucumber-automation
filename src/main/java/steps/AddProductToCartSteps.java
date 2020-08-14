package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import elements.Properties;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.ResultPage;
import runner.ConfigurationDriver;

public class AddProductToCartSteps {

    private ConfigurationDriver configDriver;

    public AddProductToCartSteps() {
        this.configDriver = new ConfigurationDriver();
    }

    @Before
    public void before() {
        this.configDriver.openURL(Properties.SITE_HOME);
    }

    @Given("user on the home page of the Submarino website")
    public void user_on_home() {
        new HomePage(this.configDriver)
                .validateHomeScreen();
    }

    @When("user clicks on the cart icon")
    public void click_on_cart_icon() {
        new HomePage(this.configDriver)
                .validateClickOnCartIcon();
    }

    @When("user types {string} on the searchbar")
    public void types_on_searchbar(String product) {
        new HomePage(this.configDriver)
                .validateTypesOnSearchbar(product);
    }

    @When("tap on the first result")
    public void tap_first_result() {
        new ResultPage(this.configDriver)
                .validateClickOnFirstResult();
    }

    @And("click on search button")
    public void click_on_search_button() {
        new HomePage(this.configDriver)
                .validateClickOnSearchButton();
    }

    @And("click the buy button")
    public void clickTheBuyButton() {
        new ProductPage(configDriver)
                .validateClickOnBuyButoon();
    }

    @Then("the alert that the cart is empty is displayed")
    public void alert_cart_displayed() {
        new HomePage(this.configDriver)
                .validateAlertEmptyCart();
    }

    @Then("the screen with no results found is displayed")
    public void screen_without_results() {
        new ResultPage(this.configDriver)
                .validateWithoutResultScreen();
    }

    @Then("the screen with search results for {string} is displayed")
    public void theScreenWithSearchResultsForIsDisplayed(String product) {
        new ResultPage(this.configDriver)
                .validateSearchResultScreen(product);
    }

    @Then("the product was successfully added to the cart")
    public void theProductWasSuccessfullyAddedToTheCar() {
        new CartPage(configDriver)
                .validateProductOnCartPage();
    }

    @After
    public void close() {
        this.configDriver.finish();
    }



}

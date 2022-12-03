package AutomationFramework.stepDefinitionImpl;

import java.io.IOException;

import org.testng.Assert;

import AutomationFramework.TestComponent.BaseTest;
import AutomationFramework.pageobjects.CartPage;
import AutomationFramework.pageobjects.CheckOut;
import AutomationFramework.pageobjects.ConfirmationPage;
import AutomationFramework.pageobjects.LandingPage;
import AutomationFramework.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends BaseTest{
	public LandingPage LandingPage;
	public ProductCatalogue productCatalogue;
	public CartPage CartPage;
	public CheckOut checkout;
	public ConfirmationPage confirmationPage;
	@Given("I am in landing page")
	public void I_am_in_landing_page() throws IOException
	{
		LandingPage =LaunchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String USername, String password)
	{
		productCatalogue=LandingPage.loginApplication(USername, password);
	}
	
	@When("^I added the product (.+) to cart$")
	public void I_added_the_product_to_cart(String productName)
	{
		productCatalogue.addProductToCart(productName);
	}
	
	@When("^checkout the product (.+) and submit the order$")
	public void checkout_the_product_and_submit_the_order(String productName)
	{
		CartPage= productCatalogue.goToCart();
		Boolean match = CartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		checkout=CartPage.goToCheckOutPage();
		checkout.selectCountry("india");
		confirmationPage=checkout.submitOrder();
	}
	
	@Then("^success mesage \"([^\"]*)\" should be displayed on confirmation page$")
	public void Success_message_disaplyed(String string)
	{	
		Assert.assertTrue(confirmationPage.getConfirmMessage().equalsIgnoreCase(string));
		driver.close();
	}
	
	@Then("^Error message \\\"([^\\\"]*)\\\"should be disaplyed$")
	public void Error_message_displayed(String string)
	{
		Assert.assertEquals(string, landingPage.getLoginMessage());
		driver.close();
	}
}

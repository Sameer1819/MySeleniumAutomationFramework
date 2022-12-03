package AutomationFramework.Tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import AutomationFramework.TestComponent.BaseTest;
import AutomationFramework.TestComponent.Retry;
import AutomationFramework.pageobjects.CartPage;
import AutomationFramework.pageobjects.ProductCatalogue;

public class ErrorMessage extends BaseTest {
	@Test(groups={"ErrorHandling"}, retryAnalyzer=Retry.class)
	public void LoginErrorMessageValidation() throws IOException {
		landingPage.loginApplication("1819sameerag@gmail.com", "Sameer@1234");
		Assert.assertEquals("Incorrect email or password.", landingPage.getLoginMessage());

	}
	
	@Test(groups={"ErrorHandling"})
	public void ProductErrorMessageValidation() throws IOException {
		String EnteredProduct="ZARA COAT 3";
		ProductCatalogue productCatalogue=landingPage.loginApplication("1819sameerag@gmail.com", "Sameer@123");
		productCatalogue.addProductToCart(EnteredProduct);
		CartPage CartPage= productCatalogue.goToCart();
		Boolean match = CartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}

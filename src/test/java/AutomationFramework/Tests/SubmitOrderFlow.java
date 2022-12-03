package AutomationFramework.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import AutomationFramework.TestComponent.BaseTest;
import AutomationFramework.pageobjects.CartPage;
import AutomationFramework.pageobjects.CheckOut;
import AutomationFramework.pageobjects.ConfirmationPage;
import AutomationFramework.pageobjects.OrderPage;
import AutomationFramework.pageobjects.ProductCatalogue;

public class SubmitOrderFlow extends BaseTest{
	@Test(dataProvider="getData2", groups={"Purchase"})
	//@Test(groups={"Purchase"})
	public void SubmitOrder(HashMap<String, String> input) throws IOException {
		String CountryName="India";
		//String EnteredProduct="ADIDAS ORIGINAL";
		//Email="1819sameerag@gmail.com";
		//Password="Sameer@123";
		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"), input.get("password"));
		productCatalogue.addProductToCart(input.get("product"));
		CartPage CartPage= productCatalogue.goToCart();
		Boolean match = CartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOut checkout=CartPage.goToCheckOutPage();
		checkout.selectCountry(CountryName);
		ConfirmationPage confirmationPage=checkout.submitOrder();
		Assert.assertTrue(confirmationPage.getConfirmMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods= {"SubmitOrder"})
	public void OrderHistoryPage() {
		landingPage.loginApplication("1819sameerag@gmail.com", "Sameer@123");
		OrderPage order=landingPage.goToOrderPage();
		boolean match=order.VerifyOrder("ZARA COAT 3");
		Assert.assertTrue(match);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"1819sameerag@gmail.com","Sameer@123","ZARA COAT 3"}, {"1819sameerag@gmail.com", "Sameer@123","ADIDAS ORIGINAL"}};
		//return new Object[][] {{"1819sameerag@gmail.com","Sameer@123"}, {"sam2024@gmail.com", "Sameer@1819"}};
	}
	
	@DataProvider
	public Object[][] getData1()
	{
		HashMap<String, String> map= new HashMap<String, String>();
		map.put("email", "1819sameerag@gmail.com");
		map.put("password", "Sameer@123");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1= new HashMap<String, String>();
		map1.put("email", "sam2024@gmail.com");
		map1.put("password", "Sameer@1819");
		map1.put("product", "ADIDAS ORIGINAL");
		return new Object[][] {{map}, {map1}};
		
	}
	
	@DataProvider
	public Object[][] getData2() throws IOException
	{
		List<HashMap<String, String>> data = getDataFromJson(System.getProperty("user.dir")+"\\src\\test\\java\\AutomationFramework\\data\\SubmitOrderData.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}

}

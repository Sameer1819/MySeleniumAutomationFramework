package AutomationFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;
	@FindBy(css=".totalRow button")
	WebElement Countrydd;
	
	public Boolean VerifyProductDisplay(String EnteredProduct) {
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(EnteredProduct));
		return match;
	}
	
	public CheckOut goToCheckOutPage()
	{
		 Countrydd.click();
		 CheckOut checkout= new CheckOut(driver);
		 return checkout;
	}
	

}

package AutomationFramework.pageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AutomationFramework.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	public OrderPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> OrderList;
	
	public boolean VerifyOrder(String OrderedProduct)
	{
		WebElement OrderName= OrderList.stream().filter(product->product.getText().equalsIgnoreCase(OrderedProduct)).findFirst().orElse(null);
		boolean match= OrderName.getText().equalsIgnoreCase(OrderedProduct);
		return match;
	}

}
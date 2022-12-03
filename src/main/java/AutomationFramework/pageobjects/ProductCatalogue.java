package AutomationFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> ProductList;
	
	@FindBy(css=".ng-animating")
	WebElement TimerOverlay;
	
	By products=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector("button[class='btn w-10 rounded']");
	By AddedToCartSuccesssMessage=By.id("toast-container");
	
	public List<WebElement> getProductList() 
	{
		WaitForElementToAppear(products);
		return ProductList;
	}
	
	public WebElement getProductByName(String EnteredProduct)
	{
		WebElement ReqProduct= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(EnteredProduct)).findFirst().orElse(null);
		return ReqProduct;
	}
	
	public void addProductToCart(String EnteredProduct)
	{
		WebElement prod= getProductByName(EnteredProduct);
		prod.findElement(addToCart).click();
		WaitForElementToAppear(AddedToCartSuccesssMessage);
		WaitForElementToDisppear(TimerOverlay);
		
	}
	

}

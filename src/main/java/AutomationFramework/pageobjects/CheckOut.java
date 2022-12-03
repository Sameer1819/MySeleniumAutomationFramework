package AutomationFramework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponent.AbstractComponent;

public class CheckOut extends AbstractComponent{
	WebDriver driver;
	public CheckOut(WebDriver driver)
	{	
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement CountryField;
	
	By Countrydd=By.xpath("//button[@class='ta-item list-group-item ng-star-inserted'][2]");
	
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrderButton;
	
	
	public void selectCountry(String Country)
	{
	 Actions a = new Actions(driver);
	 a.sendKeys(CountryField, Country).build().perform();
	 WaitForElementToAppear(Countrydd);
	 driver.findElement(Countrydd).click();
	}
	
	public ConfirmationPage submitOrder()
	{
	 PlaceOrderButton.click();
	 ConfirmationPage confirm = new ConfirmationPage(driver);
	 return confirm;
	}
}

package AutomationFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AutomationFramework.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(id="userPassword")
	WebElement UserPassword;
	
	@FindBy(id="login")
	WebElement LoginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement LoginMessage;
	
	public ProductCatalogue loginApplication(String email, String password) 
	{
		UserEmail.sendKeys(email);
		UserPassword.sendKeys(password);
		LoginButton.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public  String getLoginMessage() 
	{
		WaitForWebElementToAppear(LoginMessage);
		String Message= LoginMessage.getText();
		return Message;
	}
	
	public void goTo() 
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

}

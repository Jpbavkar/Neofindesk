package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	@FindBy (xpath="(//button[text()='Login'])[1]")
	private WebElement login;
	
	@FindBy (xpath="//input[@name='userName']")
	private WebElement userId;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy (xpath="(//button[text()='Login'])[2]")
	private WebElement submit;
	
	

	public Homepage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void sendKeysToUserId()
	{
		userId.sendKeys("AP123");
	}
	
	public void sendKeysToPassword()
	{
		password.sendKeys("Ap@1234567");
	}
	
	public void clickOnSubmit()
	{
		submit.click();
	}
	
	
	
}

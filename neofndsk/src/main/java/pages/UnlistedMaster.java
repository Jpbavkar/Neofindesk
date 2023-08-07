package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnlistedMaster {

	@FindBy (xpath="//span[text()='Unlisted Master']")
	private WebElement unlistedMaster;
	
	@FindBy (xpath="//button[text()='Add Unlisted']")
	private WebElement addUnlisted;
	
	
	public UnlistedMaster (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnunlistedMaster()
	{
		unlistedMaster.click();
	}
	
	public void clickOnAddUnlistedMaster()
	{
		addUnlisted.click();
	}
	
	
	
	
	
}

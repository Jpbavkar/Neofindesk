package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BondMaster {
  
	@FindBy (xpath="//span[text()='Bond Master']")
	private WebElement bondMaster;
	
	
	public BondMaster (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBondMaster()
	{
		bondMaster.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

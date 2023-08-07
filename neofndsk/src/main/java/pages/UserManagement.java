package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserManagement {
	
	@FindBy (xpath="(//li[@class='MuiListItem-root MuiListItem-gutters css-1k0ezhg'])[2]")
	private WebElement userManagement;
	
	
	
	
	
	public UserManagement (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnUserManagement ()
	{
		userManagement.click();
	}
	
	
	
	
	
	
	
}

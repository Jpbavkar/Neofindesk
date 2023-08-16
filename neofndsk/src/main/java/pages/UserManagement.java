package pages;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserManagement {
	private WebDriver driver;
	
	@FindBy (xpath="(//li[@class='MuiListItem-root MuiListItem-gutters css-1bpv322-MuiListItem-root'])[2]")
	private WebElement userManagement;
	//a[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters MuiListItemButton-root MuiListItemButton-gutters css-9lxz8z'])[1]
	
	//@FindBy (xpath="(//a[@class='MuiButtonBase-root MuiListItemButton-root MuiListItemButton-gutters MuiListItemButton-root MuiListItemButton-gutters css-9lxz8z'])[1]")
	//private WebElement userManagement;
			
	@FindBy (xpath="//label[text()='First Name']")
	private WebElement firstName;

	
	
	public UserManagement (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnUserManagement ()
	{
		userManagement.click();
	}
	
	public void clickOnFirstName ()
	{
		firstName.click();
	}
	
	
	
	public void SendkeysToFirstName () throws EncryptedDocumentException, IOException
	{
		int length = 3;
		for(int i=1 ; i <= length ; i++)
		{
			Actions act32 = new Actions(driver);
		String path = "C:\\Users\\INVESTVALUE\\Documents\\User Input for Add new user.xlsx";
		FileInputStream file =new FileInputStream(path);
		String value = WorkbookFactory.create(file).getSheet("Backoffice").getRow(1).getCell(2).getStringCellValue();
		act32.moveToElement(firstName).click().sendKeys(value).build().perform();
		System.out.println(value+" is Selected as First Name");
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
}

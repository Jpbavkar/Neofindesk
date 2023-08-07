package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductType {

	@FindBy (xpath="(//li[@class='MuiListItem-root MuiListItem-gutters css-1k0ezhg'])[6]")
	private WebElement productType;
	
	@FindBy (xpath="//button[text()='Create New Record']")
	private WebElement createNewRecord;

	@FindBy (xpath="(//a[text()='View / Update'])[1]")
	private WebElement viewAndUpdate;
	
	@FindBy (xpath="(//a[text()='View / Update'])[1]")
	private WebElement editBondContent;
	
	public ProductType (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnProductType()
	{
		productType.click();
	}
	
	public void clickOnCreateNewRecord()
	{
		createNewRecord.click();
	}
	
	public void clickOnViewAndUpdate()
	{
		viewAndUpdate.click();
	}
	
	public void clickOnEditBond()
	{
		editBondContent.click();
	}
	
	
	
	
	
	
	
	
}

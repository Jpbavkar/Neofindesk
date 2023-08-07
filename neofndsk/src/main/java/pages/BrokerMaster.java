package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrokerMaster {

	@FindBy (xpath="//a[@href=\"/brokerMaster\"]")
	private WebElement brokerMasterTab;
	
	
	@FindBy (xpath="//button[text()='Add Broker']")
	private WebElement addBroker;
	
	public BrokerMaster (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBrokerMaster()
	{
		brokerMasterTab.click();
	}
	
	
	public void clickOnAddBroker()
	{
		addBroker.click();
	}
	
	
	
	
	
	
	
	
	
}

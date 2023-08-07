package UserManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.UserManagement;

public class ViewTab {


	private WebDriver driver;
	private Homepage homepage;
	private UserManagement userManagement;
	
	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			
		System.out.println("ChromeDriver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Chrome has been open");
		
		}
		
		if(browserName.equals("Edge"))
		{
			
		System.out.println("MicrosoftEdge");
		System.setProperty("webdriver.edge.driver","C:\\Users\\INVESTVALUE\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Edge has been open");
		
		}
	
		
driver.navigate().to("https://neofindesk.com/");
			
System.out.println("neofindesk has been open");
System.out.println("=====");

			 homepage = new Homepage (driver);
			homepage.clickOnLogin();
			homepage.sendKeysToUserId();
			homepage.sendKeysToPassword();
			homepage.clickOnSubmit();
			System.out.println("Homepage has been open");
			System.out.println("=====");
			
			UserManagement userManagement = new UserManagement(driver);
			userManagement.clickOnUserManagement();
	}	
@BeforeMethod
public void beforeMethod1() {
//ViewTab
			WebElement viewTab= driver.findElement(By.xpath("(//button[text()='View'])[1]"));
			
			//System.out.println(viewTab);
			boolean result1 = viewTab.isEnabled();
			if(result1=true) 
			{
				System.out.println("ViewTab button is working");
			}
			else
			{
				System.out.println("ViewTab button is not working");
			}
			viewTab.click();
			driver.getCurrentUrl();
			System.out.println("=====");



	
			
			WebElement editDetails= driver.findElement(By.xpath("//button[text()='Edit Details']"));
			boolean result2 = editDetails.isEnabled();
			if(result2=true) 
			{
				System.out.println("Edit Details button is working");
			}
			else
			{
				System.out.println("Edit Details button is not working");
			}
			editDetails.click();
			System.out.println("=====");
	
	//CompanyName
			WebElement companyName = driver.findElement(By.xpath("//label[text()='Company Name']"));
			String name = new String ("twtewte");
			Actions act = new Actions(driver);
			act.moveToElement(companyName).click().sendKeys(name).build().perform();
			System.out.println("=====");

	//AccountManager

			WebElement accountManager = driver.findElement(By.xpath("//label[text()='Account Manager']"));
			String manager =new String ("lll43455");
			//accountManager.click();
			//accountManager.sendKeys(manager);
			
			Actions act2 = new Actions(driver);
			act2.moveToElement(accountManager).click().sendKeys(manager).build().perform();
			System.out.println("=====");
}
			//SaveDetails
@Test(enabled=true)
public void test4()
{
			WebElement saveDetails= driver.findElement(By.xpath("//button[text()='Save Details']"));
			saveDetails.click();
			System.out.println("=====");
}	
			//InActive
@Test(enabled=false)
public void test5()
{
			WebElement inActive= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
			inActive.click();
			System.out.println("=====");
}			
			//Cancel
@Test(enabled=false)
public void test6() 
{
			WebElement cancel= driver.findElement(By.xpath("//button[text()='Cancel"));
			cancel.click();
			System.out.println("=====");
}		

@AfterMethod(enabled=true)
public void afterMethod() 
{		
	driver.close();
}

@AfterClass
public void afterClass() 
{		
	System.out.println("Test End");
}

		
	}



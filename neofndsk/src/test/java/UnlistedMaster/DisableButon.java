package UnlistedMaster;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.UnlistedMaster;

public class DisableButon {

	private WebDriver driver;
	private Homepage homepage;
	private UnlistedMaster unlistedMaster;
	
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

			
}
	@BeforeMethod	
	public void beforeMethod()
		{

		 homepage = new Homepage (driver);
		homepage.clickOnLogin();
		homepage.sendKeysToUserId();
		homepage.sendKeysToPassword();
		homepage.clickOnSubmit();
		System.out.println("Homepage has been open");
		System.out.println("=====");
		
		
	    unlistedMaster = new UnlistedMaster (driver);
		unlistedMaster.clickOnunlistedMaster();
		System.out.println("Unlisted Master page is open");
		System.out.println("=====");

	}
		
	@Test
	public void test1()
	{
		WebElement disableButton= driver.findElement(By.xpath("(//button[text()='Disable'])[1]"));
		boolean result=disableButton.isEnabled();
		System.out.println(result);
		System.out.println("=====");
		if (result==true)
		{
		  System.out.println("Disable button is working");
		}
		else
		{
			  System.out.println("Disable button is not working");
			}


		}
	@AfterMethod
	public void afterMethod()
	{
		
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass()
	{
		
		driver.close();
		System.out.println("Test Ends");
		
	}
}

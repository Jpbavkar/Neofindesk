package BondMaster;

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

import pages.BondMaster;
import pages.Homepage;

public class addBondFile {

	private WebDriver driver;
	private Homepage homepage;
	private BondMaster bondMaster;
	
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
	
		
driver.navigate().to("http://192.168.1.33:3000/");
			
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
		
		
		 bondMaster =new BondMaster(driver);
		bondMaster.clickOnBondMaster();

	}
		
	@Test
	public void test1()
	{
//Add Bond File
		WebElement addBondFile = driver.findElement(By.xpath("//label[text()='Add Bond file']"));
		boolean result = addBondFile.isEnabled();
		if(result = true)
		{
			System.out.println("Add bond file button is working ");
		}
		else
		{
			System.out.println("Add bond file button is not working ");
		}
		addBondFile.click();

//Choose file button
		WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
		boolean result1 = chooseFile.isEnabled();
		if(result1 = true)
		{
			System.out.println("Choose file button is working ");
		}
		else
		{
			System.out.println("Choose file button is not working ");
		}
		
//Submit			
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		boolean result2 = submit.isEnabled();
		if(result2 = true)
		{
			System.out.println("Submit button is working ");
		}
		else
		{
			System.out.println("Submit file button is not working ");
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



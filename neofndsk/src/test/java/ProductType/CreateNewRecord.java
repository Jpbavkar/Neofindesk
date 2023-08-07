package ProductType;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BrokerMaster;
import pages.Homepage;
import pages.ProductType;

public class CreateNewRecord {


	private WebDriver driver;
	private Homepage homepage;
	private BrokerMaster brokerMaster;
	
	
	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			
		System.out.println("ChromeDriver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Chrome has been open");
		
		}
		
		if(browserName.equals("Edge"))
		{
			
		System.out.println("MicrosoftEdge");
		System.setProperty("webdriver.edge.driver","C:\\Users\\INVESTVALUE\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Edge has been open");
		
		}
	
		driver.navigate().to("https://neofindesk.com/");			
		System.out.println("neofindesk has been open");
	
		
		 homepage = new Homepage (driver);
			homepage.clickOnLogin();
			homepage.sendKeysToUserId();
			homepage.sendKeysToPassword();
			homepage.clickOnSubmit();
			System.out.println("Homepage has been open");

	}
	@BeforeMethod	
	public void beforeMethod()
		{
		ProductType productType = new ProductType(driver);
		productType.clickOnProductType();
		String result = driver.getCurrentUrl();
		System.out.println(result);
	
		if(result.equals("https://neofindesk.com/productType"))
		{
			System.out.println("Url is verified");
		}
		else
		{
			System.out.println("Url is not verified");
		}  
		productType.clickOnCreateNewRecord();
		}
		

@Test
public void test1()
{	
	//Product Name
	WebElement productName = driver.findElement(By.xpath("//label[text()='Product Name']"));
	Actions act1 = new Actions(driver);
	String name = new String("fsfssfscs");
	act1.moveToElement(productName).click().sendKeys(name).build().perform();
	System.out.println(name +" is Selected as Product Name");
	System.out.println("=====");
	
//Bench Mark
	WebElement benchMark = driver.findElement(By.xpath("//label[text()='Bench mark']"));
	Actions act2 = new Actions(driver);
	String mark = new String("fsfssfscs");
	act2.moveToElement(benchMark).click().sendKeys(mark).build().perform();
	System.out.println(mark +" is Selected as Bench Mark");
	System.out.println("=====");		
	
	
//GST
	WebElement gst = driver.findElement(By.xpath("//label[text()='GST']"));
	Actions act3 = new Actions(driver);
	String number = new String("fsfssfscs");
	act3.moveToElement(gst).click().sendKeys(number).build().perform();
	System.out.println(number +" is Selected as GST Number");
	System.out.println("=====");
	
	
//TCS
	WebElement tcs = driver.findElement(By.xpath("//label[text()='TCS']"));
	Actions act4 = new Actions(driver);
	String tcsdetail = new String("fsfssfscs");
	act4.moveToElement(tcs).click().sendKeys(tcsdetail).build().perform();
	System.out.println("TCS ="+tcsdetail );
	System.out.println("=====");
	
	
//Stamp Duty
	WebElement stampDuty = driver.findElement(By.xpath("//label[text()='Stamp Duty ']"));
	Actions act5 = new Actions(driver);
	String duty = new String("fsfssfscs");
	act5.moveToElement(stampDuty).click().sendKeys(duty).build().perform();
	System.out.println("Stamp duty = "+ duty);
	System.out.println("=====");


	
//Submit
WebElement submit = driver.findElement(By.xpath("//button[text()=' Submit']"));
boolean save=submit.isEnabled();
if(save=true)
{
	System.out.println("Submit button is working");
}
else
{
	System.out.println("Submit button not is working");
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
	



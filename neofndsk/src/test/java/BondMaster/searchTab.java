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
import pages.BrokerMaster;
import pages.Homepage;

public class searchTab {

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
	
		
driver.navigate().to("https://stage.neofindesk.com/");
			
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
		System.out.println("Bond Master page is open");
		System.out.println("=====");

	}
		
	@Test
	public void test1()
	{
		String data = ("andhra");
		String data1 = data.toLowerCase();
		System.out.println("String enter ="+data1);
		System.out.println("=====");
		
		WebElement searchTab= driver.findElement(By.xpath("//input[@placeholder='Search Bond by Issuer Name Or ISIN.']"));
		searchTab.sendKeys(data);

		WebElement result= driver.findElement(By.xpath("//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-ranc02']"));
		String verify = result.getText();
		String newVerify = verify.toLowerCase();

		//String newVerify = new String (verify);
		System.out.println("Results");
		System.out.println(verify);
		System.out.println("=====");

		if(newVerify.contains(data))
		{
			System.out.println("Search Tab is working");
		}
		else
		{
			System.out.println("Search Tab is not working");
		}
		System.out.println("=====");
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

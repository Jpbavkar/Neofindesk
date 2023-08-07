package UnlistedMaster;

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

import pages.Homepage;
import pages.UnlistedMaster;

public class AddUnlisted {

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

homepage = new Homepage (driver);
homepage.clickOnLogin();
homepage.sendKeysToUserId();
homepage.sendKeysToPassword();
homepage.clickOnSubmit();
System.out.println("Homepage has been open");
System.out.println("=====");

		
}
	@BeforeMethod	
	public void beforeMethod()
		{

	    unlistedMaster = new UnlistedMaster (driver);
		unlistedMaster.clickOnunlistedMaster();
		System.out.println("Unlisted Master page is open");
		System.out.println("=====");
		unlistedMaster.clickOnAddUnlistedMaster();

	}
		
	@Test(priority =1)
	public void scriptName()
	{
		String name =new String ("kkkk");
		WebElement scriptName = driver.findElement(By.xpath("//label[text()='Script Name']"));
		Actions act1 =new Actions (driver);
		act1.moveToElement(scriptName).click().sendKeys(name).build().perform();	
	System.out.println(name+" is selected as Script Name");
	
	
	    String number =new String ("kkkk");
		WebElement isinNumber = driver.findElement(By.xpath("//label[text()='Isin Number']"));
		Actions act2 =new Actions (driver);
		act2.moveToElement(isinNumber).click().sendKeys(number).build().perform();
		System.out.println(number+" is selected as Isin Number");
	
	
		String face =new String ("2");
		WebElement faceValue = driver.findElement(By.xpath("//label[text()='Face Value']"));
		Actions act3 =new Actions (driver);
		act3.moveToElement(faceValue).click().sendKeys(face).build().perform();
		System.out.println(face+" is selected as Isin Number");
	
	
		WebElement uploadLogoButton = driver.findElement(By.xpath("//label[text()='Upload Logo']"));
		boolean result1= uploadLogoButton.isEnabled();
		System.out.println(result1);
	
	
	
		WebElement uploadReportFile = driver.findElement(By.xpath("//label[text()='Upload Report File']"));
		boolean result2= uploadReportFile.isEnabled();
		System.out.println(result2);
	}
	
	@Test(enabled=false)
	public void submit()
	{
		WebElement submit = driver.findElement(By.xpath("//label[text()=' Submit']"));
		boolean result3= submit.isEnabled();
		System.out.println(result3);
	}
	@AfterMethod
	public void afterMethod()
	{
		
		driver.manage().window().maximize();
	}
	@AfterClass
	public void afterClass()
	{
		
		//driver.close();
		System.out.println("Test Ends");
		
	}
}
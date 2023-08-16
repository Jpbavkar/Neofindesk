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

public class ViewAndUpdate {

	
		private WebDriver driver;
		private Homepage homepage;
		private BrokerMaster brokerMaster;
		private ProductType productType;
		
		@Parameters ("browser")
		@BeforeClass
		public void beforeClass(String browserName)
		{
			if(browserName.equals("Chrome"))
			{
				
			System.out.println("ChromeDriver");
			System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
			
			driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
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
		
			driver.navigate().to("http://192.168.1.33:3000/");			
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
			 productType = new ProductType(driver);
				productType.clickOnProductType();
				productType.clickOnViewAndUpdate();
		}

		@Test
		public void test1()
		{
			
		
			
			//Update	
			WebElement update = driver.findElement(By.xpath("//button[text()='Update']"));
			boolean up=update.isEnabled();
			if(up=true)
			{
				System.out.println("Update button is working");
			}
			else
			{
				System.out.println("Update button not is working");
			}		
			update.click();
			
	//Product Name
			WebElement product = driver.findElement(By.xpath("//label[text()='Product Name']"));
			Actions pr = new Actions(driver);
			pr.moveToElement(product).click().build().perform();
			System.out.println("=====");
			
	//Description
			WebElement description = driver.findElement(By.xpath("//label[text()='Description']"));
			Actions des = new Actions(driver);
			des.moveToElement(description).click().build().perform();
			System.out.println("=====");  

	//GST Value
		WebElement gstValue = driver.findElement(By.xpath("//label[text()='GST Value']"));
		//gstValue.clear();
		Actions act = new Actions(driver);
		String value = new String("fsfssfscs");
		act.moveToElement(gstValue).click().sendKeys(value).build().perform();
		System.out.println(value +" is Selected as GST Value");
		System.out.println("=====");

	//TCS Value
		WebElement tcsValue = driver.findElement(By.xpath("//label[text()='TCS Value']"));
		Actions act2 = new Actions(driver);
		String value2 = new String("fsfssfscs");
		act2.moveToElement(tcsValue).click().sendKeys(value2).build().perform();
		System.out.println(value2 +" is Selected as TCS Value");
		System.out.println("=====");
		
	//Stamp Duty 
		WebElement stampDuty = driver.findElement(By.xpath("//label[text()='Stamp Duty']"));
		Actions act3 = new Actions(driver);
		String value3 = new String("fsfssfscs");
		act3.moveToElement(stampDuty).click().sendKeys(value3).build().perform();
		System.out.println("Stamp Duty" + value3 );
		System.out.println("=====");
		
		
	//Submit 
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		boolean ok=submit.isEnabled();
		if(ok=true)
		{
			System.out.println("Submit button is working");
		}
		else
		{
			System.out.println("Submit button not is working");
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
			
		//driver.close();
			System.out.println("Test Ends");
			
		}
}
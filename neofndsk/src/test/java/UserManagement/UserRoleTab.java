package UserManagement;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.UserManagement;


	public class UserRoleTab {

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
			
	driver.navigate().to("http://192.168.1.55:3000/");			
	System.out.println("neofindesk has been open");
		
			homepage = new Homepage (driver);
			homepage.clickOnLogin();
			homepage.sendKeysToUserId();
			homepage.sendKeysToPassword();
			homepage.clickOnSubmit();
			System.out.println("Homepage has been open");
			
			
				
			 userManagement = new UserManagement(driver);
			userManagement.clickOnUserManagement();
			
			String userManagementurl = driver.getCurrentUrl();
			System.out.println(userManagementurl);
	}
			@BeforeMethod
			public void beforeMethod()
			{	
			
				System.out.println("Start");
		}
			
		@Test 
		public void test1()
		{

//Admin			
			WebElement userRole = driver.findElement(By.xpath("//button[@title='Open']"));
			Actions act = new Actions(driver);
			act.moveToElement(userRole).click().build().perform();
			System.out.println("=====");
			
			System.out.println("Admin");
			WebElement admin = driver.findElement(By.xpath("//li[text()='Admin']"));
			admin.click();
			
			WebElement adminresult = driver.findElement(By.xpath("//input[@value='Admin']"));
			String result1=adminresult.getAttribute("value");
			if (result1.equals("Admin"))
			{
				System.out.println("Admin tab is selected");
			}
			else
			{
				System.out.println("Admin tab is not selected");
			}
		
			
			
			WebElement close = driver.findElement(By.xpath("//button[@title='Clear']"));
			close.click();
			WebElement scrollDown = driver.findElement(By.xpath("//button[@title='Open']"));
			scrollDown.click(); 
			
			System.out.println("=====");
		
			
//Backoffice			
				 
			System.out.println("backoffice");
			
			
			WebElement backOffice = driver.findElement(By.xpath("//li[text()='Backoffice']"));
			backOffice.click();
			
			WebElement backofficeresult = driver.findElement(By.xpath("//input[@value='Backoffice']"));
			String result2=backofficeresult.getAttribute("value");
			if (result2.equals("Backoffice"))
			{
				System.out.println("Backoffice tab is selected");
			}
			else
			{
				System.out.println("Backoffice tab is not selected");
			}
		
			WebElement close2 = driver.findElement(By.xpath("//button[@title='Clear']"));
			close2.click();
			System.out.println("=====");
			WebElement scrollDown2 = driver.findElement(By.xpath("//button[@title='Open']"));
			scrollDown2.click();
		
		
//Distributor
			
			System.out.println("Distributor");
			WebElement distributor = driver.findElement(By.xpath("//li[text()='Distributor']"));
			distributor.click();
			
			WebElement distributorresult = driver.findElement(By.xpath("//input[@value='Distributor']"));
			String result3=distributorresult.getAttribute("value");
			if (result3.equals("Distributor"))
			{
				System.out.println("Distributor tab is selected");
			}
			else
			{
				System.out.println("Distributor tab is not selected");
			}
		
			WebElement close3 = driver.findElement(By.xpath("//button[@title='Clear']"));
			close3.click();
			System.out.println("=====");
			WebElement scrollDown3 = driver.findElement(By.xpath("//button[@title='Open']"));
			scrollDown3.click();
		

//Manufacture
			
			System.out.println("Manufacture");
			WebElement manufacture = driver.findElement(By.xpath("//li[text()='Manufacture']"));
			manufacture.click();
			
			WebElement manufactureresult = driver.findElement(By.xpath("//input[@value='Manufacture']"));
			String result4=manufactureresult.getAttribute("value");
			if (result4.equals("Manufacture"))
			{
				System.out.println("Manufacture tab is selected");
			}
			else
			{
				System.out.println("Manufacture tab is not selected");
			}
			
			WebElement adminresult2 = driver.findElement(By.xpath("//table[@aria-label='simple table']"));
			String result13=adminresult2.getText();
			System.out.println(result13);
			if (result13.contains("JABA491"))
				if(result13.contains("Jay Bavkar"))
				if	(result13.contains("8830498803"))
			{
				System.out.println("New manufacture is created");
			}
			else
			{
				System.out.println("New manufacture is not created");
			}
		
		}	
		
		@AfterMethod
		public void afterMethod()
		{
			
			driver.close();
		}
		@AfterClass
		public void afterClass()
		{
			
			System.out.println("End");
			
		}
	}

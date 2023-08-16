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
		/*if(browserName.equals("Chrome"))
		{
			
		System.out.println("ChromeDriver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Chrome has been open");
		
		}*/
		
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
	
	
	@Test 
	public void test1()
	{
	
	
	
	
	
	//AddNewUser		
	WebElement addNewUser2= driver.findElement(By.xpath("//button[text()='Add New User']"));
	
	addNewUser2.click();
		
//SelectUserType
	
	WebElement selectUserType23 = driver.findElement(By.xpath("//label[text()='Select User Type']"));
	Actions act203 = new Actions(driver);
	act203.moveToElement(selectUserType23).click().build().perform();
	System.out.println("=====");

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

//Broker		
WebElement userRoleScroll12 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
userRoleScroll12.click();

WebElement broker2= driver.findElement(By.xpath("//li[text()='Invest Value Fintech Pvt Ltd']"));
broker2.click();

WebElement brokeresult2 = driver.findElement(By.xpath("//input[@value='Invest Value Fintech Pvt Ltd']"));
String brkrresult2=brokeresult2.getAttribute("value");
if (brkrresult2.equals("Invest Value Fintech Pvt Ltd"))
{
	System.out.println("Invest Value Fintech Pvt Ltd is selected as Broker");
}
else
{
	System.out.println("Invest Value Fintech Pvt Ltd is not selected as Broker");
}

//FirstName

		WebElement firstName2 = driver.findElement(By.xpath("//label[text()='First Name']"));
		//firstName2.sendKeys("jayesh");				
		Actions act32 = new Actions(driver);


			//for(int j=i ; j <= length ; j++) {

			String value = new String ("akashay");
			act32.moveToElement(firstName2).click().sendKeys(value).build().perform();
			System.out.println(value+" is Selected as First Name");
		
		

//MiddleName
		
		WebElement middleName2 = driver.findElement(By.xpath("//label[text()='Middle Name']"));
		Actions act42 = new Actions(driver);
		String middle2 = new String ("");
		//act42.moveToElement(middleName2).click().sendKeys(middle2).build().perform();
		//System.out.println(middle2+" is Selected as Middle Name");
		
		
//LastName
		
		WebElement lastName2 = driver.findElement(By.xpath("//label[text()='Last Name']"));
		Actions act52 = new Actions(driver);
		String last2 = new String ("jadhav");
		act52.moveToElement(lastName2).click().sendKeys(last2).build().perform();
		System.out.println(last2+" is Selected as Last Name");
		
		
//MobileNo
		
		WebElement mobileNo2 = driver.findElement(By.xpath("//label[text()='Mobile No']"));
		Actions act62 = new Actions(driver);
		String no2 = new String ("8840498802");
		act62.moveToElement(mobileNo2).click().sendKeys(no2).build().perform();
		System.out.println(no2+" is Selected as Mobile No");
		
		
//Email
		
		WebElement emailId2 = driver.findElement(By.xpath("//label[text()='Email']"));
		Actions act72 = new Actions(driver);
		String id2 = new String ("akashay@gmail.com");
		act72.moveToElement(emailId2).click().sendKeys(id2).build().perform();
		System.out.println(id2+" is Selected as Email Id");
		
//EmployeeCode
				
				WebElement employeeCode2 = driver.findElement(By.xpath("//label[text()='Employee Code']"));
				Actions act82 = new Actions(driver);
				String employeeCodename2 = new String ("AKSHAY2015");
				act82.moveToElement(employeeCode2).click().sendKeys(employeeCodename2).build().perform();
				System.out.println(employeeCodename2+" is Selected as Employee Code");

//Products
				WebElement product12 = driver.findElement(By.xpath("(//button[@title='Open'])[4]"));
				product12.click();
				WebElement selectAll2= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
				selectAll2.click();	
				//driver.navigate().to("http://192.168.1.35:3000/UserDashboard");
		
//Submit					
				WebElement submit2 = driver.findElement(By.xpath("//button[text()='Submit']"));
				Actions act102 = new Actions(driver);
				act102.moveToElement(submit2).click().build().perform();
				System.out.println("Submit button is working");
				
				System.out.println("=====");
	
	
	//Verify Data
				
				WebElement dataResult= driver.findElement(By.xpath("//tbody"));
				
				//System.out.println(viewTab);
				String text1 = dataResult.getText();
				if(text1.contains("akashay"))
						if(text1.contains("jadhav"))
				{
					System.out.println("New User is created");
				}
				else
				{
					System.out.println("New User is not created");
				}
				System.out.println("=====");	
	
				
	
//View Button
	
				String name122 = "akashay jadhav";
	            WebElement content3 = driver.findElement(By.xpath("//tbody[@class='MuiTableBody-root css-apqrd9-MuiTableBody-root']/tr[td[.='"+name122+"']]/td[5]/a/button"));
				content3.click();
				
		/*		
	
	
//Edit Details	
			WebElement editDetails= driver.findElement(By.xpath("//button[text()='Edit Details']"));
			boolean result22 = editDetails.isEnabled();
			if(result22 = true) 
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

//SaveDetails
			WebElement saveDetails= driver.findElement(By.xpath("//button[text()='Save Details']"));
			saveDetails.click();
			System.out.println("=====");
	*/
}		
@Test (enabled = false)
public void test5()
{
	//InActive

			WebElement inActive= driver.findElement(By.xpath("(//button[@type='button'])[4]"));
			inActive.click();
			System.out.println("=====");
}			
			//Cancel

@Test (enabled = false)
public void test6() 
{
			WebElement cancel= driver.findElement(By.xpath("//button[text()='Cancel"));
			cancel.click();
			System.out.println("=====");
}		




@AfterClass
public void afterClass() 
{	
	//driver.close();
	System.out.println("Test End");
}

		
	}



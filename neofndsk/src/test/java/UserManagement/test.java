package UserManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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
import pages.UserManagement;

public class test {
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
		
		 userManagement = new UserManagement(driver);
		 System.out.println("Homepage has been open1");
		userManagement.clickOnUserManagement();
		System.out.println("Homepage has been open2");
		String userManagementurl = driver.getCurrentUrl();
		System.out.println(userManagementurl);
			

	}	

//Admin                             ============================================================================================================= 
		
		@Test 
	public void selectAdmin() throws EncryptedDocumentException, IOException
			{
			int length = 3;
			String path = "C:\\Users\\INVESTVALUE\\Documents\\User Input for Add new user.xlsx";
			FileInputStream file =new FileInputStream(path);
			Sheet sheet = WorkbookFactory.create(file).getSheet("Admin");
			
			for(int i=1 ; i <= length ; i++)
			{
			
		//AddNewUser		
		WebElement addNewUser= driver.findElement(By.xpath("//button[text()='Add New User']"));
		Actions act000 = new Actions(driver);
		act000.moveToElement(addNewUser).click().build().perform();
		//addNewUser.click();
	
//SelectUserType
		WebElement selectUserType = driver.findElement(By.xpath("//label[text()='Select User Type']"));
		Actions act = new Actions(driver);
		act.moveToElement(selectUserType).click().build().perform();
		System.out.println("=====");
		
		WebElement admin= driver.findElement(By.xpath("//li[text()='Admin']"));
		admin.click();
		
		WebElement adminresult = driver.findElement(By.xpath("//input[@value='Admin']"));
		String result1=adminresult.getAttribute("value");
		if (result1.equals("Admin"))
		{
			System.out.println("Admin tab is selected in User Type");
		}
		else
		{
			System.out.println("Admin tab is not selected in User Type");
		}
	
//Broker  
	WebElement userRoleScroll4 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
	userRoleScroll4.click();

WebElement broker1= driver.findElement(By.xpath("//li[text()='Invest Value Fintech Pvt Ltd']"));
broker1.click();

WebElement brokeresult = driver.findElement(By.xpath("//input[@value='Invest Value Fintech Pvt Ltd']"));
String brkrresult=brokeresult.getAttribute("value");
if (brkrresult.equals("Invest Value Fintech Pvt Ltd"))
{
	System.out.println("Invest Value Fintech Pvt Ltd is selected as Broker");
}
else
{
	System.out.println("Invest Value Fintech Pvt Ltd is not selected as Broker");
}

/*WebElement close5 = driver.findElement(By.xpath("(//button[@title='Clear'])[3]"));
close5.click();
*/


//FirstName
		
		WebElement firstName = driver.findElement(By.xpath("//label[text()='First Name']"));
		Actions act3 = new Actions(driver);
		String name = sheet.getRow(i).getCell(1).getStringCellValue();
		
		act3.moveToElement(firstName).click().sendKeys(name).build().perform();
		System.out.println(name+" is Selected as First Name");
		


		
//MobileNo
		
		WebElement mobileNo = driver.findElement(By.xpath("//label[text()='Mobile No']"));
		Actions act6 = new Actions(driver);		
		System.out.println("  as Mobile No");
		
		//String no = String.valueOf(sheet.getRow(1).getCell(4).getCellFormula().toString());
		
		System.out.println(" is Selected as Mobile No");
		double no = sheet.getRow(i).getCell(4).getNumericCellValue();
		//Long aa = Double.doubleToLongBits(no);
		String mobileNumber12 = String.valueOf((long) sheet.getRow(1).getCell(4).getNumericCellValue());
	String b = 	Double.toString(no);
	
		
		act6.moveToElement(mobileNo).click().sendKeys(mobileNumber12).build().perform();
		}	
			
		}
		@AfterMethod
		public void afterClass4() {
			//driver.navigate().to("http://192.168.1.35:3000/UserDashboard");
			driver.manage().window().maximize();
		}
		
		@AfterClass
		public void end() {
			System.out.println("Test End");
		}
}

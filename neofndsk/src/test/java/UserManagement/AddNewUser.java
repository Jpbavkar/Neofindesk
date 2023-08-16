package UserManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
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

import com.google.common.collect.Table.Cell;

import pages.Homepage;
import pages.UserManagement;

public class AddNewUser {

	private WebDriver driver;
	private Homepage homepage;
	private UserManagement userManagement;
	
	
	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName)
	{
	/*	if(browserName.equals("Chrome"))
		{
			
		System.out.println("ChromeDriver");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Chrome has been open");
		
		}*/
		
		if(browserName.equals("Edge"))
		{
			
		System.out.println("MicrosoftEdge");
		System.setProperty("webdriver.edge.driver","C:\\Users\\INVESTVALUE\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		System.out.println("Edge has been open");
		
		}
	
	
driver.navigate().to("http://192.168.1.35:3000/");			
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
	
		@BeforeMethod
		public void selectUserType() {
			//AddNewUser		
			
			System.out.println("-----");
						
	}

//Admin                             ============================================================================================================= 
		
		@Test 
	public void selectAdmin() throws EncryptedDocumentException, IOException
			{
			int length = 2;
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
		

//MiddleName
		
		WebElement middleName = driver.findElement(By.xpath("//label[text()='Middle Name']"));
		Actions act4 = new Actions(driver);
		String middle = sheet.getRow(i).getCell(2).getStringCellValue();
		act4.moveToElement(middleName).click().sendKeys(middle).build().perform();
		System.out.println(middle+" is Selected as Middle Name");
		
		
//LastName
		
		WebElement lastName = driver.findElement(By.xpath("//label[text()='Last Name']"));
		Actions act5 = new Actions(driver);
		String last = sheet.getRow(i).getCell(3).getStringCellValue();
		act5.moveToElement(lastName).click().sendKeys(last).build().perform();
		System.out.println(last+" is Selected as Last Name");
		
		
//MobileNo
		
		WebElement mobileNo = driver.findElement(By.xpath("//label[text()='Mobile No']"));
		Actions act6 = new Actions(driver);
		String no = String.valueOf((long) sheet.getRow(i).getCell(4).getNumericCellValue());
		act6.moveToElement(mobileNo).click().sendKeys(no).build().perform();
		
		System.out.println(no+" is Selected as Mobile No");
		
		
//Email
		
		WebElement emailId = driver.findElement(By.xpath("//label[text()='Email']"));
		Actions act7 = new Actions(driver);
		String id = sheet.getRow(i).getCell(5).getStringCellValue();
		act7.moveToElement(emailId).click().sendKeys(id).build().perform();
		System.out.println(id+" is Selected as Email Id");
		
//EmployeeCode
				
				WebElement employeeCode = driver.findElement(By.xpath("//label[text()='Employee Code']"));
				Actions act8 = new Actions(driver);
				String employeeCodename = sheet.getRow(i).getCell(6).getStringCellValue();
				act8.moveToElement(employeeCode).click().sendKeys(employeeCodename).build().perform();
				System.out.println(employeeCodename+" is Selected as Employee Code");
				
		
	//Submit			
				WebElement submit1 = driver.findElement(By.xpath("//button[text()='Submit']"));
				Actions act101 = new Actions(driver);
				act101.moveToElement(submit1).click().build().perform();
				System.out.println("Submit button is working");

				System.out.println("=====");
			
		}		
		}
	
//Backoffice			                     =======================================================================================================
		
		@Test (enabled = false)
		public void selectBackOffice() throws EncryptedDocumentException, IOException {
			
			int length = 3;
			String path = "C:\\Users\\INVESTVALUE\\Documents\\User Input for Add new user.xlsx";
			FileInputStream file =new FileInputStream(path);
			Sheet sheet = WorkbookFactory.create(file).getSheet("Backoffice");
			for(int i=1 ; i <= length ; i++)
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

					String value = sheet.getRow(i).getCell(1).getStringCellValue();
					act32.moveToElement(firstName2).click().sendKeys(value).build().perform();
					System.out.println(value+" is Selected as First Name");
				
				

//MiddleName
				
				WebElement middleName2 = driver.findElement(By.xpath("//label[text()='Middle Name']"));
				Actions act42 = new Actions(driver);
				String middle2 = sheet.getRow(i).getCell(2).getStringCellValue();
				act42.moveToElement(middleName2).click().sendKeys(middle2).build().perform();
				System.out.println(middle2+" is Selected as Middle Name");
				
				
//LastName
				
				WebElement lastName2 = driver.findElement(By.xpath("//label[text()='Last Name']"));
				Actions act52 = new Actions(driver);
				String last2 = sheet.getRow(i).getCell(3).getStringCellValue();
				act52.moveToElement(lastName2).click().sendKeys(last2).build().perform();
				System.out.println(last2+" is Selected as Last Name");
				
				
//MobileNo
				
				WebElement mobileNo2 = driver.findElement(By.xpath("//label[text()='Mobile No']"));
				Actions act62 = new Actions(driver);
				String no2 = String.valueOf((long) sheet.getRow(i).getCell(4).getNumericCellValue());
				act62.moveToElement(mobileNo2).click().sendKeys(no2).build().perform();
				System.out.println(no2+" is Selected as Mobile No");
				
				
//Email
				
				WebElement emailId2 = driver.findElement(By.xpath("//label[text()='Email']"));
				Actions act72 = new Actions(driver);
				String id2 = sheet.getRow(i).getCell(5).getStringCellValue();
				act72.moveToElement(emailId2).click().sendKeys(id2).build().perform();
				System.out.println(id2+" is Selected as Email Id");
				
//EmployeeCode
						
						WebElement employeeCode2 = driver.findElement(By.xpath("//label[text()='Employee Code']"));
						Actions act82 = new Actions(driver);
						String employeeCodename2 = sheet.getRow(i).getCell(6).getStringCellValue();
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
		}
		}
		
//Distributor     ==========================================================================================================================
		
		
		@Test (enabled = false)
		public void selectDistributor() throws EncryptedDocumentException, IOException {

			int length = 3;
			String path = "C:\\Users\\INVESTVALUE\\Documents\\User Input for Add new user.xlsx";
			FileInputStream file =new FileInputStream(path);
			Sheet sheet = WorkbookFactory.create(file).getSheet("Distributor");
			for(int i=1 ; i <= length ; i++)
			{
			
			
			//AddNewUser		
			WebElement addNewUser3= driver.findElement(By.xpath("//button[text()='Add New User']"));
			
			addNewUser3.click();
//SelectUserType
			
			WebElement selectUserType3 = driver.findElement(By.xpath("//label[text()='Select User Type']"));
			Actions act233 = new Actions(driver);
			act233.moveToElement(selectUserType3).click().build().perform();
			System.out.println("=====");	
			
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

//User Role	
		WebElement userRoleScroll4 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
		userRoleScroll4.click();	
		
		 WebElement compHead= driver.findElement(By.xpath("//li[text()='Company Head']"));
		 compHead.click();
			
			WebElement individualresult = driver.findElement(By.xpath("//input[@value='Company Head']"));
			String indvresult=individualresult.getAttribute("value");
			if (indvresult.equals("Company Head"))
			{
				System.out.println("Company Head tab is selected in User Role");
			}
			else
			{
				System.out.println("Company Head tab is not selected in User Role");
			}		
		
//Broker  
			WebElement userRoleScroll43 = driver.findElement(By.xpath("(//button[@title='Open'])[4]"));
			userRoleScroll43.click();

		WebElement broker13= driver.findElement(By.xpath("//li[text()='Invest Value Fintech Pvt Ltd']"));
		broker13.click();

		WebElement brokeresult3 = driver.findElement(By.xpath("//input[@value='Invest Value Fintech Pvt Ltd']"));
		String brkrresult3=brokeresult3.getAttribute("value");
		if (brkrresult3.equals("Invest Value Fintech Pvt Ltd"))
		{
			System.out.println("Invest Value Fintech Pvt Ltd is selected as Broker");
		}
		else
		{
			System.out.println("Invest Value Fintech Pvt Ltd is not selected as Broker");
		}
		
//User Company	
		WebElement userCompany43 = driver.findElement(By.xpath("(//button[@title='Open'])[5]"));
		userCompany43.click();

	WebElement company3= driver.findElement(By.xpath("//li[text()='NeoD']"));
	company3.click();

	WebElement companyesult3 = driver.findElement(By.xpath("//input[@value='NeoD']"));
	String cpmresult3=companyesult3.getAttribute("value");
	if (cpmresult3.equals("NeoD"))
	{
		System.out.println("NeoD is selected as User Company");
	}
	else
	{
		System.out.println("NeoD is not selected as User Company");
	}
		
		
	//FirstName
	
			WebElement firstName3 = driver.findElement(By.xpath("//label[text()='First Name']"));
			System.out.println("===");
			Actions act33 = new Actions(driver);
			String name3 = sheet.getRow(i).getCell(1).getStringCellValue();
			act33.moveToElement(firstName3).click().sendKeys(name3).build().perform();
			System.out.println(name3 +" is Selected as First Name");
			

	//MiddleName
			
			WebElement middleName3 = driver.findElement(By.xpath("//label[text()='Middle Name']"));
			Actions act43 = new Actions(driver);
			String middle3 = sheet.getRow(i).getCell(2).getStringCellValue();
			act43.moveToElement(middleName3).click().sendKeys(middle3).build().perform();
			System.out.println(middle3 +" is Selected as Middle Name");
			
			
	//LastName
			
			WebElement lastName3 = driver.findElement(By.xpath("//label[text()='Last Name']"));
			Actions act53 = new Actions(driver);
			String last3 = sheet.getRow(i).getCell(3).getStringCellValue();
			act53.moveToElement(lastName3).click().sendKeys(last3).build().perform();
			System.out.println(last3 +" is Selected as Last Name");
			
			
	//MobileNo
			
			WebElement mobileNo3 = driver.findElement(By.xpath("//label[text()='Mobile No']"));
			Actions act63 = new Actions(driver);
			String no3 = String.valueOf((long) sheet.getRow(i).getCell(4).getNumericCellValue());
			act63.moveToElement(mobileNo3).click().sendKeys(no3).build().perform();
			System.out.println(no3+" is Selected as Mobile No");
			
			
	//Email
			
			WebElement emailId3 = driver.findElement(By.xpath("//label[text()='Email']"));
			Actions act73 = new Actions(driver);
			String id3 = sheet.getRow(i).getCell(5).getStringCellValue();
			act73.moveToElement(emailId3).click().sendKeys(id3).build().perform();
			System.out.println(id3 +" is Selected as Email Id");
			
	//EmployeeCode
					
					WebElement employeeCode3 = driver.findElement(By.xpath("//label[text()='Employee Code']"));
					Actions act83 = new Actions(driver);
					String employeeCodename3 = sheet.getRow(i).getCell(6).getStringCellValue();
					act83.moveToElement(employeeCode3).click().sendKeys(employeeCodename3).build().perform();
					System.out.println(employeeCodename3+" is Selected as Employee Code");
	
	//Account Manager No
									
					WebElement accmanagerNo3 = driver.findElement(By.xpath("//label[text()='Account Manager No']"));
					Actions act833 = new Actions(driver);
					String managerNo3 = String.valueOf((long) sheet.getRow(i).getCell(7).getNumericCellValue());
					act833.moveToElement(accmanagerNo3).click().sendKeys(managerNo3).build().perform();
					System.out.println(managerNo3 +" is Selected as Account Manager No");
	
	//Products 
					WebElement prdtc43 = driver.findElement(By.xpath("(//button[@title='Open'])[6]"));
					prdtc43.click();

				WebElement unlisted3= driver.findElement(By.xpath("//li[text()='UNLISTED']"));
				unlisted3.click();
				//driver.navigate().to("http://192.168.1.35:3000/UserDashboard");
				
					
	//Submit
				
				WebElement submit3 = driver.findElement(By.xpath("//button[text()='Submit']"));
				Actions act103 = new Actions(driver);
				act103.moveToElement(submit3).click().build().perform();
				System.out.println("Submit button is working");
	
				System.out.println("=====");
			}
		}
		
//Manufacture                     ==================================================================================================================
		@Test (enabled = false)
		public void selectManufacture() throws EncryptedDocumentException, IOException {
			
			int length = 3;
			String path = "C:\\Users\\INVESTVALUE\\Documents\\User Input for Add new user.xlsx";
			FileInputStream file =new FileInputStream(path);
			Sheet sheet = WorkbookFactory.create(file).getSheet("Manufacturer");
			for(int i=1 ; i <= length ; i++)
			{
				
			
			//AddNewUser		
			WebElement addNewUser4= driver.findElement(By.xpath("//button[text()='Add New User']"));
			
			addNewUser4.click();
//SelectUserType
			
			WebElement selectUserType4 = driver.findElement(By.xpath("//label[text()='Select User Type']"));
			Actions act234 = new Actions(driver);
			act234.moveToElement(selectUserType4).click().build().perform();
			System.out.println("=====");
			
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
		
		
//User Role	
				WebElement userRoleScroll44 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
				userRoleScroll44.click();	
				
				 WebElement compHead4= driver.findElement(By.xpath("//li[text()='Company Head']"));
				 compHead4.click();
					
					WebElement individualresult4 = driver.findElement(By.xpath("//input[@value='Company Head']"));
					String indvresult4=individualresult4.getAttribute("value");
					if (indvresult4.equals("Company Head"))
					{
						System.out.println("Company Head tab is selected in User Role");
					}
					else
					{
						System.out.println("Company Head tab is not selected in User Role");
					}			
		
		
//Broker  
					WebElement userRoleScroll434 = driver.findElement(By.xpath("(//button[@title='Open'])[4]"));
					userRoleScroll434.click();

				WebElement broker134= driver.findElement(By.xpath("//li[text()='Invest Value Fintech Pvt Ltd']"));
				broker134.click();

				WebElement brokeresult34 = driver.findElement(By.xpath("//input[@value='Invest Value Fintech Pvt Ltd']"));
				String brkrresult34=brokeresult34.getAttribute("value");
				if (brkrresult34.equals("Invest Value Fintech Pvt Ltd"))
				{
					System.out.println("Invest Value Fintech Pvt Ltd is selected as Broker");
				}
				else
				{
					System.out.println("Invest Value Fintech Pvt Ltd is not selected as Broker");
				}
					
		
//User Company	
				WebElement userCompany44 = driver.findElement(By.xpath("(//button[@title='Open'])[5]"));
				userCompany44.click();

			WebElement company4= driver.findElement(By.xpath("//li[text()='Neo']"));
			company4.click();

			WebElement companyesult4 = driver.findElement(By.xpath("//input[@value='Neo']"));
			String cpmresult4=companyesult4.getAttribute("value");
			if (cpmresult4.equals("Neo"))
			{
				System.out.println("NeoD is selected as User Company");
			}
			else
			{
				System.out.println("NeoD is not selected as User Company");
			}		
		
		
	//FirstName
			
			WebElement firstName4 = driver.findElement(By.xpath("//label[text()='First Name']"));
			Actions act34 = new Actions(driver);
			String name4 = sheet.getRow(i).getCell(1).getStringCellValue();
			act34.moveToElement(firstName4).click().sendKeys(name4).build().perform();
			System.out.println(name4 +" is Selected as First Name");
			

	//MiddleName
			
			WebElement middleName4 = driver.findElement(By.xpath("//label[text()='Middle Name']"));
			Actions act44 = new Actions(driver);
			String middle4 = sheet.getRow(i).getCell(2).getStringCellValue();
			act44.moveToElement(middleName4).click().sendKeys(middle4).build().perform();
			System.out.println(middle4 +" is Selected as Middle Name");
			
			
	//LastName
			
			WebElement lastName4 = driver.findElement(By.xpath("//label[text()='Last Name']"));
			Actions act54 = new Actions(driver);
			String last4 = sheet.getRow(i).getCell(3).getStringCellValue();
			act54.moveToElement(lastName4).click().sendKeys(last4).build().perform();
			System.out.println(last4 +" is Selected as Last Name");
			
			
	//MobileNo
			
			WebElement mobileNo4 = driver.findElement(By.xpath("//label[text()='Mobile No']"));
			Actions act64 = new Actions(driver);
			String no4 = String.valueOf((long) sheet.getRow(i).getCell(4).getNumericCellValue());
			act64.moveToElement(mobileNo4).click().sendKeys(no4).build().perform();
			System.out.println(no4 +" is Selected as Mobile No");
			
			
	//Email
			
			WebElement emailId4 = driver.findElement(By.xpath("//label[text()='Email']"));
			Actions act74 = new Actions(driver);
			String id4 = sheet.getRow(i).getCell(5).getStringCellValue();
			act74.moveToElement(emailId4).click().sendKeys(id4).build().perform();
			System.out.println(id4 +" is Selected as Email Id");
			
	//EmployeeCode
					
					WebElement employeeCode4 = driver.findElement(By.xpath("//label[text()='Employee Code']"));
					Actions act84 = new Actions(driver);
					String employeeCodename4 = sheet.getRow(i).getCell(6).getStringCellValue();
					act84.moveToElement(employeeCode4).click().sendKeys(employeeCodename4).build().perform();
					System.out.println(employeeCodename4 +" is Selected as Employee Code");	
		
	
		
	//Account Manager No
				
				
				WebElement accmanagerNo4 = driver.findElement(By.xpath("//label[text()='Account Manager No']"));
				Actions act834 = new Actions(driver);
				String managerNo4 = String.valueOf((long) sheet.getRow(i).getCell(7).getNumericCellValue());
				act834.moveToElement(accmanagerNo4).click().sendKeys(managerNo4).build().perform();
				System.out.println(managerNo4 +" is Selected as Account Manager No");
		
		
	//Products 
				WebElement prdtc44 = driver.findElement(By.xpath("(//button[@title='Open'])[6]"));
				prdtc44.click();

			WebElement unlisted45= driver.findElement(By.xpath("//li[text()='UNLISTED']"));
			unlisted45.click();
				System.out.println("UNLISTED is selected as Product");
				//driver.navigate().to("http://192.168.1.35:3000/UserDashboard");
			System.out.println("=====");
			
//Submit
			
			WebElement submit3 = driver.findElement(By.xpath("//button[text()='Submit']"));
			Actions act104 = new Actions(driver);
			act104.moveToElement(submit3).click().build().perform();
			System.out.println("Submit button is working");

			System.out.println("=====");
		}
		
		}
		
		
		@AfterMethod
		public void afterClass4() {
			//driver.navigate().to("http://192.168.1.35:3000/UserDashboard");
			//driver.manage().window().maximize();
		}
		
		@AfterClass
		public void end() {
			System.out.println("Test End");
		}
	
		
}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

			
	



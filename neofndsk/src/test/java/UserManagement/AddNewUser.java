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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
		userManagement.clickOnUserManagement();
		
		String userManagementurl = driver.getCurrentUrl();
		System.out.println(userManagementurl);
			
//AddNewUser		
		WebElement addNewUser= driver.findElement(By.xpath("//button[text()='Add New User']"));
		addNewUser.click();	
	}	
	
//SelectUserType
		@BeforeMethod
		public void selectUserType() {
		WebElement selectUserType = driver.findElement(By.xpath("//label[text()='Select User Type']"));
		Actions act = new Actions(driver);
		act.moveToElement(selectUserType).click().build().perform();
		System.out.println("=====");
	}
		//Admin
	@Test
	public void selectAdmin() {
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
	}
	
	/*
		WebElement close = driver.findElement(By.xpath("//button[@title='Clear']"));
		close.click();
		System.out.println("=====");
		WebElement userTypeScroll1 = driver.findElement(By.xpath("(//button[@aria-label='Open'])[2]"));
		userTypeScroll1.click(); */
	
	
//Backoffice			
		@Test(enabled=false)
		public void selectBackOffice() {

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
		}
		/*WebElement close2 = driver.findElement(By.xpath("//button[@title='Clear']"));
		close2.click();
		System.out.println("=====");
		WebElement userTypeScroll2 = driver.findElement(By.xpath("(//button[@aria-label='Open'])[2]"));
		userTypeScroll2.click(); */
		
//Distributor
		@Test(enabled=false)
		public void selectDistributor() {
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
		}
		/*WebElement close3 = driver.findElement(By.xpath("//button[@title='Clear']"));
		close3.click();
		System.out.println("=====");
		WebElement userTypeScroll3 = driver.findElement(By.xpath("(//button[@aria-label='Open'])[2]"));
		userTypeScroll3.click();*/
		
//Manufacture
		@Test(enabled=false)
		public void selectManufacture() {
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
		}
		
		/*WebElement close4 = driver.findElement(By.xpath("//button[@title='Clear']"));
		close4.click();
		System.out.println("=====");
		WebElement userTypeScroll4 = driver.findElement(By.xpath("(//button[@aria-label='Open'])[2]"));
		userTypeScroll4.click(); */
	
//SelectUserRole
	@Test(priority = 2)
	public void selectUserRole()
	{	
		WebElement selectUserRole = driver.findElement(By.xpath("//label[text()='Select User Role']"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(selectUserRole).click().build().perform();
		System.out.println("=====");
		
//Individual
	    WebElement individual= driver.findElement(By.xpath("//li[text()='Individual']"));
		individual.click();
		
		WebElement individualresult = driver.findElement(By.xpath("//input[@value='Individual']"));
		String indvresult=individualresult.getAttribute("value");
		if (indvresult.equals("Individual"))
		{
			System.out.println("individual tab is selected in User Role");
		}
		else
		{
			System.out.println("individual tab is not selected in User Role");
		}
	}/*
		WebElement close = driver.findElement(By.xpath("(//button[@title='Clear'])[2]"));
		close.click();
		System.out.println("=====");
		WebElement userRoleScroll1 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
		userRoleScroll1.click();*/
		
//CompanyHead
		@Test(enabled=false)
		public void selectCompanyHead()
		{
			WebElement userRoleScroll1 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
			userRoleScroll1.click();
		WebElement companyHead= driver.findElement(By.xpath("//li[text()='Company Head']"));
		companyHead.click();
		
		WebElement companyHeadresult = driver.findElement(By.xpath("//input[@value='Company Head']"));
		String cmpnyresult=companyHeadresult.getAttribute("value");
		if (cmpnyresult.equals("CompanyHead"))
		{
			System.out.println("CompanyHead tab is selected in User Role");
		}
		else
		{
			System.out.println("CompanyHead tab is not selected in User Role");
		}
		}/*
		WebElement close2 = driver.findElement(By.xpath("(//button[@title='Clear'])[2]"));
		close2.click();
		System.out.println("=====");
		;*/

//GroupHead
		@Test(enabled=false)
		public void selectGroupHead()
		{
			WebElement userRoleScroll2 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
			userRoleScroll2.click();
		WebElement groupHead= driver.findElement(By.xpath("//li[text()='Group Head']"));
		groupHead.click();
		
		WebElement groupHeadresult = driver.findElement(By.xpath("//input[@value='Group Head']"));
		String ghresult=groupHeadresult.getAttribute("value");
		if (ghresult.equals("Group Head"))
		{
			System.out.println("Group Head tab is selected in User Role");
		}
		else
		{
			System.out.println("Group Head tab is not selected in User Role");
		}
		}
		
		/*WebElement close3 = driver.findElement(By.xpath("(//button[@title='Clear'])[2]"));
		close3.click();
		System.out.println("=====");
		*/
		
		
//TeamLead
		@Test(enabled=false)
		public void selectTeamLeader()
		{
			WebElement userRoleScroll3 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
			userRoleScroll3.click();
		WebElement teamLead= driver.findElement(By.xpath("//li[text()='Team Lead']"));
		teamLead.click();
		
		WebElement teamLeadresult = driver.findElement(By.xpath("//input[@value='Team Lead']"));
		String tlresult=teamLeadresult.getAttribute("value");
		if (tlresult.equals("Group Head"))
		{
			System.out.println("Team Lead tab is selected in User Role");
		}
		else
		{
			System.out.println("Team Lead tab is not selected in User Role");
		}
		}
		/*
		WebElement close4 = driver.findElement(By.xpath("(//button[@title='Clear'])[2]"));
		close4.click();
		System.out.println("=====");
		*/
		
//SelectBroker
		@Test(priority = 3)
		public void selectBrokertab()
		{	
			WebElement userRoleScroll4 = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
			userRoleScroll4.click();
		/*WebElement selectBroker = driver.findElement(By.xpath("//label[text()='Select Broker']"));
		Actions act2 = new Actions(driver);
		act2.moveToElement(selectBroker).click().build().perform();
		//selectBroker.sendKeys("kkkkkkk");
		*/
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
		System.out.println("=====");
		}  
//FirstName
		@Test(priority = 3)
		public void selectFirstName()
		{
		WebElement firstName = driver.findElement(By.xpath("//label[text()='First Name']"));
		Actions act3 = new Actions(driver);
		String name = new String("qwertrtyy");
		act3.moveToElement(firstName).click().sendKeys(name).build().perform();
		System.out.println(name+" is Selected as First Name");
		
		
		}
//MiddleName
		@Test(priority = 4)
		public void selectMiddleName()
		{
		WebElement middleName = driver.findElement(By.xpath("//label[text()='Middle Name']"));
		Actions act4 = new Actions(driver);
		String middle = new String("fsfssfscs");
		act4.moveToElement(middleName).click().sendKeys(middle).build().perform();
		System.out.println(middle+" is Selected as Middle Name");
		
		}
//LastName
		@Test(priority = 5)
		public void selectLastName()
		{
		WebElement lastName = driver.findElement(By.xpath("//label[text()='Last Name']"));
		Actions act5 = new Actions(driver);
		String last = new String("udududud");
		act5.moveToElement(lastName).click().sendKeys(last).build().perform();
		System.out.println(last+" is Selected as Last Name");
		
		}
//MobileNo
		@Test(priority = 6)
		public void selectMobileNo()
		{
		WebElement mobileNo = driver.findElement(By.xpath("//label[text()='Mobile No']"));
		Actions act6 = new Actions(driver);
		String no = new String("9112345678");
		act6.moveToElement(mobileNo).click().sendKeys(no).build().perform();
		System.out.println(no+" is Selected as Mobile No");
		
		}
//Email
		@Test(priority = 7)
		public void selectEmailId()
		{
		WebElement emailId = driver.findElement(By.xpath("//label[text()='Email']"));
		Actions act7 = new Actions(driver);
		String id = new String("lalala@gmail.com");
		act7.moveToElement(emailId).click().sendKeys(id).build().perform();
		System.out.println(id+" is Selected as Email Id");
		
		}
//EmployeeCode
		@Test(priority = 8)
		public void selectEmployeeCode()
		{
		WebElement employeeCode = driver.findElement(By.xpath("//label[text()='Employee Code']"));
		Actions act8 = new Actions(driver);
		String employeeCodename = new String("hhh111");
		act8.moveToElement(employeeCode).click().sendKeys(employeeCodename).build().perform();
		System.out.println(employeeCodename+" is Selected as Employee Code");
		
		}
//SelectManager
		@Test(priority = 9)
		public void selectManager()
		{
		WebElement selectManager = driver.findElement(By.xpath("//label[text()='Select Manager']"));
		Actions act9 = new Actions(driver);
		act9.moveToElement(selectManager).click().build().perform();
		
		WebElement IV003= driver.findElement(By.xpath("//li[text()='IV003']"));
		IV003.click();
		
		WebElement managerresult = driver.findElement(By.xpath("//input[@value='IV003']"));
		String mresult=managerresult.getAttribute("value");
		if (mresult.equals("IV003"))
		{
			System.out.println("IV003 tab is selected as manager");
		}
		else
		{
			System.out.println("IV003 tab is not selected as manager");
		}
		
		System.out.println("=====");
		}
		
		
//User Company
		@Test(enabled = false)
		public void selectUserCompany()
		{
		WebElement selectUserCompany = driver.findElement(By.xpath("//label[text()='User Company']"));
		Actions act9 = new Actions(driver);
		act9.moveToElement(selectUserCompany).click().build().perform();
		}
		/*WebElement IV003= driver.findElement(By.xpath("//li[text()='IV003']"));
		IV003.click();
		
		WebElement managerresult = driver.findElement(By.xpath("//input[@value='IV003']"));
		String mresult=managerresult.getAttribute("value");
		if (mresult.equals("IV003"))
		{
			System.out.println("IV003 tab is selected as manager");
		}
		else
		{
			System.out.println("IV003 tab is not selected as manager");
		}
		
		System.out.println("=====");
		}*/
		
//Submit
		@Test(enabled=false)
		public void submitbutton()
		{
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		Actions act10 = new Actions(driver);
		act10.moveToElement(submit).click().build().perform();
		}
		
		
		
		@AfterMethod
		public void afterClass4() {
			driver.manage().window().maximize();
		}
		@AfterClass
		public void end() {
			System.out.println("Test End");
		}

			
			
			
	}



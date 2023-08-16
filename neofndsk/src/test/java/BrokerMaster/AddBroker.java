 package BrokerMaster;

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

import pages.BrokerMaster;
import pages.Homepage;

public class AddBroker {

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

		 brokerMaster =new BrokerMaster(driver);
		brokerMaster.clickOnBrokerMaster();
		String brokerPage =driver.getCurrentUrl();
		if(brokerPage.equals("https://neofindesk.com/brokerMaster"))
		{
			System.out.println("Broker master tab is selected");
		}
		else 
		{
			System.out.println("Broker master tab is not selected");
		}
		brokerMaster.clickOnAddBroker();
		System.out.println("===");

		}
	
		@Test
		public void test1()
		{	
		

//BrokerName	
		WebElement selectBrokerName = driver.findElement(By.xpath("//label[text()='Broker Name']"));
		Actions act = new Actions(driver);
		String name = new String("hhh111");
		act.moveToElement(selectBrokerName).sendKeys(name).build().perform();
		System.out.println(name+" is Selected as Broker Name");  
		System.out.println("===");
		
//Country			
		WebElement dropDown = driver.findElement(By.xpath("//button[@title='Open']"));
		dropDown.click();
		WebElement country = driver.findElement(By.xpath("//li[text()='India']"));
		country.click();

//State			
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		boolean result1=state.isDisplayed();
		if(result1==true)
		{
			System.out.println("State tab is displayed");
		}
		else
		{
			System.out.println("State tab is not displayed");
		}
		System.out.println("===");
		
		
		WebElement statedDropDown = driver.findElement(By.xpath("(//button[@title='Open'])[2]"));
		statedDropDown.click();
		
		WebElement State = driver.findElement(By.xpath("//li[text()='Bihar']"));
		State.click();
		
//City		
		WebElement cityName = driver.findElement(By.xpath("//label[text()='City']"));
		Actions act3 = new Actions(driver);
		String city = new String("Patna");
		act3.moveToElement(cityName).click().sendKeys(city).build().perform();
		System.out.println(city+" is Selected as City");  
		System.out.println("===");
		
//AddressLine1	
		WebElement addressline1 = driver.findElement(By.xpath("//label[text()='Address Line 1']"));
		Actions act4 = new Actions(driver);
		String addrline1 = new String("lllll");
		act4.moveToElement(addressline1).click().sendKeys(addrline1).build().perform();
		System.out.println(addrline1+" is Selected as Address line 1");  
		System.out.println("===");
		
//AddressLine2
		WebElement addressline2 = driver.findElement(By.xpath("//label[text()='Address Line 2']"));
		Actions act5 = new Actions(driver);
		String addrline2 = new String("lllll");
		act5.moveToElement(addressline2).click().sendKeys(addrline2).build().perform();
		System.out.println(addrline2+" is Selected as Address line 2");  
		System.out.println("===");
		
//Email
		WebElement email = driver.findElement(By.xpath("//label[text()='Email']"));
		Actions act6 = new Actions(driver);
		String mailId = new String("lllll@gmail.com");
		act6.moveToElement(email).click().sendKeys(mailId).build().perform();
		System.out.println(mailId+" is Selected as Email");  
		System.out.println("===");

//AddressLine3
		WebElement addressline3 = driver.findElement(By.xpath("//label[text()='Address Line 3']"));
		Actions act7 = new Actions(driver);
		String addrline3 = new String("lllll");
		act7.moveToElement(addressline3).click().sendKeys(addrline3).build().perform();
		System.out.println(addrline3+" is Selected as Address line 3");  
		System.out.println("===");		
		
//Pincode
		WebElement pincode = driver.findElement(By.xpath("//label[text()='Pincode']"));
		Actions act8 = new Actions(driver);
		String pincod = new String("lllll");
		act8.moveToElement(pincode).click().sendKeys(pincod).build().perform();
		System.out.println(pincod+" is Selected as Pincode");  
		System.out.println("===");
		
//CIN number
		WebElement cinNo = driver.findElement(By.xpath("//label[text()='CIN Number']"));
		Actions act9 = new Actions(driver);
		String cin = new String("lllll");
		act9.moveToElement(cinNo).click().sendKeys(cin).build().perform();
		System.out.println(cin+" is Selected as CIN number");  
		System.out.println("===");			
		
//Gst number
		WebElement gstNo = driver.findElement(By.xpath("//label[text()='GST Number']"));
		Actions act10 = new Actions(driver);
		String gst = new String("lllll");
		act10.moveToElement(gstNo).click().sendKeys(gst).build().perform();
		System.out.println(gst+" is Selected as GST number");  
		System.out.println("===");
		
//pancard
		WebElement pancard = driver.findElement(By.xpath("//label[text()='Pancard']"));
		Actions act11 = new Actions(driver);
		String pan = new String("lllll");
		act11.moveToElement(pancard).click().sendKeys(pan).build().perform();
		System.out.println(pan+" is Selected as Pancard");  
		System.out.println("===");			
		
//BankName
		WebElement bankname = driver.findElement(By.xpath("//label[text()='Bank Name']"));
		Actions act12 = new Actions(driver);
		String banknme = new String("lllll");
		act12.moveToElement(bankname).click().sendKeys(banknme).build().perform();
		System.out.println(banknme+" is Selected as Bank Name");  
		System.out.println("===");	
		
//Account No			
		WebElement accountNo = driver.findElement(By.xpath("//label[text()='Account No']"));
		Actions act13 = new Actions(driver);
		String accntNo = new String("lllll");
		act13.moveToElement(accountNo).click().sendKeys(accntNo).build().perform();
		System.out.println(accntNo+" is Selected as Account No");  
		System.out.println("===");	
		
//Account Type
		WebElement accountType = driver.findElement(By.xpath("//label[text()='Account Type']"));
		Actions act14 = new Actions(driver);
		String accnttyp = new String("lllll");
		act14.moveToElement(accountType).click().sendKeys(accnttyp).build().perform();
		System.out.println(accnttyp+" is Selected as Account Type");  
		System.out.println("===");

//BankBranch
		WebElement bankBranch = driver.findElement(By.xpath("//label[text()='Bank Branch']"));
		Actions act15 = new Actions(driver);
		String branch = new String("lllll");
		act15.moveToElement(bankBranch).click().sendKeys(branch).build().perform();
		System.out.println(branch+" is Selected as Bank branch");  
		System.out.println("===");			

//IFSC Code		
		WebElement ifscCode = driver.findElement(By.xpath("//label[text()='IFSC Code']"));
		Actions act16 = new Actions(driver);
		String code = new String("lllll");
		act16.moveToElement(ifscCode).click().sendKeys(branch).build().perform();
		System.out.println(branch+" is Selected as IFSC code");  
		System.out.println("===");
		
//DP Name
		WebElement dpName = driver.findElement(By.xpath("//label[text()='DP Name']"));
		Actions act17 = new Actions(driver);
		String dp = new String("lllll");
		act17.moveToElement(dpName).click().sendKeys(dp).build().perform();
		System.out.println(dp+" is Selected as DP name");  
		System.out.println("===");
		
//Client Id
		WebElement clientID = driver.findElement(By.xpath("//label[text()='Client ID']"));
		Actions act18 = new Actions(driver);
		String clId = new String("lllll");
		act18.moveToElement(clientID).click().sendKeys(clId).build().perform();
		System.out.println(clId+" is Selected as Client Id");  
		System.out.println("===");
		
//DP Id
		WebElement dpID = driver.findElement(By.xpath("//label[text()='DP ID']"));
		Actions act19 = new Actions(driver);
		String dpid = new String("lllll");
		act19.moveToElement(dpID).click().sendKeys(dpid).build().perform();
		System.out.println(dpid+" is Selected as DP Id");  
		System.out.println("===");	
		
//Show Logo	
		WebElement showLogo = driver.findElement(By.xpath("//input[@type='checkbox']"));
		boolean result2=showLogo.isEnabled();
		if(result2=true)
		{
			System.out.println("Show Logo button is working");
		}
		else
		{
			System.out.println("Show Logo button not is working");
		}
		
//Broker Logo 
		WebElement brokerLogo = driver.findElement(By.xpath("//input[@name='brokerLogo']"));
		boolean result3=brokerLogo.isEnabled();
		if(result3=true)
		{
			System.out.println("Broker Logo button is working");
		}
		else
		{
			System.out.println("Broker Logo button not is working");
		}

//GST Certificate 
		WebElement gstCertificate = driver.findElement(By.xpath("//input[@name='gstNumberCertificate']"));
		boolean result4=gstCertificate.isEnabled();
		if(result4=true)
		{
			System.out.println("GST Certificate button is working");
		}
		else
		{
			System.out.println("GST Certificate button not is working");
		}
		
//Pancard Docc 
		WebElement pancardDocc = driver.findElement(By.xpath("//input[@name='pancardDoc']"));
		boolean result5=pancardDocc.isEnabled();
		if(result5=true)
		{
			System.out.println("Upload Pancard button is working");
		}
		else
		{
			System.out.println("Upload Pancard button not is working");
		}

//Register Certificate 
		WebElement registerdocc = driver.findElement(By.xpath("//input[@name='pancardDoc']"));
		boolean result6=registerdocc.isEnabled();
		if(result6=true)
		{
			System.out.println("Register certificate button is working");
		}
		else
		{
			System.out.println("Register certificate button not is working");
		}		

//Submit 			
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		boolean result7=submit.isEnabled();
		if(result7=true)
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





























/*WebElement country = driver.findElement(By.xpath("//label[text()='Country']"));
country.click();
String countryName = new String ("india");
Actions act2 = new Actions(driver);
act2.moveToElement(country).click().sendKeys(countryName).build().perform();
Select s = new Select(country);
s.getFirstSelectedOption();
WebElement dropDown = driver.findElement(By.xpath("//button[@title='Open']"));
dropDown.click();

WebElement country = driver.findElement(By.xpath("//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiAutocomplete-paper css-1km0bk1\"]"));
Actions act2 = new Actions(driver);
act2.moveToElement(country).click().sendKeys("india").build().perform();
Select s = new Select(country);
s.getFirstSelectedOption();
System.out.println("===");*/

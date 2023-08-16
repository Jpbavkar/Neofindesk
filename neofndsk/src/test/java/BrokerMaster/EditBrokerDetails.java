package BrokerMaster;

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

public class EditBrokerDetails {
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
		
		
		String data = ("admin");
		String data1 = data.toLowerCase();
		System.out.println("String enter ="+data1);
		System.out.println("=====");
		
		WebElement searchTab= driver.findElement(By.xpath("//input[@placeholder='Search Broker by name']"));
		searchTab.sendKeys(data);

		WebElement result= driver.findElement(By.xpath("//a[@href='/brokerDetails/1']"));
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
		result.click();
		}
	
	
		@Test (priority = 1)
		public void test1()
		{	
		
			
//Edit 		
			WebElement edit= driver.findElement(By.xpath("//button[text()='Edit']"));
			Actions act1 = new Actions(driver);
			act1.moveToElement(edit).click().build().perform(); 
			System.out.println("===");
	
//Country			
			WebElement country= driver.findElement(By.xpath("//label[text()='Country']"));
			Actions act2 = new Actions(driver);
			String country1 = new String("lllll");
			act1.moveToElement(country).click().sendKeys(country1).build().perform();
			System.out.println(country1+" is Selected as Country name");  
			System.out.println("===");
				
//City			
			WebElement city= driver.findElement(By.xpath("//label[text()='City']"));
			Actions act3 = new Actions(driver);
			String city1 = new String("lllll");
			act3.moveToElement(city).click().sendKeys(city1).build().perform();
			System.out.println(city1 +" is Selected as City name");  
			System.out.println("===");
			
//Pancard			
			WebElement pancard= driver.findElement(By.xpath("//label[text()='Pancard']"));
			Actions act4 = new Actions(driver);
			String pan1 = new String("lllll");
			act4.moveToElement(pancard).click().sendKeys(pan1).build().perform();
			System.out.println(pan1+" is Selected as Pancard");  
			System.out.println("===");
			
//GST Number			
			WebElement gstNo= driver.findElement(By.xpath("//label[text()='GST Number']"));
			Actions act5 = new Actions(driver);
			String gst = new String("lllll");
			act5.moveToElement(gstNo).click().sendKeys(gst).build().perform();
			System.out.println(gst+" is Selected as GST Number");  
			System.out.println("===");	
			
//Email			
			WebElement email= driver.findElement(By.xpath("//label[text()='Email']"));
			Actions act6 = new Actions(driver);
			String mail = new String("lllll");
			act6.moveToElement(email).click().sendKeys(mail).build().perform();
			System.out.println(mail+" is Selected as Email");  
			System.out.println("===");
			
//State			
			WebElement state= driver.findElement(By.xpath("//label[text()='State']"));
			Actions act7 = new Actions(driver);
			String state1 = new String("lllll");
			act7.moveToElement(state).click().sendKeys(state1).build().perform();
			System.out.println(state1 +" is Selected as State");  
			System.out.println("===");	
			
//Pincode			
			WebElement pincode= driver.findElement(By.xpath("//label[text()='Pincode']"));
			Actions act8 = new Actions(driver);
			String pin = new String("lllll");
			act8.moveToElement(pincode).click().sendKeys(pin).build().perform();
			System.out.println(pin+" is Selected as Pincode");  
			System.out.println("===");	
			
//CIN Number			
			WebElement cinNo= driver.findElement(By.xpath("//label[text()='CIN Number']"));
			Actions act9 = new Actions(driver);
			String cin = new String("lllll");
			act9.moveToElement(cinNo).click().sendKeys(cin).build().perform();
			System.out.println(cin+" is Selected as CIN Number");  
			System.out.println("===");		
			
//Address line 1			
			WebElement add1= driver.findElement(By.xpath("//label[text()='Address Line 1']"));
			Actions act10 = new Actions(driver);
			String a1 = new String("lllll");
			act10.moveToElement(add1).click().sendKeys(a1).build().perform();
			System.out.println(a1+" is Selected as Address line 1");  
			System.out.println("===");	
			
//Address line 2			
			WebElement add2= driver.findElement(By.xpath("//label[text()='Address Line 2']"));
			Actions act11 = new Actions(driver);
			String a2 = new String("lllll");
			act11.moveToElement(add2).click().sendKeys(a2).build().perform();
			System.out.println(a2+" is Selected as Address line 2");  
			System.out.println("===");		
			
//Address line 3			
			WebElement add3= driver.findElement(By.xpath("//label[text()='Address Line 3']"));
			Actions act12 = new Actions(driver);
			String a3 = new String("lllll");
			act12.moveToElement(add3).click().sendKeys(a3).build().perform();
			System.out.println(a3+" is Selected as Address line 2");  
			System.out.println("===");	
	
//Bank Name			
			WebElement bankName= driver.findElement(By.xpath("//label[text()='Bank Name']"));
			Actions act13 = new Actions(driver);
			String bnkname = new String("lllll");
			act13.moveToElement(bankName).click().sendKeys(bnkname).build().perform();
			System.out.println(bnkname +" is Selected as Bank name");  
			System.out.println("===");
			
//Account No			
			WebElement accountNo= driver.findElement(By.xpath("//label[text()='Account No']"));
			Actions act14 = new Actions(driver);
			String accNo = new String("lllll");
			act14.moveToElement(accountNo).click().sendKeys(accNo).build().perform();
			System.out.println(accNo+" is Selected as Account No");  
			System.out.println("===");	
				
//Bank Branch			
			WebElement bankBranch = driver.findElement(By.xpath("//label[text()='Bank Branch']"));
			Actions act15 = new Actions(driver);
			String branch = new String("lllll");
			act15.moveToElement(bankBranch).click().sendKeys(branch).build().perform();
			System.out.println(branch +" is Selected as Bank Branch");  
			System.out.println("===");
			
//IFSC code			
			WebElement ifscCode = driver.findElement(By.xpath("//label[text()='IFSC Code']"));
			Actions act16 = new Actions(driver);
			String ifsc = new String("lllll");
			act16.moveToElement(ifscCode).click().sendKeys(ifsc).build().perform();
			System.out.println(ifsc+" is Selected as IFSC Code");  
			System.out.println("===");
			
//Account Type			
			WebElement accType = driver.findElement(By.xpath("//label[text()='Account Type']"));
			Actions act20 = new Actions(driver);
			String type = new String("lllll");
			act20.moveToElement(accType).click().sendKeys(type).build().perform();
			System.out.println(type+" is Selected as IFSC Code");  
			System.out.println("===");
			
//DP Id			
			WebElement dpId = driver.findElement(By.xpath("//label[text()='DP ID']"));
			Actions act17 = new Actions(driver);
			String dpid = new String("lllll");
			act17.moveToElement(dpId).click().sendKeys(dpid).build().perform();
			System.out.println(dpid+" is Selected as DP ID");  
			System.out.println("===");
				
//DP Name			
			WebElement dpName = driver.findElement(By.xpath("//label[text()='DP Name']"));
			Actions act18 = new Actions(driver);
			String dpname = new String("lllll");
			act18.moveToElement(dpName).click().sendKeys(dpname).build().perform();
			System.out.println(dpname +" is Selected as DP Name");  
			System.out.println("===");
				
//Client Id			
			WebElement clientID = driver.findElement(By.xpath("//label[text()='Client ID']"));
			Actions act19 = new Actions(driver);
			String clID = new String("lllll");
			act19.moveToElement(clientID).click().sendKeys(clID).build().perform();
			System.out.println(clID +" is Selected as Client ID");  
			System.out.println("===");
				
//Show Logo   
			WebElement showLogo = driver.findElement(By.xpath("//input[@type='checkbox']"));
			boolean result1 = showLogo.isEnabled();
			if (result1=true)
			{
				System.out.println("Show logo button is working");
			}
			else
			{
				System.out.println("Show logo button is not working");
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
			boolean result13=submit.isEnabled();
			if(result13=true)
			{
				System.out.println("Submit button is working");
			}
			else
			{
				System.out.println("Submit button not is working");
			}
			//submit.click();
				
			
			
			
				
//Active 			
			WebElement active = driver.findElement(By.xpath("//button[text()='Active']"));
			boolean result12=active.isEnabled();
			if(result12=true)
			{
				System.out.println("Active button is working");
			}
			else
			{
				System.out.println("Active button not is working");
			}	
			//active.click();
				
			
			
			
				
//Cancel 			
			WebElement cancel = driver.findElement(By.xpath("//button[text()='Cancel']"));
			boolean result11=cancel.isEnabled();
			if(result11=true)
			{
				System.out.println("Cancel button is working");
			}
			else
			{
				System.out.println("Cancel button not is working");
			}			
			//cancel.click();
			
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

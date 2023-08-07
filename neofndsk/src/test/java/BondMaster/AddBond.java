package BondMaster;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import pages.BondMaster;
import pages.Homepage;

public class AddBond {

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

		WebElement addBond = driver.findElement(By.xpath("//a[text()='Add Bond']"));
		boolean result2 = addBond.isEnabled();
		if(result2 = true)
		{
			System.out.println("Add bond button is working ");
		}
		else
		{
			System.out.println("Add bond button is not working ");
		}
		addBond.click();
	}
		
	@Test
	public void test1()
	{
		
		
//ISIN Number			
		WebElement isinNo = driver.findElement(By.xpath("//label[text()='ISIN']"));
		Actions act1 = new Actions(driver);
		String isin = new String("INE001A07TV9");
		act1.moveToElement(isinNo).click().sendKeys(isin).build().perform();
		System.out.println(isin +" is Selected as ISIN Number");  
		System.out.println("===");
		
//Bond Type			
		WebElement bondType = driver.findElement(By.xpath("//label[text()='Bond Type']"));
		WebElement bondDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[1]"));
		bondDropdown.click();
		WebElement gsec = driver.findElement(By.xpath("//li[text()='G Sec']"));
		gsec.click();  
		System.out.println("===");
		
		/*Actions act2 = new Actions(driver);
		String type = new String("lllll");
		act2.moveToElement(bondType).click().sendKeys(type).build().perform();
		System.out.println(type +" is Selected as Address line 1");  
		System.out.println("===");	*/		

//dayCountConvection	
		WebElement dayCountConvection = driver.findElement(By.xpath("//label[text()='Day Count Convention']"));
		WebElement countDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[2]"));
		countDropdown.click();
		WebElement opt30 = driver.findElement(By.xpath("//li[text()='30 / 360']"));
		opt30.click();  
		System.out.println("===");
		
		
//Issuer Name			
		WebElement issuerName = driver.findElement(By.xpath("//label[text()='Issuer Name']"));
		Actions act2 = new Actions(driver);
		String issuenam = new String("lllll");
		act2.moveToElement(issuerName).click().sendKeys(issuenam).build().perform();
		System.out.println(issuenam +" is Selected as Issuer Name");  
		System.out.println("===");			
		
		
//Issuer Type	
		WebElement issuerType = driver.findElement(By.xpath("//label[text()='Issuer Type']"));
		WebElement issueDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[3]"));
		issueDropdown.click();
		WebElement nbfc = driver.findElement(By.xpath("//li[text()='NBFC']"));
		nbfc.click();  
		System.out.println("===");		

//Coupon Basis		
		WebElement couponBasis = driver.findElement(By.xpath("//label[text()='Coupon Basis']"));
		WebElement couponDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[4]"));
		couponDropdown.click();
		WebElement cpn1 = driver.findElement(By.xpath("//li[text()='Fixed Rate']"));
		cpn1.click();
		System.out.println("===");
		
		
//Coupon			
		WebElement coupon = driver.findElement(By.xpath("//label[text()='Coupon']"));
		
		Actions act3 = new Actions(driver);
		String cpn = new String("lllll");
		act3.moveToElement(coupon).click().sendKeys(cpn).build().perform();
		System.out.println(cpn +" is Selected as ISIN Number");  
		System.out.println("===");		
		
//Coupon Frequency
		WebElement couponFrequency = driver.findElement(By.xpath("//label[text()='Coupon Frequency']"));
		WebElement frequencyDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[5]"));
		frequencyDropdown.click();
		WebElement annual = driver.findElement(By.xpath("//li[text()='Annual']"));
		annual.click();  
		System.out.println("===");
		
//CallPut Date 			
		WebElement callPutDate = driver.findElement(By.xpath("//label[text()='Call Put Date']"));
		WebElement callputdownDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[6]"));
		callputdownDropdown.click();
		WebElement yes = driver.findElement(By.xpath("//li[text()='Yes']"));
		yes.click();  

//Call Date			
		WebElement calldateTab = driver.findElement(By.xpath("//label[text()='Call Date']"));
		boolean callDate =calldateTab.isEnabled();
		if (callDate=true)
		{
			System.out.println("Call Date tab is visibled");
		}
		else
		{
			System.out.println("Call Date tab is not visibled");
		}
		calldateTab.click();
		WebElement edit = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']"));
		edit.click();
		WebElement dateChange1 = driver.findElement(By.xpath("(//input[@value='07/04/2022'])[5]"));
		String value=dateChange1.getAttribute("value");
		if(value != null)
		{
			int valln=value.length();
			System.out.println(value.length());
			for(int i=0 ; i < valln ; i++)
			{
				dateChange1.sendKeys(Keys.BACK_SPACE);	
		    }
		}
		dateChange1.sendKeys("08022023");
			
		WebElement ok = driver.findElement(By.xpath("//button[text()='OK']"));
		ok.click();
		System.out.println("===");
			
//Put Date
			
		WebElement putdateTab = driver.findElement(By.xpath("//label[text()='Put Date']"));
		boolean putDate =putdateTab.isEnabled();
		if (putDate=true)
		{
			System.out.println("Put Date tab is visibled");
			}
		else
		{
			System.out.println("Put Date tab is not visibled");
			}
		putdateTab.click();
		WebElement edit2 = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']"));
		edit2.click();
		System.out.println("===");
		WebElement putChange2 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[15]"));
		String change =putChange2.getAttribute("value");
	
		System.out.println(change);
		if(change != null)
		{
			int changel=change.length();
			for(int i=0 ; i< changel ; i++)
			{
				
				putChange2.sendKeys(Keys.BACK_SPACE);
			}
		}
		putChange2.sendKeys("03042023");
		WebElement ok2 = driver.findElement(By.xpath("//button[text()='OK']"));
		ok2.click();
		System.out.println("===");
			
		
//Insurance date
		WebElement insurancedateTab = driver.findElement(By.xpath("//label[text()='Issuance Date']"));
		boolean insuranceDate =insurancedateTab.isEnabled();
		if (insuranceDate=true)
		{
			System.out.println("Issuance Date tab is visibled");
		}
		else
		{
			System.out.println("Issuance Date tab is not visibled");
		}
		insurancedateTab.click();
		WebElement edit3 = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']"));
		edit3.click();
		System.out.println("===");
		WebElement dateChange2 = driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-9r82vl']/input[@value='07/04/2022']"));
		String value2=dateChange2.getAttribute("value");
		if(value2 != null)
		{
			int valln2=value2.length();
			for(int i=0 ; i < valln2 ; i++)
			{
				dateChange2.sendKeys(Keys.BACK_SPACE);	
			}
		}
		dateChange2.sendKeys("04062024");
			
		WebElement ok3 = driver.findElement(By.xpath("//button[text()='OK']"));
		ok3.click();
		System.out.println("===");
			
		
//Maturity date
		WebElement maturitydateTab = driver.findElement(By.xpath("//label[text()='Maturity Date']"));
		boolean maturityDate =maturitydateTab.isEnabled();
		if (maturityDate=true)
		{
			System.out.println("Maturity Date tab is visibled");
		}
		else
		{
			System.out.println("Maturity Date tab is not visibled");
		}
		maturitydateTab.click();
		WebElement edit4 = driver.findElement(By.xpath("//button[@aria-label='calendar view is open, go to text input view']"));
		edit4.click();
		System.out.println("===");
		WebElement dateChange3 = driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-fullWidth MuiInputBase-formControl MuiInputBase-sizeSmall css-9r82vl']/input[@value='07/04/2022']"));
		String value3=dateChange3.getAttribute("value");
		if(value3 != null)
		{
			int valln3=value3.length();
			for(int i=0 ; i < valln3 ; i++)
			{
				dateChange3.sendKeys(Keys.BACK_SPACE);	
			}
		}
		dateChange3.sendKeys("04062024");
			
		WebElement ok4 = driver.findElement(By.xpath("//button[text()='OK']"));
		ok4.click();
		System.out.println("===");
			
//Face Value			
	WebElement faceValue = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[4]"));
	Actions face =new Actions (driver);
	String vale = new String("04062024");
	face.moveToElement(faceValue).click().sendKeys(vale).build().perform();
	System.out.println("==="); 
	
	
//Seniority Of Repayment
			
	WebElement seniorityOfRepayment = driver.findElement(By.xpath("//label[text()='Seniority Of Repayment']"));
	WebElement RepaymentDropdown = driver.findElement(By.xpath("(//button[@title='Open'])[7]"));
	RepaymentDropdown.click();
	WebElement senior = driver.findElement(By.xpath("//li[text()='Senior']"));
	senior.click();  
	System.out.println("===");
		
		
//Secured Unsecured
	
			WebElement securedUnsecured = driver.findElement(By.xpath("//label[text()='Secured Unsecured']"));
			WebElement securedUnsecureddropdown = driver.findElement(By.xpath("(//button[@title='Open'])[8]"));
			securedUnsecureddropdown.click();
			WebElement secured = driver.findElement(By.xpath("//li[text()='Secured']"));
			secured.click();  
			System.out.println("===");		
		
		
//Government Gauranteed			
			WebElement governmentGauranteed = driver.findElement(By.xpath("//label[text()='Government Gauranteed']"));
			WebElement governmentGauranteeddropdown = driver.findElement(By.xpath("(//button[@title='Open'])[9]"));
			governmentGauranteeddropdown.click();
			WebElement stateGovernment = driver.findElement(By.xpath("//li[text()='State Government']"));
			stateGovernment.click();  
			System.out.println("===");
		
//Tier			
			WebElement tier = driver.findElement(By.xpath("//label[text()='Tier']"));
			WebElement tierdropdown = driver.findElement(By.xpath("(//button[@title='Open'])[10]"));
			tierdropdown.click();
			WebElement tier1 = driver.findElement(By.xpath("//li[text()='TIER 1']"));
			tier1.click();  
			System.out.println("===");
			
//PSU Non-PSU			
			WebElement psu = driver.findElement(By.xpath("//label[text()='PSU Non-PSU']"));
			WebElement psudropdown = driver.findElement(By.xpath("(//button[@title='Open'])[11]"));
			psudropdown.click();
			WebElement PSU = driver.findElement(By.xpath("//li[text()='PSU']"));
			PSU.click();  
			System.out.println("===");				
			
//Taxability			
			WebElement taxability = driver.findElement(By.xpath("//label[text()='Taxability']"));
			WebElement taxabilitydropdown = driver.findElement(By.xpath("(//button[@title='Open'])[12]"));
			taxabilitydropdown.click();
			WebElement taxable = driver.findElement(By.xpath("//li[text()='Taxable']"));
			taxable.click();  
			System.out.println("===");		
			
//Record Days			
			WebElement recordDays = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[5]"));
			Actions record =new Actions (driver);
			String day = new String("04062024");
			record.moveToElement(recordDays).click().sendKeys(day).build().perform();
			System.out.println("==="); 			

//Mode Of Issuance			
			WebElement modeOfIssuance = driver.findElement(By.xpath("//label[text()='Mode Of Issuance']"));
			WebElement modeOfIssuancedropdown = driver.findElement(By.xpath("(//button[@title='Open'])[13]"));
			modeOfIssuancedropdown.click();
			WebElement publicIssue = driver.findElement(By.xpath("//li[text()='Public Issue']"));
			publicIssue.click();  
			System.out.println("===");

//Listed Unlisted	
			WebElement listedUnlisted = driver.findElement(By.xpath("//label[text()='Listed Unlisted']"));
			WebElement listedUnlisteddropdown = driver.findElement(By.xpath("(//button[@title='Open'])[14]"));
			listedUnlisteddropdown.click();
			WebElement listed = driver.findElement(By.xpath("//li[text()='Listed']"));
			listed.click();  
			System.out.println("===");
			
//Stepup Stepdown
			WebElement stepupStepdown = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[6]"));
			Actions stepup =new Actions (driver);
			String Stepdown = new String("04062024");
			stepup.moveToElement(stepupStepdown).click().sendKeys(Stepdown).build().perform();
			System.out.println("==="); 	
		
//Remarks
			WebElement remarks = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[7]"));
			Actions rem =new Actions (driver);
			String marks = new String("04062024");
			rem.moveToElement(remarks).click().sendKeys(marks).build().perform();
			System.out.println("==="); 	
			
//RTA Details
			WebElement rtaDetails = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[8]"));
			Actions rta =new Actions (driver);
			String details = new String("04062024");
			rta.moveToElement(rtaDetails).click().sendKeys(details).build().perform();
			System.out.println("==="); 	
			
//Debenture Trustee
			WebElement debentureTrustee = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[9]"));
			Actions deb =new Actions (driver);
			String trustee = new String("04062024");
			deb.moveToElement(debentureTrustee).click().sendKeys(trustee).build().perform();
			System.out.println("==="); 	
		
//Interest Payment Dates
			WebElement interestDates = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[10]"));
			Actions interest =new Actions (driver);
			String dates2 = new String("04062024");
			interest.moveToElement(interestDates).click().sendKeys(dates2).build().perform();
			System.out.println("==="); 	
			
//Rating 1
			WebElement rating1 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[11]"));
			Actions rat1 =new Actions (driver);
			String rate1 = new String("04062024");
			rat1.moveToElement(rating1).click().sendKeys(rate1).build().perform();
			System.out.println("==="); 	
			
//Rating 2
			WebElement rating2 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[12]"));
			Actions rat2 =new Actions (driver);
			String rate2 = new String("04062024");
			rat2.moveToElement(rating2).click().sendKeys(rate2).build().perform();
			System.out.println("==="); 	
			
//Rating 3
			WebElement rating3 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[13]"));
			Actions rat3 =new Actions (driver);
			String rate3 = new String("04062024");
			rat3.moveToElement(rating3).click().sendKeys(rate3).build().perform();
			System.out.println("==="); 	
			
//Abbrevation
			WebElement abbrevation = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[14]"));
			Actions abb =new Actions (driver);
			String abbrevation1 = new String("04062024");
			abb.moveToElement(abbrevation).click().sendKeys(abbrevation1).build().perform();
			System.out.println("=========="); 	
		
//Upload Logo
			WebElement uploadLogo = driver.findElement(By.xpath("//label[text()='Upload Logo']"));
			boolean result=uploadLogo.isEnabled();
			if(result=true)
			{
				System.out.println("Upload Logo button is working");
			}
			else
			{
				System.out.println("Upload Logo button not is working");
			}	
			
//Upload IM Document
			WebElement uploadImDocc = driver.findElement(By.xpath("//label[text()='Upload IM Document']"));
			boolean upload=uploadImDocc.isEnabled();
			if(upload=true)
			{
				System.out.println("Upload IM Document button is working");
			}
			else
			{
				System.out.println("Upload IM Document button not is working");
			}
			
//Face Value			
			WebElement faceValue2 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng'])[4]"));
			Actions face2 =new Actions (driver);
			String vale2 = new String("04062024");
			face2.moveToElement(faceValue2).click().sendKeys(vale2).build().perform();
			System.out.println("==="); 
//}
	//@Test
	//public void submit() {
	
//Submit
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
		boolean save=submit.isEnabled();
		if(save=true)
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


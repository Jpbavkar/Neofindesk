package BondMaster;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BondMaster;
import pages.Homepage;
import pages.ProductType;

public class EditBondDetails {
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
	
		
driver.navigate().to("http://192.168.1.33:3000/");
			
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

		String data = ("andhra");
		String data1 = data.toLowerCase();
		System.out.println("String enter ="+data1);
		System.out.println("=====");
		
		WebElement searchTab= driver.findElement(By.xpath("//input[@placeholder='Search Bond by Issuer Name Or ISIN.']"));
		searchTab.sendKeys(data);

		WebElement result= driver.findElement(By.xpath("//a[@class='MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-ranc02']"));
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
		
	@Test (enabled=false)
	public void addSpread()
	{
		//Add Spread	
				WebElement addSpread = driver.findElement(By.xpath("//button[text()='Add Spread']"));
				boolean add=addSpread.isEnabled();
				if(add=true)
				{
					System.out.println("Add Spread button is working");
				}
				else
				{
					System.out.println("Add Spread button not is working");
				}		
				//addSpread.click();	
	}
	
	@Test(enabled=false)
	public void approve()
	{
		//Approve	
		WebElement approve = driver.findElement(By.xpath("//button[text()='Approve']"));
		boolean app=approve.isEnabled();
		if(app=true)
		{
			System.out.println("Approve button is working");
		}
		else
		{
			System.out.println("Approve button not is working");
		}
		//approve.click();	
		
	}
	
	@Test 
	public void submit()
	{
		//Submit	
		WebElement submit = driver.findElement(By.xpath("//a[text()='Submit']"));
		boolean ok=submit.isEnabled();
		if(ok=true)
		{
			System.out.println("Submit button is working");
		}
		else
		{
			System.out.println("Submit button not is working");
		}
		submit.click();
		
//Select Client SearchTab
		WebElement selectClient = driver.findElement(By.xpath("//button[@title='Open']"));
		boolean sclient=selectClient.isEnabled();
		if(sclient=true)
		{
			System.out.println("Select Client tab is working");
		}
		else
		{
			System.out.println("Select Client tab not is working");
		}	
		
//Add New Client
		WebElement addNewClient = driver.findElement(By.xpath("//button[text()='Add New Client']"));
		boolean client=addNewClient.isEnabled();
		if(client=true)
		{
			System.out.println("Add New Client button is working");
		}
		else
		{
			System.out.println("Add New Client button not is working");
		}

//Submit 2
		WebElement submit2 = driver.findElement(By.xpath("//button[text()='Submit']"));
		boolean ok2=submit2.isEnabled();
		if(ok2=true)
		{
			System.out.println("Submit button is working");
		}
		else
		{
			System.out.println("Submit button not is working");
		}
		

	}
	
	@Test
	public void updateCashflow()
	{
		//Update Cashflow	
		WebElement updateCashflow = driver.findElement(By.xpath("//a[text()='Update Cashflow']"));
		boolean flow=updateCashflow.isEnabled();
		if(flow=true)
		{
			System.out.println("Update Cashflow button is working");
		}
		else
		{
			System.out.println("Update Cashflow button not is working");
		}	

//Edit Symbol	
		WebElement edit = driver.findElement(By.xpath("(//button[@aria-label='Edit'])[1]"));
		boolean e=edit.isEnabled();
		if(e=true)
		{
			System.out.println("Edit button is working");
		}
		else
		{
			System.out.println("Edit button not is working");
		}	

//Save Symbol	
		WebElement save = driver.findElement(By.xpath("//button[@aria-label='Save']"));
		boolean s=save.isEnabled();
		if(s=true)
		{
			System.out.println("Save button is working");
		}
		else
		{
			System.out.println("Save button not is working");
		}	

//Close Symbol	
		WebElement close = driver.findElement(By.xpath("//button[@aria-label='Cancel']"));
		boolean cl=close.isEnabled();
		if(cl=true)
		{
			System.out.println("Close button is working");
		}
		else
		{
			System.out.println("Close button not is working");
		}	

		
//Add +	
		WebElement addPlus = driver.findElement(By.xpath("//button[text()='Add +']"));
		boolean ad=addPlus.isEnabled();
		if(ad=true)
		{
			System.out.println("Add button is working");
		}
		else
		{
			System.out.println("Add button not is working");
		}	

		
		
		
		
//Update Bond
		WebElement updateBond = driver.findElement(By.xpath("//button[text()='Update Bond']"));
		boolean bond=updateBond.isEnabled();
		if(bond=true)
		{
			System.out.println("Update Bond button is working");
		}
		else
		{
			System.out.println("Update Bond button not is working");
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

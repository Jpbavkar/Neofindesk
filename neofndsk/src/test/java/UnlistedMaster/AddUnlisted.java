package UnlistedMaster;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import pages.UnlistedMaster;

public class AddUnlisted {

	private WebDriver driver;
	private Homepage homepage;
	private UnlistedMaster unlistedMaster;
	
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

homepage = new Homepage (driver);
homepage.clickOnLogin();
homepage.sendKeysToUserId();
homepage.sendKeysToPassword();
homepage.clickOnSubmit();
System.out.println("Homepage has been open");
System.out.println("=====");

		
}
	@BeforeMethod	
	public void beforeMethod()
		{

	    unlistedMaster = new UnlistedMaster (driver);
		unlistedMaster.clickOnunlistedMaster();
		System.out.println("Unlisted Master page is open");
		System.out.println("=====");
		unlistedMaster.clickOnAddUnlistedMaster();

	}
		
	@Test(priority =1)
	public void scriptName() throws FileNotFoundException
	{
		
//Script Name		
		String name =new String ("INVESTTECHNOLOGY");
		WebElement scriptName = driver.findElement(By.xpath("//label[text()='Script Name']"));
		Actions act1 =new Actions (driver);
		act1.moveToElement(scriptName).click().sendKeys(name).build().perform();	
	System.out.println(name+" is selected as Script Name");
	
//Isin Number	
	    String number =new String ("INE142M01333");
		WebElement isinNumber = driver.findElement(By.xpath("//label[text()='Isin Number']"));
		Actions act2 =new Actions (driver);
		act2.moveToElement(isinNumber).click().sendKeys(number).build().perform();
		System.out.println(number+" is selected as Isin Number");
	
//Face Value	
		String face =new String ("2");
		WebElement faceValue = driver.findElement(By.xpath("//label[text()='Face Value']"));
		Actions act3 =new Actions (driver);
		act3.moveToElement(faceValue).click().sendKeys(face).build().perform();
		System.out.println(face+" is selected as Isin Number");
	
//Upload Logo	
		WebElement uploadLogoButton = driver.findElement(By.xpath("//label[text()='Upload Logo']"));
		Actions act41 =new Actions (driver);
		String path = System.getProperty("project.dir");
		act41.moveToElement(uploadLogoButton).click().sendKeys("C:\\Users\\INVESTVALUE\\Downloads\\R.jpg");
	
	
	
//Upload File	
		WebElement uploadReportFile = driver.findElement(By.xpath("//label[text()='Upload Report File']"));
		boolean result2= uploadReportFile.isEnabled();
		System.out.println(result2);
		
		WebElement submit = driver.findElement(By.xpath("//button[text()=' Submit']"));
		Actions act4 =new Actions (driver);
		act4.moveToElement(submit).click().build().perform();
		
		
		
//Verification		
		String data = ("invest");
		String data1 = data.toLowerCase();
		System.out.println("String enter ="+data1);
		System.out.println("=====");
		
		WebElement searchTab= driver.findElement(By.xpath("//input[@placeholder='Search unlisted by name']"));
		searchTab.sendKeys(data);

		WebElement result= driver.findElement(By.xpath("//tbody[@class='MuiTableBody-root css-apqrd9-MuiTableBody-root']"));
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
		WebElement content = driver.findElement(By.xpath("//td[text()='"+ name +"']"));
		content.click();
		
		
		
	
	
	
		
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
package homePage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Homepage;

public class TCtHomepage {
	
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\INVESTVALUE\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.google.com");
		

			driver.navigate().to("http://192.168.1.33:3000/");
			
			Homepage homepage = new Homepage (driver);
			homepage.clickOnLogin();
			homepage.sendKeysToUserId();
			homepage.sendKeysToPassword();
			homepage.clickOnSubmit();
			
			
			
			
		
	}

}

package awstest;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TC_Login {
	
	@Test
	public void login_Test() throws InterruptedException 	
	{
		
		/*WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();*/
		
		WebDriver driver;
        //System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("disable-gpu");
        options.addArguments("window-size=1920,1080");
        driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		//driver.get("https://ib_web_admin:aWJfd2ViX2FkbWlu@qa-www.indiabonds.com/customer/login/?next=/");
		
		driver.get("https://www.indiabonds.com/customer/login/?next=/");
		System.out.println("Title of the page is:" +driver.getTitle());
		driver.findElement(By.id("email_contact_field")).sendKeys("9689735569");
		
		driver.findElement(By.name("password")).sendKeys("India@123$");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='cookieAcceptBtn']")).click();
		
		//driver.findElement(By.cssSelector("#cookieAcceptBtn"));
		
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[2]/div[1]/div[3]/form/div/div[3]/div[1]/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	    
		Assert.assertEquals(driver.getTitle(), "Best Online Platform to Buy Bonds & Debentures in India – IndiaBonds");
		
	    driver.findElement(By.xpath("//img[@alt='down-arrow']")).click();
	    
	    Thread.sleep(3000);
	    
	    //driver.findElement(By.xpath("//*[@id=\"logout_block\"]")).click();
	    
	     List<WebElement> profileOptions=driver.findElements(By.xpath("//div[@class='logout-anchor p-no-margin logout-text custom-logout-text']"));
	     System.out.println("No of Profile Options:" +profileOptions.size());
	     selectOptionFromDropdown(profileOptions,"Logout");
	     
	     /*for(WebElement Option:profileOptions)
	     {
	    	 if (Option.getText().equals("Logout"))
             {
            	 Option.click();
            	 break;
	
             }
	     } */
	     
	  Assert.assertEquals(driver.getTitle(), "Best Online Platform to Buy Bonds & Debentures in India – IndiaBonds");
	    
	  driver.quit();
	    
		
	}
	public static void selectOptionFromDropdown(List<WebElement> options, String value)
	{
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
				
				
		}
	}
	
}

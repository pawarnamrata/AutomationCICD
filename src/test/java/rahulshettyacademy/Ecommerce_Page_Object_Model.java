package rahulshettyacademy;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import rahulshettyacademy.pageobjects.LandingPage;

public class Ecommerce_Page_Object_Model {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:/DRIVERS/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().window().maximize();
		LandingPage landingPage = new LandingPage(driver);
		
		//driver.get("https://rahulshettyacademy.com/client");
		landingPage.goTo();
		
		/*
		driver.findElement(By.id("userEmail")).sendKeys("namrata27pawar@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Practice@123");
		driver.findElement(By.id("login")).click();
		
		*/
		
		landingPage.loginApplication("namrata27pawar@gmail.com", "Practice@123");
		
		
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[3]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[@class='btn btn-custom'])[3]")).click();
		Thread.sleep(2000);
		
		List<WebElement> li = driver.findElements(By.xpath("//div/h3"));
	    Boolean compare = li.stream().anyMatch(s->s.getText().equalsIgnoreCase("ZARA COAT 3"));
		System.out.println(compare);
		
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//div/input[@class='input txt text-validated'])[2]")).sendKeys("India");
		
		//driver.findElement(By.xpath("(//button[@class='ta-item list-group-item ng-star-inserted'])[2]")).click();
		Thread.sleep(2000);
		Actions a=new Actions(driver);
		a.click(driver.findElement(By.cssSelector(".ta-item:nth-child(3)"))).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		
		Thread.sleep(1000);
		Assert.assertEquals(driver.findElement(By.cssSelector(".hero-primary")).getText(), "THANKYOU FOR THE ORDER.");
		
		Thread.sleep(2000);
		
		
		System.out.println("Test Passed");;
		driver.quit();
		
	}

}

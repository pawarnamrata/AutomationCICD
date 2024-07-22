package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalog {
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//WebElement p1 = driver.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[1]")).click();
	
	//PageFactory
	
	@FindBy(xpath="(//button[@class='btn w-10 rounded'])[1]")
	WebElement p1;
	
	
	

}

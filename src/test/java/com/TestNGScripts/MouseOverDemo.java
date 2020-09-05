package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseOverDemo {
	public static WebDriver driver;
	
	
	
	@BeforeClass
	public static void setup()
	{
		
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\guhan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // maximize the browser window
		
		driver.manage().deleteAllCookies();  // delete cookies on the browser
		
		driver.get("https://www.amazon.com/");
		
	}
	
	@Test
	public void mouseovermethod() throws InterruptedException
	{
		Actions obj= new Actions(driver);
		
		WebElement e=driver.findElement(By.id("nav-link-accountList"));
		
		// mouseover-- to move to an element moveToElement(), build , perform
		

		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"nav-al-wishlist\"]/a[4]/span")).click();
	}
	
	

public void dragandDropmethod() throws InterruptedException
{
	driver.navigate().to("https://jqueryui.com/droppable/");

	driver.switchTo().frame(0);

	
//build() and perform() methods are used to perform series of events on the page
	//ClcikAndHold()--event it will click on an element and hold it for certain time
	//MoveToElement() --event will move the cursor to another element
	
	
	WebElement e= driver.findElement(By.id("draggable"));

	WebElement e1= driver.findElement(By.id("droppable"));
	
	Actions obj = new Actions(driver);
	
	obj.clickAndHold(e).moveToElement(e1).build().perform();
	
	Thread.sleep(2000);
	driver.navigate().refresh();
	
	//right click on an element
	
	driver.switchTo().defaultContent();
	
	WebElement e2=driver.findElement(By.linkText("Droppable"));
	
	obj.contextClick(e2).build().perform();
	
	//obj.doubleClick(element detail).build().perform();
	

	//double click
//drag and drop

	
//click an hold for sometime on the element to be moved to another location, release, build and perform



	
//right click on an element
	
	
}
}

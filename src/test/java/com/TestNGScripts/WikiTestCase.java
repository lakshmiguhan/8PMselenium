package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikiTestCase {

	//in TestNg you test steps for test cases will be written as  methods
	//Test NG annotation to execute a test case
	//Create a method as test case TC 1
	//All methods wil be void in Test NG except data driven
	//Annotation will be writed over the method name
	public static WebDriver driver;
	//before class annotation
	//@BeforeClass  //this will be executed first if this annotation is given
	
	@BeforeClass
	
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\guhan\\Downloads\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // maximize the browser window
		
		driver.manage().deleteAllCookies();  // delete cookies on the browser		
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
	}
	@BeforeMethod
	public void login()
	{ 
		System.out.println("login to the application");
	}
	
	//start execution
	@Test(priority='1')
	
	public void createAccount() throws InterruptedException
	{
		// test steps to perform test cases goes here 
		
		// locate the text box and enter data in the text box
		
	driver.findElement(By.id("wpName2")).sendKeys("Username1");	
	
	Thread.sleep(3000);
	
	// Inspect password textbox and enter data in the text box
	driver.findElement(By.name("wpPassword")).sendKeys("password@123");
	
	//explicit wait 
	
	
	driver.findElement(By.xpath("//button[@value='Create your account']")).click();
	}
	
	@Test(priority='2')
	public void MainPage()
	{
		driver.findElement(By.linkText("Main page")).click();
		System.out.println(driver.getTitle());
	}
	@AfterMethod
	public void  logout()
	{ 
		System.out.println("logout of the application");
	}
	
}
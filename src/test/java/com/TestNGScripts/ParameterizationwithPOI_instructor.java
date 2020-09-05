package com.TestNGScripts;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Xls_dataProvider;

public class ParameterizationwithPOI_instructor {
WebDriver driver;
@BeforeClass

public void startbrowser()
{
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\guhan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	 	driver = new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
}


@Test(dataProvider="inputxlsx")
public  void wikipagedata(String name, String password, String retype, String email) throws InterruptedException

{
	driver.findElement(By.id("wpName2")).clear();
	
	driver.findElement(By.id("wpName2")).sendKeys(name);
	Thread.sleep(2000); // static wait
	// explicit wait
	
	driver.findElement(By.id("wpPassword2")).clear();
	driver.findElement(By.id("wpPassword2")).sendKeys(password);
	driver.findElement(By.id("wpRetype")).clear();
	driver.findElement(By.id("wpRetype")).sendKeys(retype);
	Thread.sleep(2000);
	driver.findElement(By.id("wpEmail")).clear();
	driver.findElement(By.id("wpEmail")).sendKeys(email);
	Thread.sleep(2000);
}

public Object[][] readExcel()

{
	
	Object input[] []=Xls_dataProvider.getTestData("Sheet1");
	
	return input;
	
	
}

@DataProvider(name="inputxlsx")
public Object[][] readExcel2() throws EncryptedDocumentException, IOException
{
	FileInputStream f= new FileInputStream("C:\\Users\\guhan\\Desktop\\input.xlsx");

	Workbook book= WorkbookFactory.create(f);
	
	Sheet sheet = book.getSheet("Sheet1");
	 
	int row= sheet.getLastRowNum();
	
	int col= sheet.getRow(0).getLastCellNum();
	
String input[][]= new String [row][col]	;

for(int i=0;i<row;i++)
{
 for(int j=0;j<col;j++) {
	 
	 // fetch the data from each cell of that row
	
	 // fetching the cell
input[i][j]= sheet.getRow(i+1).getCell(j).toString();
	 

	 
	 }

}
return input;	
	

}
}

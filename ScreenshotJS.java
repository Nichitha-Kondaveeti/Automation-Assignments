package Com.Day7_Assignments;
import java.util.Date;

import java.io.File;
//import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

/*1. Screenshot – take screenshot using Java scriptExecutor 

- https://leafground.com/charts.xhtml 

 

- for third image of chart(Radar Chart,Bubble Chart and  

Scatter Chart) */

public class ScreenshotJS {
  
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://leafground.com/charts.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  
	  TakesScreenshot ts = ( TakesScreenshot)driver; 

	  JavascriptExecutor js= (JavascriptExecutor)driver; 

	  js.executeScript("scroll(0,1000)"); 
//	  Date date= new Date();
//	  DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh-mm-ss");
//	  
//	   
	  
	  DateFormat dateFormat =new SimpleDateFormat("dd-MM-YYYY HH-mm-ss");
	  java.util.Date date = new java.util.Date();
	  File src = ts.getScreenshotAs(OutputType.FILE); 
	  String fileName="ScreenshotJS";

	  File des = new File("C:\\Users\\kramk\\eclipse-workspace\\Automation\\Screenshot_Jan"+"\\"+fileName+"_"+dateFormat.format(date)+".png"); 

	  FileHandler.copy(src, des); 

	   
	  driver.quit();
  }
}

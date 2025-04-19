package Com.Day6_Assignments;

import java.io.File;
import  org.openqa.selenium.io.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 2. Screenshot - https://leafground.com/charts.xhtml 
- take the screen print 
*/
public class ScreenShot {
  @Test
  public void f() throws Exception {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://leafground.com/charts.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  File ts = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 

	  File ds= new  File("C:\\Users\\kramk\\eclipse-workspace\\Automation\\Screenshot_Jan\\Screeshot1.png"); 

	 FileHandler.copy(ts, ds);
	 driver.close();
  }
}

package Com.Day5_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 4) Nested Frames 
 https://leafground.com/frame.xhtml 
- Click Me (Inside Nested frame) 
- How many frames in this page? 
 * */

public class NestedFrames {
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://leafground.com/frame.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  Actions action = new Actions(driver);
	  driver.switchTo().frame(0);
	  System.out.println("Identified frame1");
	  driver.findElement(By.xpath("//button[contains(.,'Click Me')]")).click();	  
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  //Click me inside nested frame
	  driver.switchTo().frame(2);
	  driver.switchTo().frame(0);
	  System.out.println("Identified frame2");
	  driver.findElement(By.xpath("//button[@id='Click']")).click();	  
	  Thread.sleep(2000);
	  driver.switchTo().defaultContent();
	  //How many frames in this page
	  driver.switchTo().frame(1);
	  System.out.println("Identified frame3");
	  driver.findElement(By.xpath("(//button[@id='Click'])[1]")).click();	  
	  Thread.sleep(3000);
	  
	  driver.quit();
  }
}

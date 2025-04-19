package Com.Day5_Assignments;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/*
 * 2)Multiple windows: 
https://www.leafground.com/window.xhtml;jsessionid=node0jz54y4bb417j153z2crbuubp27747005.node0 
 
 a)Click and Confirm new Window Opens 
 b)Find the number of opened tabs 
 * */

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindows {
  @Test
  public void f() throws Exception {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/window.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  Actions action = new Actions(driver);
	  driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
	  Thread.sleep(2000);
	  System.out.println("Title of my webpage"+driver.getTitle());
	  
	  driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
	  
	  Thread.sleep(2000);
	  System.out.println("Title of my webpage"+driver.getTitle());
	  Set<String> winhand=driver.getWindowHandles();
	  System.out.println("Total number of tabs opened: "+winhand.size());
	  for(String s:winhand) {
		  System.out.println("All window Titles: "+s);
	  }
	  
	  driver.quit();
	  
  }
}

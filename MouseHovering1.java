package Com.Day5_Assignments;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

/*1)Mouse Hovering 1 : 
https://the-internet.herokuapp.com/hovers 

*Image 3- Mouse hovering 
a) to retrieve name: User3 and View profile 
*/

public class MouseHovering1 {
  @Test
  public void f() throws InterruptedException {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/hovers");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  
	  Actions action = new Actions(driver);
	  WebElement e1= driver.findElement(By.xpath("(//img[@alt='User Avatar'])[3]"));
	  action.moveToElement(e1).build().perform();
	  //String value1=driver.findElement(By.partialLinkText("name: user3")).getText();
	  String value = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5")).getText();
	  System.out.println("Value: "+value);
	
	 action.moveToElement(e1).build().perform();
	 String viewprolink=driver.findElement(By.xpath("//a[@href='/users/3']")).getText();
	  
	  
	  
	  driver.close();
  }
}

package Com.Day5_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/*
 * 3)Mouse Hovering 2 : 
  https://www.leafground.com/drag.xhtml 
  a)Draggable 
  b)Droppable 
  c)Range Slider 
 * */

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHovering2 {
  @Test
  public void f() throws Exception {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/drag.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  //a)Draggable 
	  Actions action = new Actions(driver);
	  WebElement e1 = driver.findElement(By.xpath("(//span[@class='ui-panel-title'])[1]"));
	  //action.moveToElement(e1).build().perform();
	  action.clickAndHold(e1).moveByOffset(1003, 0).release().build().perform();
	  Thread.sleep(3000);
	  
	  //b)Droppable 
	  WebElement e2 = driver.findElement(By.xpath("(//p)[2]"));
	  WebElement e3 = driver.findElement(By.xpath("(//p)[1]"));
	  
	  action.dragAndDrop(e2, e3).build().perform();
	  Thread.sleep(3000);
	  
	  //c)Range Slider
	  WebElement e4= driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
	  action.clickAndHold(e4).moveByOffset(-100, 0).release().build().perform();
	  Thread.sleep(3000);
	  driver.close();
	  
	  
  }
}

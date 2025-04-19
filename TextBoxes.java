package Com.Day4_Assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxes {
  @Test
  public void f() throws Exception {
	  
	  //Text boxes - all the locator type you have to implement in the code(id,name,xpath..)
	  
	  //URL:https://www.leafground.com/input.xhtml
	  //Types your name,Append Country to this city,Clear the typed text,Type about your self.
	  
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/input.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  /*All locator types:*/
	  //Locate by ID
	  
	  highlight(driver,driver.findElement(By.id("j_idt88:name")));	 
	  //WebElement e1 =driver.findElement(By.name("j_idt88:j_idt91"));
	  //e1.sendKeys(", Vijayawada");
	  //e1.clear();
	  Thread.sleep(2000);
	  
	  //Locate by name
	  highlight(driver,driver.findElement(By.name("j_idt88:j_idt91")));	 
	  Thread.sleep(2000);
	  
	//Locate by Xpath
	  highlight(driver,driver.findElement(By.xpath("//textarea[@id='j_idt88:j_idt101']")));	 
	  Thread.sleep(2000);
	  
	  
	  highlight(driver, driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")));
	  
	  //Locate by Class 
	  highlight(driver,driver.findElement(By.className("ui-menuitem-submenu")));	 
	  Thread.sleep(2000);
	  
	  //Locate by tagname	  
	  highlight(driver,driver.findElement(By.tagName("img")));	 
	  Thread.sleep(2000);
	    
	  //Locate By Css Selector
	  highlight(driver,driver.findElement(By.cssSelector("input[id='j_idt88:j_idt95']")));	 
	  Thread.sleep(2000);
	  
	  
	  
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  driver.quit();
  }
  
  
  private static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
		// TODO Auto-generated method stub
		
	}
}

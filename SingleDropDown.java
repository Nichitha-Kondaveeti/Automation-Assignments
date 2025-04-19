package Com.Day4_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SingleDropDown {
  @Test
  public void f() throws Exception {
	  
	  //https://www.leafground.com/select.xhtml
	  
	  /*-Which is your favorite automation tool?--select drop down for implementation for select By visible Text(), SelectByIndex(), and Select By Value()*/
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/select.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	 // WebElement e1= driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
	  Select sel = new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
	  sel.selectByIndex(1);
	  
	  Thread.sleep(2000);
	  sel.selectByVisibleText("Playwright");
	  Thread.sleep(2000);
	  sel.selectByContainsVisibleText("Puppete");
	  Thread.sleep(2000);
	  
	  
	  driver.quit();
	  
	  
  }
}

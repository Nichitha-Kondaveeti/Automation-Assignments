package Com.Day4_Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LayOutLinks {
  @Test
  public void f() throws Exception {
	  
	  /*Layout Links*/
	  //--Count LayOutLinks
	  //--Count Links
	  //https://www.leafground.com/link.xhtml
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/link.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  
	  //--Count links
	  
	  highlight(driver,driver.findElement(By.linkText("How many links in this page?")));
	  Thread.sleep(2000);
	  
	  
	  //--Count lay out Links
	  
	  highlight(driver,driver.findElement(By.partialLinkText("How many links in this la")));
	  
	  Thread.sleep(3000);
	  
	  
	  //--Count Links
	  
//	  List <WebElement> list = driver.findElements(By.xpath("//a[@class]"));
//	  System.out.println("List size of links: "+list.size());
//	  for(WebElement e :list) {
//		  highlight(driver, e);
//		  Thread.sleep(2000);
//		  
//	  }
	  
	  
	  //--Count Layout links
	  
	  
//	  List <WebElement> listlayout = driver.findElements(By.xpath("//a[not(@class)]"));
//	  System.out.println("Listlayout links  size of links: "+listlayout.size());
//	  for(WebElement e :listlayout) {
//		  highlight(driver, e);
//		  Thread.sleep(2000);
//		  
//	  } 
		  
	  
	  
	  
	  
	  driver.quit();	  
	  
	  
  }
  
  private static void highlight(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
		// TODO Auto-generated method stub
		
	}
}

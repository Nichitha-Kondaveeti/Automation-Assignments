package Com.Day4_Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
  @Test
  public void f() throws InterruptedException {
	  
	  //Basic Check box --To enable check box of basic
	  //Choose your favorite languages - all five check box should be selected
	  
	  //https://www.leafground.com/checkbox.xhtml
//	  WebDriver driver;
//	  System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe" );
//	  WebDriverManager.chromedriver().browserVersion("133.0.6943.99").setup();
//	  ChromeOptions options = new ChromeOptions();
//	  options.addArguments("--remote-allow-origins=*");
//	  options.addArguments("--disable-popup-blocking");
//	  options.addArguments("--start-maximized");
	  
//	  WebDriverManager.chromedriver().setup();
//	  driver = new ChromeDriver();
//	  driver.get("https://www.leafground.com/checkbox.xhtml");
//	  driver.manage().window().maximize();
//	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  //WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Basic']/preceding-sibling::div/child::span[1]")));
	  
//	  driver.findElement(By.xpath("//span[.='Basic']/preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
	  
	  //WebElement e1 =driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[1]/div[1]/div/div/div/div[2]"));
	  
	  //e1.click();
//	  Thread.sleep(2000);
//	  
//	  
//	  driver.quit();
	  
	  
	/*Basic Check box --To enable check box of basic*/
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.leafground.com/checkbox.xhtml");
	  driver.manage().window().maximize();
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  WebElement e1= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Basic']/preceding-sibling::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")));
	  e1.click();
	  Thread.sleep(2000);
	  
	  /*Choose your favorite languages - all five check box should be selected*/
	  
	  List<WebElement> list = driver.findElements(By.xpath("//h5[.='Choose your favorite language(s)']/parent::div[@class='card']/descendant::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']"));
	  System.out.println("list size: "+list.size());
	  for(WebElement e:list) {
		  Thread.sleep(500);
		  e.click();
		  
		  System.out.println("Check box clicking");
		  
	  
	  }
	  
	  driver.quit();
	  
	  
	  

	  
  }
}

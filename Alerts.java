package Com.Day6_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 3. Alerts 
 
  https://demo.automationtesting.in/Alerts.html 
- Alerts - 3 Popup to be handled 
 * */
public class Alerts {
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://demo.automationtesting.in/Alerts.html");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	//Accept pop up
	  driver.findElement(By.partialLinkText("Alert with OK")).click();
	  Thread.sleep(2000);
	  
	  driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	  String alertval1=driver.switchTo().alert().getText(); 

	  System.out.println("Alert Value::::"+alertval1); 
	  driver.switchTo().alert().accept();
	  //dismiss pop up
	  driver.findElement(By.partialLinkText("Alert with OK & Cancel")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	  String alertval2=driver.switchTo().alert().getText(); 

	  System.out.println("Alert Value::::"+alertval2); 
	  driver.switchTo().alert().dismiss();
	  
	  //text pop up
	  
	  
	  driver.findElement(By.partialLinkText("Alert with Textbox")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	  String alertval3=driver.switchTo().alert().getText(); 

	  System.out.println("Alert Value::::"+alertval3); 
	  driver.switchTo().alert().sendKeys("HCL Training");
	  
	  driver.switchTo().alert().accept();
	  
	  driver.quit();
	  
	  
  }
}

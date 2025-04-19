package Com.Day8_Assignments;

import org.apache.poi.hslf.record.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
/*2. JavascriptExecutor: 

https://leafground.com/input.xhtml;jsessionid=node01xiupbs5d9n7wasvo4r0d2gci7736835.node0 

- Type your DOB (mm/dd/yyyy) and confirm date chosen 

https://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html 


- enter text in two text boxes */

import groovyjarjarantlr4.v4.codegen.OutputModelFactory;
import groovyjarjarantlr4.v4.codegen.model.Action;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderJS {
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://leafground.com/input.xhtml");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  //- Type your DOB (mm/dd/yyyy) and confirm date chosen 
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("return document.getElementById('j_idt106:j_idt116_panel').value='02/19/2025'");
	  String dateValue = (String) js.executeScript("return document.getElementById('j_idt106:j_idt116_panel').value");
	  System.out.println("Entered date: " + dateValue);
	  
	  Thread.sleep(5000);
	 
	  //- enter text in two text boxes 
	  driver.get("https://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html ");
	  WebElement e1=driver.findElement(By.xpath("(//input)[1]"));
	  
	  String Value1=js.executeScript("return arguments[0].value='first input'", e1).toString();
	  
	  WebElement e3=driver.findElement(By.id("mCSB_3_dragger_vertical"));
	  Actions act= new Actions(driver);
	  act.clickAndHold(e3).moveByOffset(0,100).release().build().perform();
	  
	  WebElement e2=driver.findElement(By.xpath("(//input)[2]"));
	  
	  String Value2=js.executeScript("return arguments[0].value='Second input'", e2).toString();
	  
	  System.out.println("First input value: " + Value1);
	  System.out.println("First input value: " + Value2);
	  Thread.sleep(5000);
	  driver.close();
  }
}

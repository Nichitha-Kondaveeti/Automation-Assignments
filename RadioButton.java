package Com.Day4_Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RadioButton {
	
	WebDriver driver;
  @Test
  public void f() throws Exception {
	 //String sysdirectory = System.getProperty("user.dir");
	 //System.out.println("current dir: "+sysdirectory);
	 System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe" );
	 ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    
	    
	    /*
	     * 1.Radio Button validation
	     * a.Find the default select radio button(Chrome radio button click)
	     * b.Select the age group(only if not selected)(Select the radio button 41-60 years)
	     * */
	  
	  driver = new ChromeDriver();
	  driver.get("https://www.leafground.com/radio.xhtml");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//span[@class='ui-radiobutton-icon ui-icon ui-icon-blank ui-c'])[16]")).click();
	  Thread.sleep(2000);
	  WebElement e2= driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/form/div/div[2]/div[2]/div/div/div/div/div[3]/div/div[2]"));
	  if(e2.isSelected()) {
		  System.out.println("Radio button is already selected");
	  }
	  else {
		  e2.click();
	  }
	  
	  
	  Thread.sleep(2000);
	  
	  driver.quit();
	
  }
}

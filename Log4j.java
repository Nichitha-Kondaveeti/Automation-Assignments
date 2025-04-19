package Com.Day8_Assignments;

import java.awt.AWTException;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Log4j {
    WebDriver driver;
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
      driver=new ChromeDriver();
      System.setProperty("Log4j.ConfigurationFile",".\\resources\\log4j.xml");
      final Logger logger=LogManager.getLogger(Log4j.class);
      
      driver.get("https://leafground.com/dashboard.xhtml;jsessionid=node0vvkqhnhws6mj1dosovjjke8fd8811352.node0");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      
      // Try to implement log4j for Email Address and message validation for the leafground application
      logger.info("Leafground dashboard title: "+driver.getTitle());
      Thread.sleep(2000);
      logger.info("Passing email");
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testingnewabc@gmail.com");
      Thread.sleep(1000);
      logger.info("Passing message");
      driver.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("text message");
      Thread.sleep(1000);
      logger.info("Clicking Send");
      driver.findElement(By.xpath("//*[@id=\"j_idt130\"]")).click();
      Thread.sleep(1000);
      logger.debug("Email and Message Sent");
      Thread.sleep(3000);
     driver.quit();
      
  }
  
  
  
}

 
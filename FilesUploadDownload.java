package Com.Day6_Assignments;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 1. https://leafground.com/file.xhtml;jsessionid=node03aeevoepm6451mpaqfw4ky1zp7733421.node0 
  - Basic Upload  
  - Advanced Upload - Only Pictures 
  - Basic Download 
 * */

public class FilesUploadDownload {
  @Test
  public void f() throws Exception {
	  WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/file.xhtml");
		Thread.sleep(3000);
		//- Basic Upload 
		driver.findElement(By.xpath("//span[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']")).click();
		File file = new File("C:\\Users\\kramk\\eclipse-workspace\\Automation\\Screenshot_Jan\\movie-review-api.java");
		StringSelection str = new StringSelection(file.getAbsolutePath()); 		 
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null); 
		//Control+V ----paste the filepath in file explorer 
		 Robot r1= new Robot(); 

		  Thread.sleep(20000); 

		  r1.keyPress(KeyEvent.VK_ENTER); 

		  r1.keyRelease(KeyEvent.VK_ENTER); 

		   

		  r1.keyPress(KeyEvent.VK_CONTROL); 

		  r1.keyPress(KeyEvent.VK_V); 

		   

		  r1.keyRelease(KeyEvent.VK_CONTROL); 

		  r1.keyRelease(KeyEvent.VK_V); 

		   

		  r1.keyPress(KeyEvent.VK_ENTER); 

		  r1.keyRelease(KeyEvent.VK_ENTER); 

		   

		  Thread.sleep(20000); 

		  
		//Advanced Upload - Only Pictures
		driver.findElement(By.xpath("//span[@id='j_idt97:j_idt98_label']")).click();
		File file1 = new File("C:\\Users\\kramk\\OneDrive\\Pictures\\JON SIGN.jpg");
		StringSelection str1 = new StringSelection(file1.getAbsolutePath()); 
		 
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str1, null); 
		 
		//Control+V ----paste the filepath in file explorer 

		  Thread.sleep(20000); 
		  Robot r2= new Robot(); 

		  r2.keyPress(KeyEvent.VK_ENTER); 

		  r2.keyRelease(KeyEvent.VK_ENTER); 

		   

		  r2.keyPress(KeyEvent.VK_CONTROL); 

		  r2.keyPress(KeyEvent.VK_V); 

		   

		  r2.keyRelease(KeyEvent.VK_CONTROL); 

		  r2.keyRelease(KeyEvent.VK_V); 

		   

		  r2.keyPress(KeyEvent.VK_ENTER); 

		  r2.keyRelease(KeyEvent.VK_ENTER); 
		  Thread.sleep(20000); 

		  driver.findElement(By.xpath("//span[contains(.,'Upload')]")).click();

		  

		
		// Basic Download 
		
		driver.findElement(By.xpath("//button[@id='j_idt93:j_idt95']")).click();
		File file2= new File("C:\\Users\\kramk\\Downloads");
		File[] filearr= file2.listFiles();
		for(File f2:filearr) {
			if(f2.getName().contains("TestLeaf")) {
				System.out.println("file get downloaded successfully");
			}
			
		}
		Thread.sleep(2000);
		

		  

		 

		driver.quit()  ;
		
  }
}

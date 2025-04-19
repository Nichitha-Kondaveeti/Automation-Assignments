package Com.Day8_Assignments;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticateRobotClass {
	@Test
	public void count() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/auth.xhtml");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
		
		//- using robot class complete the authentication  
		
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
		String mainWindow= driver.getWindowHandle();
		Set<String> allWindowHandles= driver.getWindowHandles();
		Iterator<String> iterator= allWindowHandles.iterator();
		while(iterator.hasNext()) {
			String childWindow=iterator.next();
			if(!mainWindow.equalsIgnoreCase(childWindow)) {
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();
			}
		}
		
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_D);
        robot.keyRelease(KeyEvent.VK_D);
        robot.keyPress(KeyEvent.VK_M);
        robot.keyRelease(KeyEvent.VK_M);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyRelease(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        
        //tab
        robot.keyPress(KeyEvent.VK_TAB);
        
        //Password
        
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_A);
        robot.keyRelease(KeyEvent.VK_A);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_F);
        
        Thread.sleep(4000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        
         System.out.println("Driver Title: "+driver.getTitle());
         driver.close();
         driver.switchTo().window(mainWindow);
         System.out.println("Driver Title: "+driver.getTitle());
        
         Thread.sleep(2000);
        driver.quit();
	}
}

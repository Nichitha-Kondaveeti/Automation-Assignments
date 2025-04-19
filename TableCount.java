package Com.Day8_Assignments;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableCount{
	 @Test
	 public void count() throws Exception {
		 WebDriverManager.chromedriver().setup();
		  WebDriver driver= new ChromeDriver();
		  driver.get("https://leafground.com/table.xhtml");		  
		  Thread.sleep(2000);
		  driver.manage().window().maximize();
		  //Row Count
		List<WebElement> rowCount= driver.findElements(By.xpath("//tbody/tr[@role='row']"));
		System.out.println("Row Count is: "+rowCount.size());
		
		//ColumnCount
		List<WebElement> columnCount= driver.findElements(By.xpath("//thead[@id='form:j_idt89_head']/tr/th/span[@class='ui-sortable-column-icon ui-icon ui-icon-carat-2-n-s']"));
		System.out.println("Column Count is: "+columnCount.size());
		//Get Name and Date of Join Value
		
		List<WebElement>nameAndDateOfJoin=driver.findElements(By.xpath("//thead[@id='form:j_idt89_head']/tr/th[1] | //thead[@id='form:j_idt89_head']/tr/th[4]"));
		for(WebElement e:nameAndDateOfJoin) {
			System.out.println(e.getText());
		}
		
		Thread.sleep(2000);
		driver.quit();
	 }

}
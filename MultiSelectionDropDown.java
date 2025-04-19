package Com.Day4_Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * -Standard Multi selct ---implement Is Multiple(),DeselcctAll(),DeselectByVisibleText(),DeselectByValue() and DeselectByIndex()
 * https://demoqa.com/select-menu
 * */

public class MultiSelectionDropDown {
  @Test
  public void f() throws Exception {
	  
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://demoqa.com/select-menu");
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  
	  Select sel = new Select(driver.findElement(By.id("cars")));
	  List <WebElement> list = sel.getOptions();
	  for(WebElement str:list) {
		  System.out.println("All available options: "+str.getText());
	  }
	  
	  //Is multiple
	  sel.selectByVisibleText("Volvo");
	  sel.selectByVisibleText("Saab");
	  sel.selectByVisibleText("Opel");
	  System.out.println("Is Multiple : "+sel.isMultiple());
	  Thread.sleep(2000);
	  
	  //Deselect by visble text
	  
	  sel.deselectByVisibleText("Volvo");
	  
	  //DeselectAll()
	  
	  sel.selectByIndex(0);
	  sel.selectByIndex(1);
	  sel.selectByIndex(2);
	  sel.selectByIndex(3);
	  System.out.println("Selected Value: "+sel.getAllSelectedOptions());
	  sel.deselectAll();
	  
	  //Deselect by Value()
	  sel.selectByValue("audi");
	  sel.selectByValue("opel");
	  sel.deselectByValue("saab");
	  sel.selectByValue("volvo");
	  sel.deselectByValue("opel");
	  
	  System.out.println("First selected option: "+sel.getFirstSelectedOption().getText());
	  //DeselectBy Index()
	  sel.deselectByIndex(3);
	  
	  driver.quit();
	  
  }
}

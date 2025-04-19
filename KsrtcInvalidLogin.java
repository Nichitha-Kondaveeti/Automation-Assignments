package Com.Day8_Assignments;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
 
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
 

 
public class KsrtcInvalidLogin {
    WebDriver driver;
    
    
    
  @Test
  public void f() throws InterruptedException, IOException, AWTException {
      driver=new ChromeDriver();
      driver.get("https://ksrtc.in/login");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      
      // KSRTC invalid registration  scenario for 5 sets of users 
      FileInputStream fs=new FileInputStream("./resources/Data.xlsx");
      XSSFWorkbook wb=new XSSFWorkbook(fs);
      XSSFSheet xsh=wb.getSheetAt(0);
      int lastrow=xsh.getLastRowNum();
      for(int i=1;i<=lastrow;i++){
          XSSFRow row=xsh.getRow(i);
          DataFormatter formatter = new DataFormatter();
          String email=formatter.formatCellValue(row.getCell(0));
          String mobile=formatter.formatCellValue(row.getCell(1));
          String password=formatter.formatCellValue(row.getCell(2));
          driver.findElement(By.xpath("//label[contains(text(),'Email ID')]/preceding-sibling::input")).sendKeys(email);
          Thread.sleep(1000);
          driver.findElement(By.xpath("//label[contains(text(),'Mobile Number')]/preceding-sibling::input")).sendKeys(mobile);
          Thread.sleep(1000);
          driver.findElement(By.xpath("//label[contains(text(),'Password')]/preceding-sibling::input")).sendKeys(password);
          Thread.sleep(1000);
          driver.findElement(By.xpath("//div[contains(@class,'checkbox')]")).click();
          Thread.sleep(1000);
          driver.findElement(By.xpath("//div[@class=\"btn payee\"]")).click();
          Thread.sleep(3000);
         // driver.switchTo().alert().accept();
          driver.findElement(By.xpath("//*[@id=\"okayButton\"]")).click();
          Thread.sleep(3000);  
          driver.navigate().refresh();
          Thread.sleep(3000);
          }
     driver.quit();
      
  }
  
}
 
 
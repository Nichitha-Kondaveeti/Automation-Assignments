package Com.Day8_Assignments;

import org.testng.annotations.Test;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.AWTException;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;




public class ExtentTestReports {
	WebDriver driver;
	public static ExtentSparkReporter exspre;
	public static ExtentReports reporter;
	public static ExtentTest test;

	@BeforeTest
	public void beforeTest() {
		exspre = new ExtentSparkReporter("./target/extentreport/extent.html");
		reporter = new ExtentReports();
		reporter.attachReporter(exspre);
	}

	@Test
	public void f() throws InterruptedException, IOException, AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		String sysdir = System.getProperty("user.dir");
//		System.out.println("current directory:" + sysdir);
		driver.get(
				"https://www.amazon.com/ap/register?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&prevRID=T0VWC0XNY27TRZ76BJPS&openid.assoc_handle=usflex&openid.mode=checkid_setup&prepopulatedLoginId=&failedSignInCount=0&webAuthnChallengeIdForAutofill=QOBWuq6L7ix6Uh3pUCMyCBX1M69O3eCo%3ANA&webAuthnGetParametersForAutofill=eyJycElkIjoiYW1hem9uLmNvbSIsImNoYWxsZW5nZSI6IlFPQld1cTZMN2l4NlVoM3BVQ015Q0JYMU02OU8zZUNvIiwidGltZW91dCI6MzI0NDQxLCJhbGxvd0NyZWRlbnRpYWxzIjpudWxsLCJtZWRpYXRpb24iOiJjb25kaXRpb25hbCIsInVzZXJWZXJpZmljYXRpb24iOiJwcmVmZXJyZWQifQ%3D%3D&pageId=usflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// To implement extent report for amazon registration
		Thread.sleep(2000);
		test = reporter.createTest("Testcase1", "AmazonRegister");
		Thread.sleep(3000);

		WebElement e1 = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		e1.sendKeys("Nichitha");
		test.log(Status.INFO, "Passing my Name " );
		Thread.sleep(1000);

		WebElement e2 = driver.findElement(By.xpath("//input[@id='ap_email']"));
		e2.sendKeys("nichithatestng@gmail.com");
		test.log(Status.INFO, "Passing my Email ");
		Thread.sleep(1000);

		WebElement e3 = driver.findElement(By.xpath("//input[@id='ap_password']"));
		e3.sendKeys("Amazing2025!");
		test.log(Status.INFO, "Entered Password ");
		Thread.sleep(1000);

		WebElement e4 = driver.findElement(By.xpath("//input[@id='ap_password_check']"));
		e4.sendKeys("Amazing2025!");
		test.log(Status.INFO, "Password reentered successfully");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//input[@id='continue']")).click();
		test.log(Status.INFO, "Clicking on Continue Successfully");
		Thread.sleep(2000);

		test.log(Status.PASS, "Testcase Passed " + "Entered successfully");

		driver.quit();

	}

	@AfterTest
	public void afterTest() {
		if (reporter != null) {
			reporter.flush();
		}
	}

}

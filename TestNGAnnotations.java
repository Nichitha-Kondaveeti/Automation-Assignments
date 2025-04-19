package Com.Day2_Assignments;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.AfterSuite;
 
public class TestNGAnnotations {

  @Test	

  public void registration() {

	  System.out.println("Test registration-Test1");

  }

  @Test

  public void login() {

	  System.out.println("test login-Test 2");

  }

  @BeforeMethod

  public void beforeMethod() {

	  System.out.println("BeforeMethod4");

  }
 
  @AfterMethod

  public void afterMethod() {

	  System.out.println("AfterMethod5");

  }
 
  @BeforeClass

  public void beforeClass() {

	  System.out.println("BeforeClass3");

  }
 
  @AfterClass

  public void afterClass() {

	  System.out.println("AferClass6");

  }
 
  @BeforeTest

  public void beforeTest() {

	  System.out.println("BeforeTest2");

  }
 
  @AfterTest

  public void afterTest() {

	  System.out.println("AfterTest7");

  }
 
  @BeforeSuite

  public void beforeSuite() {

	  System.out.println("beforesuite1");

  }
 
  @AfterSuite

  public void afterSuite() {

	  System.out.println("aftersuite8");

  }
 
}

 

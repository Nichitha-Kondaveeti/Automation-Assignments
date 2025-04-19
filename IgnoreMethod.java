package Com.Day3_Assignments;

import org.testng.annotations.Test;

public class IgnoreMethod {
  @Test
  public void testA() {
	  System.out.println("Test executed-TestA");
  }

  @Test(enabled = false)
  public void testB() {
	  System.out.println("Test executed-TestB");
  }
  @Test
  public void testC() {
	  System.out.println("Test executed-TestC");
  }
}
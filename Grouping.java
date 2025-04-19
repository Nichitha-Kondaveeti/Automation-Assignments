package Com.Day3_Assignments;

import org.testng.annotations.Test;

public class Grouping {
  @Test(groups = {"S"})
  public void testA() {
	  System.out.println("Smoke group gets executed");
  }
  @Test(groups ={"R"})
  public void testB() {
	  System.out.println("Regression group Excluded from execution");
  }
  @Test(groups = {"S"})
  public void testC() {
	  System.out.println("Smoke group gets executed");
  } 
}
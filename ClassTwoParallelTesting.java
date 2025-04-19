package Com.Day3_Assignments;

import org.testng.annotations.Test;
 
public class ClassTwoParallelTesting {
  @Test
  public void ClassTwoMethodOne() {
	  System.out.println("Class Two Method One execution "+Thread.currentThread().getId());
  }
  @Test
  public void ClassTwoMethodTwo() {
	  System.out.println("Class Two Method Two execution "+Thread.currentThread().getId());
  }
}
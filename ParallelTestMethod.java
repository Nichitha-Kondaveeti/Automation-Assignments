package Com.Day3_Assignments;

import org.testng.annotations.Test;


 
public class ParallelTestMethod {
  @Test
  public void testA() {
	  System.out.println("testA "+Thread.currentThread().getId());
  }
  @Test
  public void testB() {
	  System.out.println("testB"+Thread.currentThread().getId());
  }
  @Test
  public void testC() {
	  System.out.println("testC"+Thread.currentThread().getId());
  }
}
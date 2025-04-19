package Com.Day3_Assignments;

import org.testng.annotations.Test;

public class ClassOneParallelTesting {
  @Test
  public void ClassOneMethodOne() {
	  System.out.println("Class One Method One execution "+Thread.currentThread().getId());
  }
  @Test
  public void ClassOneMethodTwo() {
	  System.out.println("Class One Method Two execution "+Thread.currentThread().getId());
  }
}
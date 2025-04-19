package Com.Day2_Assignments;

import org.testng.annotations.Test;

public class TestNGPriority {
	@Test(priority =-1)
	public void testA() {
		System.out.println("Test A");
	}
	@Test(priority =0)
	public void testB() {
		System.out.println("Test B");
	}
	@Test(priority =-2)
	public void testC() {
		System.out.println("Test C");
	}
}


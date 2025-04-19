package Com.Day2_Assignments;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

 
public class DependsOnMethods {
  @Test
  public void testLogin() {
	  System.out.println("Login success");
  }
  @Test(dependsOnMethods = {"testLogin"})
  public void testAddToCart() {
	  //System.out.println("Add to cart is  success");
	  fail();
  }
  @Test(dependsOnMethods = {"testAddToCart"})
  public void testCheckOut() {
	  System.out.println("Check out is success");
  }
}


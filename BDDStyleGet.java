package Com.Day11_Assignments;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
//2.To implement RESTAssured  Get Implementation for the url 
public class BDDStyleGet {
  @Test
  public void get() {
	  Response response=

				given().contentType(ContentType.JSON )

						.when().get("https://restful-booker.herokuapp.com/booking/445");

						response.then().log().all();
			}
  
}

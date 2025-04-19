package Com.Day11_Assignments;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
//To Implement hamcrest validation for Post and Get methods 
public class ValidateResponseFromJsonPath {
  
  @Test
	public void postFile() throws Exception {
		String jsoninputdata=generateStringFromResources("C:\\Users\\kramk\\eclipse-workspace\\Automation\\src\\main\\resources\\payload.json");
		Response response=

		given()
		.header("Content-Type", "application/json")
		.body(jsoninputdata)

				.when()
				.post("https://restful-booker.herokuapp.com/booking/");

				response.then()
				.body("booking.firstname",equalTo("John"))
				.body("booking.lastname",equalTo("Doe"))
				.body("booking.totalprice",equalTo(123))
				.body("booking.depositpaid",equalTo(true))
				.body("booking.additionalneeds",equalTo("Lunch"))
				.log().all();
	}

	private void body(String string, Matcher<String> equalTo) {
	// TODO Auto-generated method stub
	
}

	private String generateStringFromResources(String path) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(path)));
				
	}
	
	@Test
	  public void get() {
		  Response response=

					given().contentType(ContentType.JSON )

							.when().get("https://restful-booker.herokuapp.com/booking/1");

							response.then()
							.body("booking.firstname",equalTo("Sally"))
							.body("booking.lastname",equalTo("Wilson"))
							.body("booking.totalprice",equalTo(427))
							.body("booking.depositpaid",equalTo(true))
							.log().all();
							
							
				}
	  
	
}

package Com.Day11_Assignments;

import org.testng.annotations.Test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
/*
 * 1.To implement REST API with BDD Style  POST and PUT method implementation 
 * */
public class BDDStylePostPut {
	@Test
	public void post() {
		String requestjson = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":123,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-12-01\",\"checkout\":\"2024-12-10\"},\"additionalneeds\":\"Lunch\"} \n"
				+ "\n" + " ";
		Response response=

		given().header("Content-Type", "application/json").body(requestjson)

				.when().post("https://restful-booker.herokuapp.com/booking/");

				response.then().log().all();
	}
	
	//5523
	@Test
	public void postFile() throws Exception {
		String jsoninputdata=generateStringFromResources("C:\\Users\\kramk\\eclipse-workspace\\Automation\\src\\main\\resources\\payload.json");
		Response response=

		given().header("Content-Type", "application/json").body(jsoninputdata)

				.when().post("https://restful-booker.herokuapp.com/booking/");

				response.then().log().all();
	}

	private String generateStringFromResources(String path) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(path)));
	}
	
	
	@Test
	public void put() {
		String requestjson = "{\"firstname\":\"John\",\"lastname\":\"Doe\",\"totalprice\":125,\"depositpaid\":true,\"bookingdates\":{\"checkin\":\"2024-12-01\",\"checkout\":\"2024-12-10\"},\"additionalneeds\":\"Lunch\"} \n"
				+ "\n" + " ";
		Response response=

		given().header("Content-Type", "application/json").body(requestjson)

				.when().put("https://restful-booker.herokuapp.com/booking/445");

				response.then().log().all();
	}
}

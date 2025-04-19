package Com.Day11_Assignments;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PostFromPayLoadjsonFile {
	@Test
	public void postFile() throws Exception {
		String jsoninputdata=generateStringFromResources("C:\\Users\\kramk\\eclipse-workspace\\Automation\\src\\main\\resources\\payload1.json");
		Response response=

		given().header("Content-Type", "application/json").body(jsoninputdata)

				.when().post("https://restful-booker.herokuapp.com/booking/");

				response.then().log().all();
	}

	private String generateStringFromResources(String path) throws IOException {
		// TODO Auto-generated method stub
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}

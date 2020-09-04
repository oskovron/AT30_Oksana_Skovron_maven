package test;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestHw6RestAssured {

    String baseURL = "https://reqres.in/api/";

    //HW 6 Task 1:
    @Test
    public void testGetListResourceRestAssured(){
    String resources = "unknown";
        when()
                .get(baseURL+resources)//make request to https://reqres.in/api/unknown
                .then()
                .assertThat()
                .statusCode(200)  //verify that Status Code = 200.
                .and()
                .assertThat()
                .contentType(ContentType.JSON) //verify that content-type = json.
                .and()
                .assertThat()
                .body("data.name", hasItem("cerulean"));  //verify that one of data - name is "cerulean".
    }
}

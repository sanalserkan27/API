package Practice_API_Testing;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class C04_GetReqTest {
    /*
    https://reqres.in/api/users/6

    şunları test edin:
              The status code : 200
              The content type : application/json; charset=utf-8
              email : tracey.ramos@reqres.in
              first_name : Tracey
              last_name : Ramos
              avatar : https://reqres.in/img/faces/6-image.jpg
     */

    @Test
    public void test04(){
        Response response = given().when().get("https://reqres.in/api/users/6");

        response.prettyPrint();

        response
                .then()
                .assertThat()
                .contentType("application/json; charset=utf-8")
                .body("data.email", equalTo("tracey.ramos@reqres.in")
                        ,"data.first_name",equalTo("Tracey"),
                        "data.last_name",equalTo("Ramos"),
                        "data.avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"));

    }


}

package API_Testing.Day02;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C5_Get_BodyTekrarlardanKurtulma {

    /*
    C9_Get_BodyTekrarlardanKurtulma
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application-json, ve response body’sindeki
    “firstname”in, “Jim”,
    ve “lastname”in, “Ericsson”,
    ve “totalprice”in, 314,
    ve “depositpaid”in, false,
	ve “additionalneeds”in, “Breakfast” oldugunu test edin
     */

    @Test
    public void bodyTekrarindanKurtulma(){
        String url = "https://restful-booker.herokuapp.com/booking/10";

        Response response = given().when().get(url);

        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("firstname", equalTo("Jim")
                ,"lastname",equalTo("Ericsson")
                ,"totalprice",equalTo(314)
                ,"depositpaid",equalTo(false)
                ,"additionalneeds",equalTo("Breakfast"));
    }

}

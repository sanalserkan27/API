package API_Testing.Day05;

import baseUrlPackage.BaseUrl_HerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C1_BaseUrlQueryParam extends BaseUrl_HerokuApp {
    @Test
    public void test01(){
        /*
        https://restful-booker.herokuapp.com/booking
        endpointine asagidaki body’ye sahip bir POST request
        gonderdigimizde donen response’un status code’unun 200 oldugunu
        ve “firstname” degerinin “Ahmet” oldugunu test edin

           https://restful-booker.herokuapp.com/booking endpointine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response'un status code'unun 200 oldugunu ve
    "firstname" degerinin "Ahmet" oldugunu test edin
 {
    "firstname" : "Ahmet",
    "lastname" : "Bulut", "
    totalprice" : 500,
    "depositpaid" : false,
    "bookingdates" : {
                        "checkin" : "2021-06-01",
                        "checkout" : "2021-06-10"
                    },
    "additionalneeds" : "wi-fi"
}
         */

        // 1- Url hazirlama ve reqBody olusturma
        specHerokuApp.pathParams("pp1", "booking");

        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname","Ahmet");
        reqBody.put("lastname","Bulut");
        reqBody.put("totalprice",500);
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wi-fi");

        // 2- Expected Hazirlama

        // 3- Response kaydet
        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody.toString()).post("/{pp1}");



        // 4- Assertion
        response.then().assertThat().statusCode(200).body("booking.firstname", Matchers.equalTo("Ahmet"));

    }
}

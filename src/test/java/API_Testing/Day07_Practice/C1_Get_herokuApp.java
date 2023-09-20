package API_Testing.Day07_Practice;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_herokuApp {
    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin Cowboy,
    ve status Line’in HTTP/1.1 200 OK
    ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz
     */

    @Test
    public void test01(){
        // 1 - Endpoint (URL) hazirlama
        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2 - Expected Data hazirlama
        // bu soru icin expected Dataya gerek yok

        // 3 - Response Kaydetme (Actual Data kaydetme)
        Response response = given().when().get(url);
        response.prettyPrint();
        /*
                {
                "firstname": "Susan",
                "lastname": "Ericsson",
                "totalprice": 286,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2020-02-04",
                    "checkout": "2023-05-17"
                },
                "additionalneeds": "Breakfast"
               }
         */

        // 4 - Assert islemi
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy").statusLine("HTTP/1.1 200 OK");

    }
}

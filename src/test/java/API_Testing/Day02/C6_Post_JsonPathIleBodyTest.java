package API_Testing.Day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C6_Post_JsonPathIleBodyTest {
    /*
    C09_Post_JsonPathIleBodyTesti
    https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
    request gonderdigimizde
    {
    “firstname” : “Ahmet”, “lastname” : “Bulut”, “totalprice” : 500, “depositpaid” : false, “bookingdates” : {
    “checkin” : “2021-06-01”,
    “checkout” : “2021-06-10”
    },
    “additionalneeds” : “wi-fi”
    }
    donen Response’un,
    status code’unun 200,
    ve content type’inin application-json, ve response body’sindeki
    “firstname”in,“Ahmet”, ve “lastname”in, “Bulut”,
    ve “totalprice”in,500,
    ve “depositpaid”in,false,
    ve “checkin” tarihinin 2021-06-01 ve “checkout” tarihinin 2021-06-10 ve “additionalneeds”in,“wi-fi” olduğunu test edin (edited)
     */

    @Test
    public void jsonPath(){
        // Endpointimizi hazirladik
        String url = "https://restful-booker.herokuapp.com/booking";

        // RequestBody hazirladik. Ancak Nested data oldugu icin once icerdekinden baslamak uzere 2 adet body hazirladik
        JSONObject reqBody1 = new JSONObject();
        reqBody1.put("checkin","2021-06-01");
        reqBody1.put("checkout","2021-06-10");

        JSONObject reqBody2 = new JSONObject();
        reqBody2.put("firstname","Ahmet");
        reqBody2.put("lastname","Bulut");
        reqBody2.put("totalprice",500);
        reqBody2.put("depositpaid",false);
        reqBody2.put("bookingdates",reqBody1);
        reqBody2.put("additionalneeds","wi-fi");

        // Response kaydi olusturuldu
        Response response = given()
                    .contentType(ContentType.JSON)
                .when()
                    .body(reqBody2.toString())
                .post(url);

        // Assertion islemini yapalim
        response.then().assertThat().statusCode(200).contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ahmet")
                        ,"booking.lastname",equalTo("Bulut")
                        ,"booking.totalprice",equalTo(500)
                        ,"booking.depositpaid",equalTo(false)
                        ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                        ,"booking.bookingdates.checkout",equalTo("2021-06-10")
                        ,"booking.additionalneeds",equalTo("wi-fi"));

        // NOT : JSON path kullanilirken bir datanin altindaki(icindeki) dataya ulasmak icin
        // data.iceridekiData formatiyla islem yapilir.


    }
}

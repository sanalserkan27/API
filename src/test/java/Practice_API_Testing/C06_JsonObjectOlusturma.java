package Practice_API_Testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_JsonObjectOlusturma {

    @Test
    public void test06(){
        /*
            https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
            request gonderdigimizde

        {
          “firstname” : “Ahmet”,
          “lastname” : “Bulut”,
          “totalprice” : 500,
          “depositpaid” : false,
          “bookingdates” : {
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

        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        JSONObject outerBody = new JSONObject();
        outerBody.put("firstname","Ahmet");
        outerBody.put("lastname","Bulut");
        outerBody.put("totalprice",500);
        outerBody.put("depositpaid",false);
        outerBody.put("bookingdates",innerBody);
        outerBody.put("additionalneeds","wi-fi");

        System.out.println(outerBody); // olusturdugumuz objeyi yazdirma

        Response response = given().contentType(ContentType.JSON).when().body(outerBody.toString()).post("https://restful-booker.herokuapp.com/booking");

        response.prettyPrint();

    }
}

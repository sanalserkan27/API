package API_Testing.Day03;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C5_Post_ExpectedDataVeJsonPathIleAssertion {
    /*
    C12_Post_ExpectedDataVeJsonPathIleAssertion
        https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin

        Request Body
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

        ResponseBody
        {
        “bookingid”: 24,
        “booking”: {
        “firstname”: “Ahmet”, “lastname”: “Bulut”, “totalprice”: 500, “depositpaid”: false, “bookingdates”: {
        “checkin”: “2021-06-01",
        “checkout”: “2021-06-10"
        },
        “additionalneeds”: “wi-fi”
        }
        }
     */

    @Test
    public void expected01() {
        // 1- Endpoint ve RequestBody hazirlama
        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody = new JSONObject();
        innerBody.put("checkin", "2021-06-01");
        innerBody.put("checkout", "2021-06-10");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstname", "Ahmet");
        reqBody.put("lastname", "Bulut");
        reqBody.put("totalprice", 500);
        reqBody.put("depositpaid", false);
        reqBody.put("bookingdates", innerBody);
        reqBody.put("additionalneeds", "wi-fi");

        // 2- Expected Data Hazirlama
        JSONObject expData = new JSONObject();
        expData.put("firstname", "Ahmet");
        expData.put("lastname", "Bulut");
        expData.put("totalprice", 500);
        expData.put("depositpaid", false);
        expData.put("bookingdates", innerBody);
        expData.put("additionalneeds", "wi-fi");
        System.out.println(expData);

        // 3- Response kaydetme
        Response response = given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();

        // 4- Assert islemleri
        Assert.assertEquals(expData.get("firstname"), jsonPath.get("booking.firstname"));
        Assert.assertEquals(expData.get("lastname"), jsonPath.get("booking.lastname"));
        Assert.assertEquals(expData.get("totalprice"), jsonPath.get("booking.totalprice"));
        Assert.assertEquals(expData.get("depositpaid"), jsonPath.get("booking.depositpaid"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkin"), jsonPath.get("booking.bookingdates.checkin"));
        Assert.assertEquals(expData.getJSONObject("bookingdates").get("checkout"), jsonPath.get("booking.bookingdates.checkout"));
        Assert.assertEquals(expData.get("additionalneeds"), jsonPath.get("booking.additionalneeds"));


    }
}

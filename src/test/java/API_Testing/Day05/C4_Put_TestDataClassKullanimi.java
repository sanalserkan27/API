package API_Testing.Day05;

import baseUrlPackage.BaseUrl_JSONHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import testdatas.JSONPlaceData;

import static io.restassured.RestAssured.given;

public class C4_Put_TestDataClassKullanimi extends BaseUrl_JSONHolder {

    @Test
    public void test01() {
        /*
        C19_Put_TestDataClassKullanimi
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
    PUT request yolladigimizda donen response’in
    status kodunun 200, content type’inin “application/json; charset=utf-8”,
    Connection header degerinin “keep-alive”
    ve response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }
    Expected Data :
    {
    "title": "Ahmet",
    "body": "Merhaba",
    "userId": 10,
    "id": 70
    }
         */
        // 1- Url olusturma ve request body hazirlama
        specJSONHolder.pathParams("pp1","posts","pp2",70);

        JSONPlaceData jsonPlaceData = new JSONPlaceData();
        JSONObject reqData = jsonPlaceData.expectedBodyOlusturJSON2();

        // 2- Expected Data olusturma
        JSONObject expData = jsonPlaceData.expectedBodyOlusturJSON2();

        // 3- Response kaydetme
        Response response = given().spec(specJSONHolder).contentType(ContentType.JSON).when().body(reqData.toString()).put("/{pp1}/{pp2}");

        // 4- Assertion
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPlaceData.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(jsonPlaceData.contentType,response.getContentType());
        Assert.assertEquals(jsonPlaceData.header,response.getHeader("Connection"));

        Assert.assertEquals(expData.get("title"),jsonPath.get("title"));
        Assert.assertEquals(expData.get("body"),jsonPath.get("body"));
        Assert.assertEquals(expData.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(expData.get("id"),jsonPath.get("id"));

    }
}

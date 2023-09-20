package API_Testing.Day05;

import baseUrlPackage.BaseUrl_HerokuApp;
import baseUrlPackage.BaseUrl_JSONHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdatas.JSONPlaceData;

import static io.restassured.RestAssured.given;

public class C3_Get_TestDataClassKullanimi extends BaseUrl_JSONHolder {
    /*
    C19_Get_TestDataClassKullanimi
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
    yolladigimizda donen response’in status kodunun 200 ve response body’sinin
    asagida verilen ile ayni oldugunutest ediniz
    Response body :
    {
      "userId": 3,
       "id": 22,
       "title": "dolor sint quo a velit explicabo quia nam",
        "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
        um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */


    @Test
    public void test01(){
        // 1- Url hazirlama
        specJSONHolder.pathParams("pp1","posts","pp2",22);

        // 2- Expected Data olusturma
        JSONPlaceData jsonPlaceData = new JSONPlaceData();
        JSONObject expData = jsonPlaceData.expectedBodyOlusturJSON();

        // 3-Response kaydetme
        Response response = given().spec(specJSONHolder).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4- Assertion
        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expData.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(expData.get("id"),jsonPath.get("id"));
        Assert.assertEquals(expData.get("title"),jsonPath.get("title"));
        Assert.assertEquals(expData.get("body"),jsonPath.get("body"));

    }

}

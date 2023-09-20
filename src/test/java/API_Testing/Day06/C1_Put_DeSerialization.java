package API_Testing.Day06;

import baseUrlPackage.BaseUrl_JSONHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testdatas.JSONPlaceData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C1_Put_DeSerialization extends BaseUrl_JSONHolder {
   /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
        body'e sahip bir PUT request yolladigimizda donen response'in
        response body'sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }

        Expected Data :

            {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
            }
    */

    @Test
    public void test01(){
        // 1- Endpoit ve reqBody olusturma
        specJSONHolder.pathParams("pp1","posts","pp2",70);

        JSONPlaceData jsonPlaceData = new JSONPlaceData();
        HashMap<String,Object> reqData = jsonPlaceData.reqBodyOlusturMAP();

        // 2- expData olusturma
        HashMap<String,Object> expData = jsonPlaceData.reqBodyOlusturMAP();

        // 3- Response olusturma
        Response response = given()
                .spec(specJSONHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(reqData).put("/{pp1}/{pp2}");

        //response.prettyPrint();

        // 4- Assertion
        HashMap<String,Object> resMap = response.as(HashMap.class);
        Assert.assertEquals(expData.get("title"),resMap.get("title"));
        Assert.assertEquals(expData.get("body"),resMap.get("body"));
        Assert.assertEquals(expData.get("userId"),resMap.get("userId"));
        Assert.assertEquals(expData.get("id"),resMap.get("id"));


    }
}

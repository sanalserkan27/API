package API_Testing.Day03;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C4_ExpectedDataOlusturma {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Response body :
    {
        “userId”: 3,
        “id”: 22,
        “title”: “dolor sint quo a velit explicabo quia nam”,
        “body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
        um mollitia molestiae aut atque rem suscipit\nnam impedit esse”
    }
     */

    @Test
    public void expectedData(){
        // 1- Endpoint
        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Data Hazirlama
        JSONObject expData = new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        System.out.println(expData);


        // 3- Response Kaydetme
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assert islemi

        // Karsilastirma islemi yapabilmek icin kodlarimiza response verilerini okutmamiz gerekir.
        // Bunun icin response`la donen verileri okuyacak bir obje olustururuz.
        // Bunu da JsonPath classi ile yapabiliriz.
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(expData.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(expData.get("id"),jsonPath.get("id"));
        Assert.assertEquals(expData.get("title"),jsonPath.get("title"));
        Assert.assertEquals(expData.get("body"),jsonPath.get("body"));

    }



}

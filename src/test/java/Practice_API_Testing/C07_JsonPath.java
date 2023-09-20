package Practice_API_Testing;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_JsonPath {
    @Test
    public void test07(){
        /*
***         Send a GET Request to https://reqres.in/api/users
              * test:
              The status code : 200
              The content type : application/json; charset=utf-8
              email : george.bluth@reqres.in
              first_name : George
              last_name : Bluth
              avatar : https://reqres.in/img/faces/1-image.jpg
 */

        Response response = given().when().get("https://reqres.in/api/users");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath(); // Api uzerinden gelen cevabin kalibini yapisini degistirelim.

        Assert.assertEquals("george.bluth@reqres.in",jsonPath.getString("data[0].email"));
        Assert.assertEquals("George",jsonPath.getString("data[0].first_name"));
        Assert.assertEquals("Bluth",jsonPath.getString("data[0].last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/1-image.jpg",jsonPath.getString("data[0].avatar"));
        Assert.assertEquals(1,jsonPath.getInt("data[0].id"));



    }
}

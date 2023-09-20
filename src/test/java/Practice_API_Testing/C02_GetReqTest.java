package Practice_API_Testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C02_GetReqTest {

    @Test
    public void test02(){
        /*
        https://reqres.in/api/users/2
        test edilecekler :
        status code : 200
        The content type : application/json; charset=utf-8
        Server isimli header : cloudflare
        status line : HTTP/1.1 200 OK
         */

        String url = "https://reqres.in/api/users/2";

        // Cevabi kaydedecegimiz yeri ayarlayalim
        Response response = given().when().get(url);

        // Response sonuclarini oncelikle gorelim
        response.prettyPrint();
        // Assert test islemlerini yapalim
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");



    }
}

package API_Testing.Day02;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class C3_Get_ResponseBodyTest {

    /*
    https://jsonplaceholder.typicode.com/posts/44 url’ine bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve response body’sinde bulunan userId’nin 5,
	ve response body’sinde bulunan title’in “optio dolor molestias sit” oldugunu test edin.
     */

    @Test
    public void getIleBodyTest(){
        // 1- Endpoint hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected data

        // 3- Response Kaydetme
        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }
}

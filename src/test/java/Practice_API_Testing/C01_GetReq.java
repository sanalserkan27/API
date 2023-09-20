package Practice_API_Testing;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetReq {

    @Test
    public void test01(){
        /*
        https://reqres.in/api/users/
        get request

        donen response yazdirin
         */

        String url = "https://reqres.in/api/users/";

        // API`dan donen cevap response objesi icine kaydolur
        Response response = given().when().get(url);

        // API`dan donen cevabi yazdiralim
        response.prettyPrint();

    }
}

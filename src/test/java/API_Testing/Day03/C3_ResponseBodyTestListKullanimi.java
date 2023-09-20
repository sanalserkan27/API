package API_Testing.Day03;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C3_ResponseBodyTestListKullanimi {
    /*
    http://dummy.restapiexample.com/api/v1/employees url’ine bir GET request yolladigimizda
    donen Response’in
    status code’unun 200,
    ve content type’inin application/json, ve response body’sindeki
    employees sayisinin 24
    ve employee’lerden birinin “Ashton Cox”
	ve girilen yaslar icinde 61,21 ve 35 degerinin oldugunu test edin test edin.
     */

    @Test
    public void listKullanimi(){
        //1- Endpoint Hazirlama
        String url = "http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("data.id", hasSize(24)
                        ,"data.employee_name",hasItem("Ashton Cox")
                        ,"data.employee_age",hasItems(61,21,35));
    }
}

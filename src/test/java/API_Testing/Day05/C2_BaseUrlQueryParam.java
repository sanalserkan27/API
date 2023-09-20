package API_Testing.Day05;

import baseUrlPackage.BaseUrl_HerokuApp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C2_BaseUrlQueryParam extends BaseUrl_HerokuApp {
    /*
    https://restful-booker.herokuapp.com/booking endpointine gerekli
    Query   parametrelerini yazarak “firstname” degeri “Eric” olan
    rezervasyon oldugunu test   edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200  oldugunu ve “Eric” ismine sahip
    en az bir booking oldugunu test edin
     */
    @Test
    public void test01(){
        // 1- Url hazirlama
        specHerokuApp.pathParam("pp1","booking").queryParam("firstname","Eric");

        // 2- Expected Data hazirlama
        // 3- Response Kaydetme
        Response response = given().spec(specHerokuApp).get("/{pp1}");
        response.prettyPrint();

        // 4- Assert
        response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(1));


    }
}

package API_Testing.Day04;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;


public class C2_Get_SoftAssertIleExpectedDataTesti {
    /*
    C16_Get_SoftAssertIleExpectedDataTesti
        http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body
        {
        "status": "success",
        "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
        },
        "message": "Successfully! Record has been fetched."
        }

     */

    @Test
    public void test01(){
        // 1- Endpoint hazirlama
        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected Data olusturma
        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expData = new JSONObject();
        expData.put("status","success");
        expData.put("data", data);
        expData.put("message","Successfully! Record has been fetched.");

        // 3- Response gonderme
        Response response = given().when().get(url);

        // 4- Assert islemi yapma
        // NOT : Testng olmadan softAssert yapamayiz !!!
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonPath = response.jsonPath();

        // softAssert`te kosul siralamasi (actual,expected)
        assertEquals(jsonPath.get("status"),expData.get("status"));
        assertEquals(jsonPath.get("data.id"),expData.getJSONObject("data").get("id"));
        assertEquals(jsonPath.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        assertEquals(jsonPath.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));
        assertEquals(jsonPath.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
        assertEquals(jsonPath.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
        assertEquals(jsonPath.get("message"),expData.get("message"));

        softAssert.assertAll("Test Tamamlandi");










    }

}

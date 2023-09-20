package API_Testing.Day06;

import baseUrlPackage.BaseUrl_Dummy;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testdatas.DummyData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C2_Get_DeSerialization extends BaseUrl_Dummy {
/*
    http://dummy.restapiexample.com/api/v1/employee/3 url'ine bir GET
    request gonderdigimizde donen response'un status code'unun 200,
    content Type'inin application/json ve body'sinin asagidaki gibi
    oldugunu test edin.

    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
 */
    @Test
    public void get01(){
        // 1- Url hazirlama
        specDummy.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

        // 2- ExpData hazirlama
        DummyData dummyData = new DummyData();
        HashMap<String,Object> expData = dummyData.expDataBodyOlusturmaMap();

        // 3- Response olusturma
        Response response = given().spec(specDummy).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
        HashMap<String,Object> resMap = response.as(HashMap.class);

        // 4- Assertion
        assertEquals(dummyData.statusCode,response.getStatusCode());
        assertEquals(dummyData.contentType,response.getContentType());

        assertEquals(expData.get("status"),resMap.get("status"));
        assertEquals(expData.get("message"),resMap.get("message"));

        assertEquals(((Map)(expData.get("data"))).get("id"),((Map)(resMap.get("data"))).get("id"));
        assertEquals(((Map)(expData.get("data"))).get("employee_name"),((Map)(resMap.get("data"))).get("employee_name"));
        assertEquals(((Map)(expData.get("data"))).get("employee_salary"),((Map)(resMap.get("data"))).get("employee_salary"));
        assertEquals(((Map)(expData.get("data"))).get("employee_age"),((Map)(resMap.get("data"))).get("employee_age"));
        assertEquals(((Map)(expData.get("data"))).get("profile_image"),((Map)(resMap.get("data"))).get("profile_image"));




    }

}

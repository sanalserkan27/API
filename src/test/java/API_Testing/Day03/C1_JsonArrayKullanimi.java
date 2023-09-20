package API_Testing.Day03;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_JsonArrayKullanimi {

    @Test
    public void jsonArrayOlustumaTest() {

    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }
     */
        JSONObject cepTel = new JSONObject();

        cepTel.put("type","iPhone");
        cepTel.put("number","0123-4567-8888");

        JSONObject evTel = new JSONObject();

        evTel.put("type","home");
        evTel.put("number","0123-4567-8910");

        JSONArray phoneNumbers = new JSONArray();
        phoneNumbers.put(0,cepTel);
        phoneNumbers.put(1,evTel);

        JSONObject adress = new JSONObject();
        adress.put("streetAddress","naist street");
        adress.put("city","Nara");
        adress.put("postalCode","630-0192");

        JSONObject reqBody = new JSONObject();
        reqBody.put("firstName","John");
        reqBody.put("lastName","doe");
        reqBody.put("age","26");
        reqBody.put("address",adress);
        reqBody.put("phoneNumbers",phoneNumbers);

        System.out.println(reqBody);




    }
}

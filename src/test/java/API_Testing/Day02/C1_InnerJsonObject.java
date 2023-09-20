package API_Testing.Day02;

import org.json.JSONObject;
import org.junit.Test;

public class C1_InnerJsonObject {
    /*
        Asagidaki JSON Objesini olusturup konsolda yazdirin.
        {
        “firstname”:“Jim”, “additionalneeds”:“Breakfast”, “bookingdates”:
        {
        “checkin”:“2018-01-01”,
        “checkout”:“2019-01-01”
        },
        “totalprice”:111, “depositpaid”:true, “lastname”:“Brown”
        }
     */

    @Test
    public void test01(){
        JSONObject outerJsonObject = new JSONObject();
        JSONObject innerJsonObject = new JSONObject();

        // Ic ice JSONObject`lerde ilk once inner object olusturulur.
        // Sonrasinda Outer object olusturulur.
        innerJsonObject.put("checkin","2018-01-01");
        innerJsonObject.put("checkout","2019-01-01");

        // Ana JSON objemizi olustururken key, value degerleri yazilir.
        // Icinde inner olan key`in value`su inner obje olacaktir
        outerJsonObject.put("firstname","Jim");
        outerJsonObject.put("additionalneeds","Breakfast");
        outerJsonObject.put("bookingdates",innerJsonObject);
        outerJsonObject.put("totalprice",111);
        outerJsonObject.put("depositpaid",true);
        outerJsonObject.put("lastname","Brown");

        System.out.println(outerJsonObject);


    }

}

package API_Testing.Day01;

import org.json.JSONObject;
import org.junit.Test;

public class C4_JsonObjectOlusturma {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
    “title”:“Ahmet”,
    “body”:“Merhaba”,
    “userId”:1
    }
     */

    @Test
    public void jsonObjesiOlusturma() {
        JSONObject ilkjsonObject = new JSONObject();

        ilkjsonObject.put("title", "Ahmet");
        ilkjsonObject.put("body", "Merhaba");
        ilkjsonObject.put("userId", 1);

        System.out.println("Ilk Json objesi : " + ilkjsonObject);
    }

}

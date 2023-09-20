package testdatas;

import java.util.HashMap;

public class DummyData {
    public int statusCode = 200;
    public String contentType = "application/json";

    public HashMap dataBodyOlusturmaMap(){
        /*
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
        HashMap<String,Object> data = new HashMap<>();
        data.put("id",3.0);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000.0);
        data.put("employee_age",66.0);
        data.put("profile_image","");

        return data;
    }
    public HashMap expDataBodyOlusturmaMap(){

        HashMap<String,Object> expData = new HashMap<>();
        expData.put("status","success");
        expData.put("data",dataBodyOlusturmaMap());
        expData.put("message","Successfully! Record has been fetched.");

        return expData;
    }


}

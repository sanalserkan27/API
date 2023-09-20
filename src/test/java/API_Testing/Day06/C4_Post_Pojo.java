package API_Testing.Day06;

import baseUrlPackage.BaseUrl_HerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.HerokuAppExpectedDataPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C4_Post_Pojo extends BaseUrl_HerokuApp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ali",
                        "lastname" : “Bak",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body = Expected Data
                        {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

    @Test
    public void post01(){
        // 1- Url ve reqBody Olusturma
        specHerokuApp.pathParams("pp1","booking");

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-06-01","2021-06-10");

        BookingPojo reqBody = new BookingPojo("Ali","Bak",500,false,bookingDatesPojo,"wi-fi");

        // 2- expected Data olusturma
        HerokuAppExpectedDataPojo expData = new HerokuAppExpectedDataPojo(24,reqBody);

        // 3- Response kaydetme
        Response response = given().spec(specHerokuApp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");

        HerokuAppExpectedDataPojo resPojo = response.as(HerokuAppExpectedDataPojo.class);

        // 4- Assert
        assertEquals(expData.getBooking().getFirstname(),resPojo.getBooking().getFirstname());
        System.out.println(expData.getBooking().getFirstname());
        System.out.println(resPojo.getBooking().getFirstname());
        assertEquals(expData.getBooking().getLastname(),resPojo.getBooking().getLastname());
        assertEquals(expData.getBooking().getTotalprice(),resPojo.getBooking().getTotalprice());
        assertEquals(expData.getBooking().isDepositpaid(),resPojo.getBooking().isDepositpaid());
        assertEquals(expData.getBooking().getBookingdates().getCheckin(),resPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expData.getBooking().getBookingdates().getCheckout(),resPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expData.getBooking().getAdditionalneeds(),resPojo.getBooking().getAdditionalneeds());



    }
}

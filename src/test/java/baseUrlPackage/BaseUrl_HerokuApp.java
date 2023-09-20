package baseUrlPackage;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;


public class BaseUrl_HerokuApp {

    protected RequestSpecification specHerokuApp;

    @BeforeTest
    public void setUp(){
        specHerokuApp = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();


    }
}

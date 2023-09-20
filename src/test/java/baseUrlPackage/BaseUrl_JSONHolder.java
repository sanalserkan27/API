package baseUrlPackage;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseUrl_JSONHolder {

    // BaseUrl olustururken

    protected RequestSpecification specJSONHolder;

    @BeforeTest
    public void setUp() {

        specJSONHolder = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .build();


    }


}

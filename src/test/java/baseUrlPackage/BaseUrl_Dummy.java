package baseUrlPackage;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrl_Dummy {
    protected RequestSpecification specDummy;

    @Before
    public void setUp(){
        specDummy = new RequestSpecBuilder()
                .setBaseUri("http://dummy.restapiexample.com")
                .build();
    }
}

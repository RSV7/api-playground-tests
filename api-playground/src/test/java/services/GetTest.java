package services;

import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

public class GetTest extends BaseTest{

    @Test
    public void getAllServices() {
        when().
                get(baseUrl + endpoints.getString("services_endpoint")).
        then().
                statusCode(200);
    }

    @Test
    public void getSpecifiedService() {
        when().
                get(baseUrl + endpoints.getString("services_endpoint") + "/21").
        then().
                statusCode(200).
                body("id", is(21)).
                body("name", equalTo("Appliance Outlet"));
    }

    @Test
    public void getAllServicesSkipSomeOfThem() {
        when().
                get(baseUrl + endpoints.getString("services_endpoint") + "?$skip=17").
                then().
                statusCode(200).
                body("data.id", hasItems(18, 19, 20, 21));
    }
}

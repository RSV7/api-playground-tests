package utilities;

import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

public class GetTest extends BaseTest{

    @Test
    public void getVersion() {
        when().
                get(baseUrl + endpoints.getString("version_endpoint")).
        then().
                statusCode(200).
                body("version", is("1.1.0"));
    }

    @Test
    public void getHealthCheck() {
        when().
                get(baseUrl + endpoints.getString("healthcheck_endpoint")).
        then().
                statusCode(200).
                body("readonly", equalTo(false)).
                body("documents.products", equalTo(51957)).
                body("documents.stores", equalTo(1561)).
                body("documents.categories", equalTo(4307));
    }
}

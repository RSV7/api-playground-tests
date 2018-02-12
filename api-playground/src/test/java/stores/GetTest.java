package stores;

import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

public class GetTest extends BaseTest{

    @Test
    public void getAllStores() {
        when().
                get(baseUrl + endpoints.getString("stores_endpoint")).
        then().
                statusCode(200);
    }

    @Test
    public void getSpecifiedStore() {
        when().
                get(baseUrl + endpoints.getString("stores_endpoint") + "/18").
        then().
                statusCode(200).body("services.id", hasItems(1, 2, 3, 4, 7)).
                body("services.name", hasItems("Geek Squad Services", "Best Buy Mobile"));
    }
}

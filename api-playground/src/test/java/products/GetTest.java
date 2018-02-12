package products;

import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetTest extends BaseTest{

    @Test
    public void getAllProducts() {
        when().
                get(baseUrl + endpoints.getString("products_endpoint")).
        then().
                statusCode(200);
    }

    @Test
    public void getAllProductsWithLimitResult() {
        when().
                get(baseUrl + endpoints.getString("products_endpoint") + "?$limit=3").
        then().
                statusCode(200).
                body("limit", is(3));
    }

    @Test
    public void getSpecifiedProduct() {
        when().
                get(baseUrl + endpoints.getString("products_endpoint") + "/43900").
        then().
                statusCode(200).
                body("name", equalTo("Duracell - AAA Batteries (4-Pack)")).
                body("type", equalTo("HardGood")).
                body("price", is(5.49f)).
                body("upc", equalTo("041333424019")).
                body("shipping", is(0));
    }
}

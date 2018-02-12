package categories;

import org.testng.annotations.Test;
import utils.BaseTest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class GetTest extends BaseTest{

    @Test
    public void getAllCategories() {
        when().
                get(baseUrl + endpoints.getString("categories_endpoint")).
        then().
                statusCode(200);
    }

    @Test
    public void getAllCategoriesWithLimitResult() {
        when().
                get(baseUrl + endpoints.getString("categories_endpoint") + "?$limit=10").
        then().
                statusCode(200).
                body("limit", is(10));
    }

    @Test
    public void getSpecifiedCategory() {
        when().
                get(baseUrl + endpoints.getString("categories_endpoint") + "/abcat0107000").
        then().
                statusCode(200).
                body("name", equalTo("TV & Home Theater Accessories"));
    }
}

package products;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Product;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class PostTest extends BaseTest{

    @Test
    public void postSpecifiedProduct() {
        Product product = new Product();
        product.setName(test_product1.getString("name"));
        product.setType(test_product1.getString("type"));
        product.setPrice(Double.parseDouble(test_product1.getString("price")));
        product.setShipping(Integer.parseInt(test_product1.getString("shipping")));
        product.setUpc(test_product1.getString("upc"));
        product.setDescription(test_product1.getString("description"));
        product.setManufacturer(test_product1.getString("manufacturer"));
        product.setModel(test_product1.getString("model"));
        product.setUrl(test_product1.getString("url"));
        product.setImage(test_product1.getString("image"));

        String s = baseUrl + endpoints.getString("products_endpoint");

        given()
                .body(product.toString())
        .when()
                .contentType(ContentType.JSON).post(baseUrl + endpoints.getString("products_endpoint"))
        .then()
                .statusCode(201);


    }
}

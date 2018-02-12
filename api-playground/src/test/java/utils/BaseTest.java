package utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class BaseTest {

    public static Config config = ConfigFactory.load("localhost.conf").getConfig("api-playground");

    public static Config endpoints = config.getConfig("localhost");
    public static String baseUrl = endpoints.getString("baseUrl");

    public static Config testProducts = config.getConfig("test_products");
    public static Config test_product1 = testProducts.getConfig("product_1");
}


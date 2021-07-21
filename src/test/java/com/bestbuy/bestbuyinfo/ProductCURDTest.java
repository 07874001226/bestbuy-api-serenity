package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ProductCURDTest extends TestBase {
    static String name = "oppo" + TestUtils.getRandomValue();
    static String type = "mobile";
    static double price = 10.50;
    static String upc = "219372";
    static double shipping = 10.48;
    static String description = "opp mobile";
    static String manufacturer = "opp store";
    static String model =  "String";
    static String url = "String";
    static String image = "String";

    @Steps
    ProductSteps productSteps;
    @Title("This will get a products list")
    @Test
    public void test001() {

        productSteps.getAllProducts().log().all().statusCode(200);

    }

    @Title("This will create a new products")
    @Test
    public void test002() {

        productSteps.createProducts(name, type, price, shipping, upc, description, manufacturer, model, url, image).statusCode(201).extract().response()
                .body().jsonPath().getLong("id");

    }


    @Title("This will get products by id")
    @Test
    public void test003() {
       productSteps.getProductById(150115).statusCode(200).log().all();


    }

    @Title("This test will update the product  by existing id")
    @Test
    public void test004(){

        name = name + "_Updated";
        type = type;

        productSteps.updateProducts(150115,name, type).statusCode(200).log().all();


    }
    @Title("This will delete a new products")
    @Test
    public void test005() {
        productSteps.deleteProducts(150115).statusCode(404).log().all();

    }
}


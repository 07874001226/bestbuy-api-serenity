package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ServicesCURDTest extends TestBase {
    static String name = "Samsung Services" + TestUtils.getRandomValue();


    @Steps
    ServicesSteps servicesSteps;
    @Title("This will get a Services list")
    @Test
    public void test001() {

        servicesSteps.getAllServices().log().all().statusCode(200);

    }

    @Title("This will create a new services")
    @Test
    public void test002() {

        servicesSteps.createServices(name).statusCode(201).extract().response().body().jsonPath();

    }


    @Title("This will get services by id")
    @Test
    public void test003() {
        servicesSteps.getServicesById(6).statusCode(200).log().all();


    }

    @Title("This test will update the services  by existing id")
    @Test
    public void test004(){

        name = name + "_Updated";

        servicesSteps.updateServices(6,name).statusCode(200).log().all();


    }
    @Title("This will delete a new services")
    @Test
    public void test005() {
        servicesSteps.deleteServices(21).statusCode(404).log().all();

    }
}

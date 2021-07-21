package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.awt.datatransfer.FlavorTable;

@RunWith(SerenityRunner.class)
public class StoresCURDTest extends TestBase {
    static String name = "ipad" ;
    static String type = "tablet";
    static String address = "12";
    static String address2 = "wembley";
    static String city = "London";
    static String state = "abcd";
    static String zip = "String";
    static int lat = 0;
    static int lng = 0;
    static String hours = "String";

    @Steps
    StoresSteps storesSteps;

    @Title("This will get a store list")
    @Test
    public void test001() {

        storesSteps.getAllStores().log().all().statusCode(200);

    }

    @Title("This will create a new stores")
    @Test
    public void test002() {

        storesSteps.createStores(name, type, address, address2, city, state, zip, lat, lng, hours).log().all().statusCode(201);

    }


    @Title("This will get stores by id")
    @Test
    public void test003() {
        storesSteps.getStoresById(18).statusCode(200).log().all();


    }

    @Title("This test will update the stores  by existing id")
    @Test
    public void test004() {


        storesSteps.updateStores(6, name, type).statusCode(200).log().all();


    }

    @Title("This will delete a new stores")
    @Test
    public void test005() {
        storesSteps.deleteStores(19).statusCode(404).log().all();

    }
}

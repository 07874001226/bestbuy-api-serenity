package com.bestbuy.bestbuyinfo;

import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CatrgoriesCURDTest extends TestBase {
    static String name = "Speaker" + TestUtils.getRandomValue();
    static String id = "abcd1234" +TestUtils.getRandomValue();


    @Steps
    CategoriesSteps categoriesSteps;
    @Title("This will get a Categories list")
    @Test
    public void test001() {

        categoriesSteps.getAllCategories().log().all().statusCode(200);

    }

    @Title("This will create a new categories")
    @Test
    public void test002() {

        categoriesSteps.createCategories(name,id).statusCode(201).extract().response().body().jsonPath();

    }


    @Title("This will get Categories by id")
    @Test
    public void test003() {
        categoriesSteps.getCategoriesById("abcat0100000").statusCode(200).log().all();


    }

    @Title("This test will update the categories  by existing id")
    @Test
    public void test004(){

        name = name + "_Updated";
        id = id + "_Updated";


        categoriesSteps.updateCategories(name,"abcat0020001").statusCode(200).log().all();


    }
    @Title("This will delete a new categories")
    @Test
    public void test005() {
        categoriesSteps.deleteCategories("abcat0020004").statusCode(404).log().all();

    }
}

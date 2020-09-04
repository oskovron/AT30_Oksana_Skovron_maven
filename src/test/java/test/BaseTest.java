package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    SoftAssert softAssert;

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
    }

    @AfterMethod
    public void closeup(){
        softAssert.assertAll();
    }
}

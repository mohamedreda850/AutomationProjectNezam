package Tests;

import Pages.P01_LoginPage;
import Pages.P02_landingPage;
import Pages.P03_CartPage;
import Utilities.Utilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Set;

import static DriverManager.DriverManager.*;

public class TC02_LandingTest  {

    private Set<Cookie> cookies;
    private SoftAssert softAssert;
@BeforeClass
public void login() throws IOException {
setupDriver("edge");
getDriver().manage().window().maximize();
getDriver().get(Utilities.getPropertyValue("URL"));
new P01_LoginPage(getDriver()).loginSteps(Utilities.getJSONData
                ("validLoginData","username")
        ,Utilities.getJSONData("validLoginData","password"));
cookies =  Utilities.getAllCookies(getDriver());
}
@BeforeMethod
    public void restoreSession() throws IOException {
    getDriver().get(Utilities.getPropertyValue("URL"));
    Utilities.restoreSession(getDriver(),cookies);
    getDriver().get(Utilities.getPropertyValue("HomePageUrl"));
    getDriver().navigate().refresh();
    }
@Test
    public void addProductToCartTC(){
    softAssert=new SoftAssert();
    String[] productDetails =
             new P02_landingPage(getDriver()).clickOnAddToCart().getProductDetails();
    new P02_landingPage(getDriver()).clickOnCartIcon();
    softAssert.assertTrue(new P03_CartPage(getDriver()).verifyLable(productDetails[0]));
    softAssert.assertTrue(new P03_CartPage(getDriver()).verifyprice(productDetails[1]));
    softAssert.assertAll();
}
@AfterMethod
    public void quit(){
    quitDriver();
}
@AfterClass
    public void removeSet(){
    quitDriver();
}
}

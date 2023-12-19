package Tests;

import DriverManager.DriverManager;
import Listenres.IInvockedMethodListenresClass;
import Listenres.Retry;
import Pages.P01_LoginPage;
import Utilities.Utilities;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DriverManager.DriverManager.*;

@Listeners({IInvockedMethodListenresClass.class })

public class TC01_LoginTest  {

    @BeforeMethod
    public void setup() throws IOException {
        setupDriver("edge");
        getDriver().manage().window().maximize();
        getDriver().get(Utilities.getPropertyValue("URL"));
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("verify that the user can login with valid email and pass")
    @Test(priority = 1,retryAnalyzer = Retry.class)
    public void validLoginTC() throws IOException {

        new P01_LoginPage(getDriver())
                .enterUsername(Utilities.getJSONData("validLoginData","username"))
                .enterpassword(Utilities.getJSONData("validLoginData","password"))
                .clickOnLoginButton();
        Utilities.tackeScreenshot(getDriver(),"validLoginTC");
        Assert.assertFalse(new P01_LoginPage(getDriver())
                .assertLoginTCS
                        (Utilities.getPropertyValue("HomePageUrl")));
    }
    @Test(priority = 2)
    public void invalidLoginWithWrongUsernameTC() throws IOException {

        new P01_LoginPage(getDriver())
                .enterUsername(Utilities.getJSONData("invalidLoginData","wrong_username"))
                .enterpassword(Utilities.getJSONData("validLoginData","password"))
                .clickOnLoginButton();
        Utilities.tackeScreenshot(getDriver(),"invalidLoginWithWrongUsernameTC");

        Assert.assertFalse(new P01_LoginPage(getDriver())
                .assertLoginTCS
                        (Utilities.getPropertyValue("HomePageUrl")));
    }
    @Test(priority = 3)
    public void validLoginWithWrongPasswordTC() throws IOException {

        new P01_LoginPage(getDriver())
                .enterUsername(Utilities.getJSONData("invalidLoginData","username"))
                .enterpassword(Utilities.getJSONData("invalidLoginData","wrong_password"))
                .clickOnLoginButton();
        Utilities.tackeScreenshot(getDriver(),"validLoginWithWrongPasswordTC");
        Assert.assertFalse(new P01_LoginPage(getDriver())
                .assertLoginTCS
                        (Utilities.getPropertyValue("HomePageUrl")));
    }

    @AfterMethod
    public void quit(){
        quitDriver();
    }

}

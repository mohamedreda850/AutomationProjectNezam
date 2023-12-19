package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private WebDriver driver;
    public P01_LoginPage(WebDriver driver){
        this.driver = driver;
    }
   private final By userName = By.id("user-name");
   private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    public P01_LoginPage enterUsername(String username){
        //new WebDriverWait(driver, Duration.ofSeconds(50)).until()
        Utilities.sendData(driver,userName,username);
        return this;
    }
    public P01_LoginPage enterpassword(String pass){
        Utilities.sendData(driver,password,pass);
        return this;
    }
    public P02_landingPage clickOnLoginButton(){
        Utilities.clickingOnElement(driver,loginButton);
        return new P02_landingPage(driver);
    }
    public boolean assertLoginTCS(String expectedValue){
        return driver.getCurrentUrl().equals(expectedValue);
    }
    public P02_landingPage loginSteps(String user , String pass){
        enterUsername(user);
        enterpassword(pass);
        clickOnLoginButton();
        return new P02_landingPage(driver);

    }
}


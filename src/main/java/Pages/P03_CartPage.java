package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    private final By sauceLabsBackPackProuductLable = By.id("item_4_title_link");
    private final By sauceLabsBackPackProuductPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
    WebDriver driver;
    public P03_CartPage(WebDriver driver){
        this.driver =driver;
    }
    public String getSauceLabsBackPackProuductLable(){
        return Utilities.getText(driver,sauceLabsBackPackProuductLable);

    }
    public String getSauceLabsBackPackProuductprice(){
        return Utilities.getText(driver,sauceLabsBackPackProuductPrice);

    }
    public Boolean verifyLable(String lable){
        return getSauceLabsBackPackProuductLable().equals(lable);
    }
    public Boolean verifyprice(String price){
        return getSauceLabsBackPackProuductprice().equals(price);
    }
}

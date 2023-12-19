package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_landingPage {
    private WebDriver driver;
    public P02_landingPage(WebDriver driver){
        this.driver=driver;
    }
    private final By cartIcon=By.className("shopping_cart_link");
    private final By sauceLabsBackPackProuductLable = By.id("item_4_title_link");
    private final By sauceLabsBackPackProuductPrice = By.xpath("(//div[@class='inventory_item_price'])[1]");
    private final By addToCartButtonForSauceLabsBackPackProuduct =By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory '])[1]");
    public P02_landingPage clickOnAddToCart(){
        Utilities.clickingOnElement(driver , addToCartButtonForSauceLabsBackPackProuduct);
        return this;
    }
    public String[] getProductDetails(){
        return new String[]{
                getSauceLabsBackPackProuductLable(),getSauceLabsBackPackProuductprice()
        };
    }
    public String getSauceLabsBackPackProuductLable(){
        return Utilities.getText(driver,sauceLabsBackPackProuductLable);

    }
    public String getSauceLabsBackPackProuductprice(){
        return Utilities.getText(driver,sauceLabsBackPackProuductPrice);

    }
    public P03_CartPage clickOnCartIcon(){
      Utilities.clickingOnElement(driver,cartIcon);
      return new P03_CartPage(driver);
    }

}

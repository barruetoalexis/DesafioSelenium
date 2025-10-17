package pageobjects.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.driver.DriverManager;

public class AddItemToCartModal {
     private By addFirstItem = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
     private By cartButton = By.className("shopping_cart_link");
     private By cartList = By.className("cart_list");
     private By item = By.xpath(".//*[contains(text(), 'Sauce Labs Backpack')]");

     public void AddFirstItem(){
         DriverManager.getDriver().findElement(this.addFirstItem).click();
         DriverManager.getDriver().findElement(this.cartButton).click();
     }

     public String ItemIn(){
         WebElement cart = DriverManager.getDriver().findElement(this.cartList);
         return cart.findElement(this.item).getText();
     }
}

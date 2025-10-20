package pageobjects.cart;

import org.openqa.selenium.By;
import utils.driver.DriverManager;

public class AddItemToCart {
     private By addFirstItem = By.xpath("(//button[contains(text(),'Add to cart')])[1]");
     private By cartButton = By.className("shopping_cart_link");

     public void AddFirstItem(){
         DriverManager.getDriver().findElement(this.addFirstItem).click();
         DriverManager.getDriver().findElement(this.cartButton).click();
     }
}

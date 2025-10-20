package pageobjects.cart;

import models.ItemInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.driver.DriverManager;


public class CartInfo {

    private By cartList = By.className("cart_list");

    public ItemInfo getItemFromName(String inputName){
        WebElement cart = DriverManager.getDriver().findElement(cartList);
        String name = cart.findElement(By.xpath(inputName)).getText();
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setName(name);
        return itemInfo;
    }
}

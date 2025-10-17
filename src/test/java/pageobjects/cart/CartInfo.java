package pageobjects.cart;

import models.ItemInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.driver.DriverManager;

public class CartInfo {

    public ItemInfo getItemFromName(String inputname){
        String name = DriverManager.getDriver().findElement(By.xpath(inputname)).getText();
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setName(name);
        return itemInfo;
    }

}

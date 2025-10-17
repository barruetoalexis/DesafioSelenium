package pageobjects.orderproducts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.driver.DriverManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class OrderProductsModal {
    private By selectOrder = By.cssSelector(".product_sort_container");
    private By productsList = By.xpath("//div[contains(@class, 'inventory_list')]//*[contains(@class, 'inventory_item_price')]");
    private String maxPriceString = "";
    private String minPriceString = "";
    private double maxPrice = 0;
    private double minPrice = 0;

    public void OrderHightoLow(){
        Select selectOrder = new Select(DriverManager.getDriver().findElement(this.selectOrder));
        selectOrder.selectByContainsVisibleText("Price (high to low)");
    }

    public void CheckHightoLow(){
        List<WebElement> precios = DriverManager.getDriver().findElements(productsList);
        for (WebElement x : precios){
            maxPriceString = precios.getFirst().getText();
            minPriceString = precios.getLast().getText();
        }

        maxPriceString = maxPriceString.replace("$", "");
        minPriceString = minPriceString.replace("$", "");

        maxPrice = Double.parseDouble(maxPriceString);
        minPrice = Double.parseDouble(minPriceString);

        assertThat(maxPrice).isGreaterThan(minPrice);

        }
    }


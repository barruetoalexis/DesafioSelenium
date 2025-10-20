package pageobjects.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.driver.DriverManager;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class ProductsModal {
    private By selectOrder = By.cssSelector(".product_sort_container");
    private By productsPrices = By.xpath("//div[contains(@class, 'inventory_list')]//*[contains(@class, 'inventory_item_price')]");

    public void OrderHightoLow(){
        Select selectOrder = new Select(DriverManager.getDriver().findElement(this.selectOrder));
        selectOrder.selectByContainsVisibleText("Price (high to low)");
    }

    public void CheckHightoLow(){
        List<WebElement> precios = DriverManager.getDriver().findElements(productsPrices);
        String maxPriceString = precios.getFirst().getText().replace("$", "");
        String minPriceString = precios.getLast().getText().replace("$", "");
        assertThat(Double.parseDouble(maxPriceString)).isGreaterThan(Double.parseDouble(minPriceString));

        }
    }


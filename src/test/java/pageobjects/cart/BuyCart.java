package pageobjects.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.driver.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyCart {
    private By checkoutButton = By.id("checkout");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zipCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By alertFinish = By.xpath(".//*[contains(text(), 'Thank you for your order!')]");


    public void checkoutInformation(String firstName, String lastName, String zipCode){
        DriverManager.getDriver().findElement(this.checkoutButton).click();
        DriverManager.getDriver().findElement(this.firstName).sendKeys(firstName);
        DriverManager.getDriver().findElement(this.lastName).sendKeys(lastName);
        DriverManager.getDriver().findElement(this.zipCode).sendKeys(zipCode);
        DriverManager.getDriver().findElement(this.continueButton).click();
        DriverManager.getDriver().findElement(this.finishButton).click();
    }

    public void checkOrderComplete(String phrase){
        DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(this.alertFinish));
        String messageOutput = DriverManager.getDriver().findElement(this.alertFinish).getText();
        assertThat(messageOutput).isEqualTo(phrase);
    }
}

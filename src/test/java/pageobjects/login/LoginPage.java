package pageobjects.login;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.driver.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;
public class LoginPage {

    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By submitButton = By.id("login-button");
    private By wordLoginCheck = By.xpath("//span[contains(text(), 'Products')]");
    private By wordFalseLoginCheck = By.xpath(
            ("//form//*[contains(., 'Epic sadface: Sorry, this user has been locked out.')]"));


    public void login(String userName, String password){
        DriverManager.getDriver().findElement(inputUsername).sendKeys(userName);
        DriverManager.getDriver().findElement(inputPassword).sendKeys(password);
        DriverManager.getDriver().findElement(submitButton).click();
    }

    public void checkLogin(String word){
        String wordCheck = DriverManager.getDriver().findElement(this.wordLoginCheck).getText();
        assertThat(word).isEqualTo(wordCheck);
    }

    public void checkFalseLogin(String word){
        String wordCheck = DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(this.wordFalseLoginCheck)).getText();
        assertThat(word).isEqualTo(wordCheck);
    }

}

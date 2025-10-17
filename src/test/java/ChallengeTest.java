import org.junit.jupiter.api.Test;
import pageobjects.cart.AddItemToCartModal;
import pageobjects.login.LoginPage;
import pageobjects.navigate.Navigate;
import pageobjects.orderproducts.OrderProductsModal;
import utils.driver.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;


public class ChallengeTest extends BaseWebTest{

    //Global Var
    String url = "https://www.saucedemo.com/";

    // Variables Script 1
    String username = "standard_user";
    String password = "secret_sauce";
    String wordCheckLogin = "Products";
    String itemCheck = "Sauce Labs Backpack";

    // Variables Script 2
    String userBlocked = "locked_out_user";
    String passwordBlocked = "secret_sauce";
    String wordErrorCheckLogin = "Epic sadface: Sorry, this user has been locked out.";

    @Test
    public void FirstScriptTest(){
        //Login
        Navigate navigate = new Navigate();
        navigate.NavigateToEspecificPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(username, password);
        loginpage.checkLogin(wordCheckLogin);

        // Agregar primer item de la lista al carro.
        AddItemToCartModal addItem = new AddItemToCartModal();
        addItem.AddFirstItem();

        // Comprobar que el item "Sauce Labs Backpack" existe en el carro
        assertThat(addItem.ItemIn()).isEqualTo(itemCheck);

        DriverManager.quit();
    }
    @Test
    public void SecondScriptTest(){
        //Login con userBlocked
        Navigate navigate = new Navigate();
        navigate.NavigateToEspecificPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(userBlocked, passwordBlocked);
        loginpage.checkFalseLogin(wordErrorCheckLogin);
    }

    @Test
    public void ThirdScriptTest(){
        //Login
        Navigate navigate = new Navigate();
        navigate.NavigateToEspecificPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(username, password);
        loginpage.checkLogin(wordCheckLogin);

        //Order products high to low
        OrderProductsModal orderProductsModal = new OrderProductsModal();
        orderProductsModal.OrderHightoLow();

        // Check high to low
        orderProductsModal.CheckHightoLow();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

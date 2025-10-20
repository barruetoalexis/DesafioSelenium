import org.junit.jupiter.api.Test;
import pageobjects.cart.AddItemToCart;
import pageobjects.cart.BuyCart;
import pageobjects.cart.CartInfo;
import pageobjects.login.LoginPage;
import pageobjects.navigate.Navigate;
import pageobjects.products.ProductsModal;
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

    // Variables Script 4
    String firstName = "Maximo";
    String lastName = "Peñas";
    String zipCode = "464128";
    String alertComplete = "Thank you for your order!";

    @Test
    public void FirstScriptTest(){
        //Login
        Navigate navigate = new Navigate();
        navigate.NavigateToEspecificPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(username, password);
        loginpage.checkLogin(wordCheckLogin);

        // Agregar primer item de la lista al carro.
        AddItemToCart addItem = new AddItemToCart();
        addItem.AddFirstItem();

        // Comprobar que el item "Sauce Labs Backpack" existe en el carro
        CartInfo cartInfo = new CartInfo();
        String item = cartInfo.getItemFromName(".//*[contains(text(), 'Sauce Labs Backpack')]").getName();
        assertThat(item).isEqualTo(itemCheck);

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
        ProductsModal productsModal = new ProductsModal();
        productsModal.OrderHightoLow();

        // Check high to low
        productsModal.CheckHightoLow();
    }
    @Test
    public  void FourthScriptTest(){
        //Login
        Navigate navigate = new Navigate();
        navigate.NavigateToEspecificPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(username, password);
        loginpage.checkLogin(wordCheckLogin);

        //Agregar primer item al cart
        AddItemToCart addItem = new AddItemToCart();
        addItem.AddFirstItem();

        //Checkout information
        BuyCart buyCart = new BuyCart();
        buyCart.checkoutInformation(firstName, lastName, zipCode);

        //Assert
        buyCart.checkOrderComplete(alertComplete);
    }
}

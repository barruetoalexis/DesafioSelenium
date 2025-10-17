package pageobjects.navigate;

import utils.driver.DriverManager;

public class Navigate {


    public void NavigateToEspecificPage(String url){
        DriverManager.getDriver().get(url);
    }
}

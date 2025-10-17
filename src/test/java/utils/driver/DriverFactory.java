package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public enum DriverFactory {
    CHROME{
        @Override
        public WebDriver createDriver(){
            return new ChromeDriver();
        }
    },

    EDGE{
        @Override
        public WebDriver createDriver(){
            return new EdgeDriver();
        }
    };

    public abstract WebDriver createDriver();

}

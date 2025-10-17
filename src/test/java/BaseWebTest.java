import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.driver.DriverFactory;
import utils.driver.DriverManager;


public abstract class BaseWebTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String DEFAULT_BROWSER = "CHROME";


    @BeforeEach
    public void setup() {
        driver = DriverFactory.valueOf(DEFAULT_BROWSER).createDriver();
        DriverManager.setDriver(driver);

    }
}

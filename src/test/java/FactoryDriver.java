import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import page.MyListener;

import java.util.concurrent.TimeUnit;

public class FactoryDriver {

    protected WebDriver driver;


    @Before
    public void startUp() {
        String browserType = System.getProperty("browser");


        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();

//            driver = WebDriverManager.chromedriver().create();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
//            WebDriverEventListener listener = new MouseListener();
            MyListener listener = new MyListener();
            eventDriver.register(listener);
        }
        else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = WebDriverManager.edgedriver().create();
        }
        else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
            driver = WebDriverManager.firefoxdriver().create();

        }

    }

    @After
    public void cleanUp(){
        driver.quit();
    }
}

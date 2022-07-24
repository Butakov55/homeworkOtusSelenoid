package driver;

import driver.ChromWebDriver;
import driver.FireFoxWebDriver;
import driver.OperaWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class FactoryDriver {

    private String browserType = System.getProperty("browser");

    public EventFiringWebDriver getWebDriver() {
        switch (this.browserType) {
            case "chrome": {
                return new EventFiringWebDriver(new ChromWebDriver().setUpWebDriver());
            }
            case "firefox": {
                return new EventFiringWebDriver(new FireFoxWebDriver().setUpWebDriver());
            }
            case "opera": {
                return new EventFiringWebDriver(new OperaWebDriver().setUpWebDriver());
            }
            default:

                System.out.println("отсутствует указанный драйвер");
        }
        return null;
    }
}
//
//        if (browserType.equalsIgnoreCase("chrome")) {
//            WebDriverManager.chromedriver().setup();
//                        driver = new ChromeDriver();
//
////            driver = WebDriverManager.chromedriver().create();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            driver.manage().window().maximize();
//
//            EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
////            WebDriverEventListener listener = new MouseListener();
//            MyListener listener = new MyListener();
//            eventDriver.register(listener);
//        }
//        else if (browserType.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            driver = WebDriverManager.edgedriver().create();
//        }
//        else if (browserType.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
////            driver = new FirefoxDriver();
//            driver = WebDriverManager.firefoxdriver().create();
//
//        }
//
//    }

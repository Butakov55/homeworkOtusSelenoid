package driver;

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

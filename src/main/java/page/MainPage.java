package page;

import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainPage extends BasePage<MainPage> {
private static final String PATH = "/";

    public MainPage(EventFiringWebDriver driver) {
        super(driver, PATH);
    }
}

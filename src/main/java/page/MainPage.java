package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MainPage extends BasePage<MainPage> {
private static final String PATH = "/";

    public MainPage(WebDriver driver) {
        super(driver, PATH);
    }
}

import driver.FactoryDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import page.MainPage;
import listeners.MyListener;

public class Hooks {
    protected EventFiringWebDriver driver;

    @Before
    public void setUp() {
        driver = new FactoryDriver().getWebDriver();
        driver.register(new MyListener());
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
    }

    @After
    public void Exit(){
    driver.quit();
}
}

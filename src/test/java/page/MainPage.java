package page;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private WebDriver driver;
    private static final String SITE = System.getProperty("base.url");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite(){
        driver.get(SITE);
    }
}

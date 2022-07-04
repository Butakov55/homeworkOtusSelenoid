package page;

import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private final String SITE = "https://otus.ru";

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite(){
        driver.get(SITE);
    }
}

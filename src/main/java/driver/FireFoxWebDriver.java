package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FireFoxWebDriver implements InterWebDriver {


    @Override
    public WebDriver setUpWebDriver() {
        WebDriver driver = WebDriverManager.firefoxdriver().create();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
}
}

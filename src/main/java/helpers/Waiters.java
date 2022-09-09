package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters<T> {
    protected WebDriver driver;
    private WebDriverWait wait;

    public Waiters(WebDriver driver) {
        this.driver = driver;
    }

    public T waitForCondition(ExpectedCondition condition) {
        wait = new WebDriverWait(driver, 10);
        wait.until(condition);
        return (T) this;
    }
}

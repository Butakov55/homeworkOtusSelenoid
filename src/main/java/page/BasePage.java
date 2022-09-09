package page;


import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage <T> {

    protected WebDriver driver;
    protected Waiters waiter;
    protected Actions action;
    private String pathName;
    private static final String HOST = System.getProperty("base.url");

    public BasePage(WebDriver driver, String pathName) {
        this.driver = driver;
        this.pathName = pathName;
        this.waiter = new Waiters(driver);
        this.action = new Actions(driver);
    }

    public T openSite() {
        driver.get(HOST + (T)this.pathName);
        return (T)this;
    }

}

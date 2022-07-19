package components;

import listeners.MyListener;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import helpers.Waiters;

import static org.junit.Assert.assertNotNull;

public abstract class BaseComponent<T> {
    protected EventFiringWebDriver driver;
    protected Waiters waiter;
    protected Actions action;
    protected MyListener myListener;



    public BaseComponent(EventFiringWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.waiter = new Waiters(driver);
        this.action = new Actions(driver);
        this.myListener = new MyListener();



    }

    public T webElementShouldBeVisible(WebElement webElement) {
        assertNotNull(waiter.waitForCondition(ExpectedConditions.visibilityOf(webElement)));
        return (T)this;
    }
}
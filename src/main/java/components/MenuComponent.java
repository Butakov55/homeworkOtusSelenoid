package components;

import listeners.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

public class MenuComponent extends BaseComponent {

    @FindBy(xpath = "//p[@class='header2-menu__item-text' and contains(text(), 'Курсы')]")
    private WebElement topBarCourse;

    @FindBy(css = "a[title='Корпоративные курсы']")
    private WebElement course;

    @FindBy(css = ".lessons__new-item-title")
    private List<WebElement> listCompanyCourse;

    @FindBy(css = ".transitional-main__event-text")
    private WebElement programmer;

    public MenuComponent(WebDriver driver) {
        super(driver);
    }


    public void goToPageCompanyCourseActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(topBarCourse).build().perform();
        actions.click(course).build().perform();

    }

    public void goToProgrammer() {
        Actions actions = new Actions(driver);
        MyListener myListener = new MyListener();
        myListener.beforeClickOn(programmer, driver);
        actions.click(programmer).build().perform();
        myListener.afterClickOn(programmer, driver);
    }



}

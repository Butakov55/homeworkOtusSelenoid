package components;

import listeners.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;

public class MenuComponent extends BaseComponent {

    @FindBy(xpath = "//p[@class='header2-menu__item-text' and contains(text(), 'Курсы')]")
    private WebElement topBarCourse;

    @FindBy(xpath = "//div[@class='header2-menu__subdropdown-wrapper js-menu-subdropdown-wrapper']//a[contains(text(),'Корпоративные курсы')]//div")
    private WebElement course;

    @FindBy(css = ".lessons__new-item-title")
    private List<WebElement> listCompanyCourse;

    @FindBy(css = ".transitional-main__event-text")
    private WebElement programmer;

    public MenuComponent(EventFiringWebDriver driver) {
        super(driver);
    }

//    public void getTextCompanyCourse() {
//        List<String> links = new ArrayList<>();
//        for (int i = 0; i < listCompanyCourse.size(); i++) {
//            links.add(listCompanyCourse.get(i).getText());
//            System.out.println(links);
//        }
//    }

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

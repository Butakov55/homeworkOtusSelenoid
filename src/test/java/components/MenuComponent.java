package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;

public class MenuComponent extends BaseComponent {

    @FindBy(xpath = "(//div[@class='header2-menu__item-wrapper'])[1]")
    private WebElement topBarCourse;

    @FindBy(xpath = "//div[@class='header2-menu__subdropdown-wrapper js-menu-subdropdown-wrapper']//a[contains(text(),'Корпоративные курсы')]//div")
    private WebElement course;

    @FindBy(xpath = "(//div[@class='header2-menu__subdropdown'])[14]//a")
    private List<WebElement> listCompanyCourse;

    @FindBy(xpath = "(//div[@class='nav__items course-categories__nav']//a)[1]")
    private WebElement programmer;

    public MenuComponent(EventFiringWebDriver driver) {
        super(driver);
    }

    public void getTextCompanyCourse() {
        List<String> links = new ArrayList<>();
        for (int i = 0; i < listCompanyCourse.size(); i++) {
            links.add(listCompanyCourse.get(i).getText());
            System.out.println(links);
        }
    }

    public void goToPageCompanyCourseActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(topBarCourse).build().perform();
        actions.click(course).build().perform();

    }

    public void goToProgrammer() {
        programmer.click();
    }



}

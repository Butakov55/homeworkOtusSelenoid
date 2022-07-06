package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.MouseListener;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyCoursePage {
    private WebDriver driver;

    public CompanyCoursePage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "//div[@class='lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse']")
    private List<WebElement> allCoursesOfPage;


    @FindBy(xpath = "(//div[@class='lessons__new-item-bg-right'])[1]")
    private WebElement firstCourseOfPage;

    public List<String> getTextCompanyCourseOfPage(List<WebElement> courses) {
        List<String> links = new ArrayList<>();
        for (int i = 0; i < this.allCoursesOfPage.size(); i++) {
            links.add(this.allCoursesOfPage.get(i).getText());
            System.out.println(links);
        }
        return links;
    }

    public void filterListCourses(String nameCourse) {
        List<String> courselinks = new ArrayList<>();
        courselinks = getTextCompanyCourseOfPage(allCoursesOfPage);
        var namesCouses = courselinks.stream()
                .filter(i -> i.equals(nameCourse))
                .collect(Collectors.toList());

        System.out.println(namesCouses);
    }

    public MenuComponent filterCourse(String nameCourse) {
        filterListCourses(nameCourse);
        return new MenuComponent(driver);
    }

    public void clickFirstCourse() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstCourseOfPage));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//        firstCourseOfPage.click();
    }

}

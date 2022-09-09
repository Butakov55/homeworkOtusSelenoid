package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyCourseComponent {
    private WebDriver driver;

    public CompanyCourseComponent(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = ".js-ellipse")
    private List<WebElement> allCoursesOfPage;

    @FindBy(css = ".lessons__new-item-start")
    private List<WebElement> datesStartCourse;


    @FindBy(xpath = ".//div[normalize-space()= 'Infrastructure as a code']")
    private WebElement firstCourseOfPage;

    public List<helpers.CompanyCourse> companyCourse = new ArrayList<>();


    public List<String> getTextCompanyCourseOfPage(List<WebElement> courses) {
        List<String> links = new ArrayList<>();
        for (WebElement cours : courses) {
            links.add(cours.getText());
            System.out.println(links);
        }
        return links;
    }

    public void filterListCourses(String nameCourse) {
        List<String> courselinks = getTextCompanyCourseOfPage(allCoursesOfPage);
        var namesCouses = courselinks.stream()
                .filter(i -> i.equals(nameCourse))
                .collect(Collectors.toList());

        System.out.println(namesCouses);
    }


    public CourseComponent clickFirstCourse() {
        firstCourseOfPage.click();
        return new CourseComponent(driver);
    }

}

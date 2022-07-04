package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public List<String> getTextCompanyCourseOfPage(List<WebElement> courses) {
        List<String> links = new ArrayList<>();
        for (int i = 0; i < this.allCoursesOfPage.size(); i++) {
            links.add(this.allCoursesOfPage.get(i).getText());
            System.out.println(links);
        }
        return links;
    }

    public void filterListCourses() {
        List<String> courselinks = new ArrayList<>();
        courselinks = getTextCompanyCourseOfPage(allCoursesOfPage);
        var namesCouses = courselinks.stream()
                .filter(i -> i.equals("Spark Developer"))
                .collect(Collectors.toList());

        System.out.println(namesCouses);
    }

    public MenuComponent filterCourse() {
        filterListCourses();
        return new MenuComponent(driver);
    }

}

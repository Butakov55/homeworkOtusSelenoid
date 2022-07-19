package components;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class CompanyCourseComponent {
    private WebDriver driver;

    public CompanyCourseComponent(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(xpath = "//div[@class='lessons__new-item-title  lessons__new-item-title_with-bg js-ellipse']")
    private List<WebElement> allCoursesOfPage;

    @FindBy(css = ".lessons__new-item-start")
    private List<WebElement> datesStartCourse;


    @FindBy(xpath = "(//div[@class='lessons__new-item-bg-right'])[1]")
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


    public void clickFirstCourse() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstCourseOfPage));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
//        firstCourseOfPage.click();
    }

}

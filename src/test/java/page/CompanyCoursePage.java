package page;

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

public class CompanyCoursePage {
    private WebDriver driver;

    public CompanyCoursePage(WebDriver webDriver) {
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
        for (int i = 0; i < courses.size(); i++) {
            links.add(courses.get(i).getText());
            System.out.println(links);
        }
        return links;
    }

    public List<String> getTextCompanyCourseOfPageReplaceSomeMoments(List<WebElement> courses) {
        List<String> links = new ArrayList<>();
        for (WebElement cours : courses) {
            if (cours.getText().equals("О дате старта будет объявлено позже")) {

            } else {
                links.add(cours.getText().substring(2));
            }

            System.out.println(links);
        }
        return links;
    }

    private List<Date> formatDates(List<String> dates) throws ParseException {
        List<Date> parseDates = new ArrayList<>();
        for (String date : dates) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM", new Locale("ru"));
            parseDates.add(simpleDateFormat.parse(date));
        }
        return parseDates;
    }

    public void filterListCourses(String nameCourse) {
        List<String> courselinks = new ArrayList<>();
        courselinks = getTextCompanyCourseOfPage(allCoursesOfPage);
        var namesCouses = courselinks.stream()
                .filter(i -> i.equals(nameCourse))
                .collect(Collectors.toList());

        System.out.println(namesCouses);
    }


    public void filterStartDatesCourses() throws ParseException {
        List<String> courseStartDates;
        courseStartDates = getTextCompanyCourseOfPageReplaceSomeMoments(datesStartCourse);
        System.out.println(formatDates(courseStartDates));
    }

//    public void filterStartDatesCourses() throws ParseException {
//        List<String> courselinks;
//        courselinks = getTextCompanyCourseOfPageReplaceSomeMoments(datesStartCourse);
//        CompanyCourse companyCourse = new CompanyCourse(name, datesStartCourse);
//        CompanyCourse.add(getTextCompanyCourseOfPageReplaceSomeMoments(datesStartCourse));
//
//        System.out.println(formatDates(CompanyCourse));
//        Date MaxOrMinDate = course.stream()
//                .reduce((CompanyCourse firstDate, CompanyCourse secondDate)-> firstDate.getDates() > secondDate.getDates() ? firstDate : secondDate).get();
//
//
//    }


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

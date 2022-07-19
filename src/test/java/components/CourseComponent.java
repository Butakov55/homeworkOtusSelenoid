package components;

import helpers.Search;
import helpers.ISearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CourseComponent extends BaseComponent<CourseComponent>{

    private List<CourseEnter> courseEnter = new ArrayList<>();

    public CourseComponent(EventFiringWebDriver driver) {
        super(driver);
    }


    String xpathForName = ".//div[contains(@class, 'lessons__new-item-title')]";

    String xpathForStartDate = ".//div[@class = 'lessons__new-item-start'] | .//div[@class = 'lessons__new-item-courses']//following-sibling::div[@class = 'lessons__new-item-time']";

    private String getCourseBlockName(WebElement courseBlock) {
        webElementShouldBeVisible(courseBlock);
        return courseBlock.findElement(By.xpath(xpathForName)).getText().trim();

    }

    private String getCourseBlockStartDate(WebElement courseBlock) {
        webElementShouldBeVisible(courseBlock);
        return courseBlock.findElement(By.xpath(xpathForStartDate)).getText().trim();
    }

    private String getCourseBlockLink(WebElement courseBlock) {
        webElementShouldBeVisible(courseBlock);
        return courseBlock.getAttribute("href").trim();
    }

    private boolean isDateWithYear(String date) {
        Pattern pattern = Pattern.compile(".*?((\\d{4})(?:\\s*года)).*");
        Matcher matcher = pattern.matcher(date);
        return matcher.find();
    }

    private String parseYear(String date) {
        Pattern pattern = Pattern.compile("(\\d{4})");
        Matcher matcher = pattern.matcher(date);
        return matcher.find() ? matcher.group(1) : null;
    }

    private LocalDate parseStringToDate(String date) {
        String newDate = null;
        String year;

        Pattern pattern = Pattern.compile("(\\d{1,2}\\s*[а-я]+)");
        Matcher matcher = pattern.matcher(date);

        if (matcher.find())
        {
            newDate = matcher.group(1);
        }

        year = isDateWithYear(date) ? parseYear(date) : Integer.toString(LocalDate.now().getYear());
        newDate += " " + year;

        DateTimeFormatter dateTimeFormatter =
                DateTimeFormatter
                        .ofPattern("dd MMMM uuuu")
                        .withLocale(new Locale("ru"));
        return LocalDate.parse(newDate, dateTimeFormatter);
    }


    private WebElement searchCourseByName(String courseName) {
        List<WebElement> courseNames = driver.findElements((By.xpath(xpathForName)));
        ISearch<WebElement> finder = new Search<>(courseNames, (WebElement course) -> course.getText().contains(courseName));
        return finder.searchFirstElement().findElement(By.xpath("./../.."));
    }

    private List<WebElement> searchCoursesWithDate() {
        List<WebElement> courseStartDates = driver.findElements((By.xpath(xpathForStartDate)));
        ISearch<WebElement> search = new Search<>(courseStartDates, (WebElement courseDate) -> courseDate.getText().matches("([^В].*?\\d{1,2}\\s*[а-я]+)"));
        return search.searchAllElements().stream().map(course -> course.findElement(By.xpath("./../.."))).collect(Collectors.toList());

    }

    private void parseСourseBlocks(List<WebElement> courseBlockWebElems) {
        for (WebElement courseBlockWebElem : courseBlockWebElems) {
            String name = getCourseBlockName(courseBlockWebElem);
            String startDateText = getCourseBlockStartDate(courseBlockWebElem);
            LocalDate startDate = parseStringToDate(startDateText);
            CourseEnter courseBlockEntity = new CourseEnter(name, startDate);
            courseEnter.add(courseBlockEntity);
        }
    }

    public void searchCourseByMaxDate() {
        List<WebElement> w = searchCoursesWithDate();
        parseСourseBlocks(w);
        CourseEnter courseBlock = courseEnter.stream()
                .reduce((CourseEnter firstDate, CourseEnter secondDate)-> firstDate.getStartDate().isBefore(secondDate.getStartDate()) ? firstDate : secondDate).get();
        System.out.println(courseBlock.getName());
    }
    }

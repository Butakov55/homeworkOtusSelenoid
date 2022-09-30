package tests;

import components.CourseComponent;
import components.CompanyCourseComponent;
import components.MenuComponent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import page.MainPage;

import java.net.MalformedURLException;
import java.net.URI;

public class HomeworkOneTest {
    protected WebDriver driver;


    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName",  System.getProperty("browser"));
        capabilities.setCapability("browserVersion",  System.getProperty("browserVersion"));
        capabilities.setCapability("enableVNC", true);
        driver = new RemoteWebDriver(
                URI.create("http://127.0.0.1:4444/wd/hub").toURL(),
                capabilities
        );

        driver.manage().window().maximize();

    }

    @After
    public void exit(){
        driver.quit();
    }

    @Test
    public void actionsAndFilters() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        MenuComponent menuComponent = new MenuComponent(driver);
//        //движение мыши и выбор курса с помощью Actions
        menuComponent.goToPageCompanyCourseActions();
        CompanyCourseComponent companyCoursePage  = new CompanyCourseComponent(driver);
        //метод фильтра по названию курса
        companyCoursePage.filterListCourses("Spark Developer");
        companyCoursePage.clickFirstCourse();
    }


    @Test
    public void choiseMaxDateCourse() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMax();
    }
    @Test
    public void choiseMinDateCourse() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMin();
    }
}

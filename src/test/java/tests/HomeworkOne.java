package tests;

import components.CourseComponent;
import components.CompanyCourseComponent;
import components.MenuComponent;
import driver.FactoryDriver;
import listeners.MyListener;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import page.MainPage;

public class HomeworkOne {
    protected EventFiringWebDriver driver;

    @Before
    public void setUp() {
        driver = new FactoryDriver().getWebDriver();
        driver.register(new MyListener());
        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();
    }

    @After
    public void exit(){
        driver.quit();
    }

    @Test
    public void actionsAndFilters() {
        MenuComponent menuComponent = new MenuComponent(driver);
//        //движение мыши и выбор курса с помощью Actions
        menuComponent.goToPageCompanyCourseActions();
        CompanyCourseComponent companyCoursePage  = new CompanyCourseComponent(driver);
        //метод фильтра по названию курса
        companyCoursePage.filterListCourses("Spark Developer");
        companyCoursePage.clickFirstCourse();
    }


    @Test
    public void backLight() {
        MenuComponent menuComponent = new MenuComponent(driver);
        //подсветка элемента
        menuComponent.goToProgrammer();
    }

    @Test
    public void choiseMaxDateCourse() {
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMax();
    }
    @Test
    public void choiseMinDateCourse() {
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMin();
    }
}

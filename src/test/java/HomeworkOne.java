import components.CourseComponent;
import components.CompanyCourseComponent;
import components.MenuComponent;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.WebDriver;

public class HomeworkOne extends BaseTest {

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

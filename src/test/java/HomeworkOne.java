import components.CourseComponent;
import components.CompanyCourseComponent;
import components.MenuComponent;


public class HomeworkOne extends Hooks {

    @org.junit.Test
    public void ActionsAndFilters() {
        MenuComponent menuComponent = new MenuComponent(driver);
//        //движение мыши и выбор курса с помощью Actions
        menuComponent.goToPageCompanyCourseActions();
        CompanyCourseComponent companyCoursePage  = new CompanyCourseComponent(driver);
        //метод фильтра по названию курса
        companyCoursePage.filterListCourses("Spark Developer");
        companyCoursePage.clickFirstCourse();
    }


    @org.junit.Test
    public void BackLight() {
        MenuComponent menuComponent = new MenuComponent(driver);
        //подсветка элемента
        menuComponent.goToProgrammer();
    }

    @org.junit.Test
    public void ChoiseMaxDateCourse() {
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMax();


    }
    @org.junit.Test
    public void ChoiseMinDateCourse() {
        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourseActions();
        CourseComponent courseBlockComponent = new CourseComponent(driver);
        courseBlockComponent.searchCourseByMin();


    }
}

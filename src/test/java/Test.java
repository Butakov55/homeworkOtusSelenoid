import page.CompanyCoursePage;
import page.MenuComponent;

public class Test extends Hooks {

    @org.junit.Test
    public void TestOne() {
        MenuComponent menuComponent = new MenuComponent(driver);
        //движение мыши и выбор курса с помощью Actions
        menuComponent.goToPageCompanyCourseActions();
        CompanyCoursePage companyCoursePage  = new CompanyCoursePage(driver);
        //метод фильтра по названию курса
        companyCoursePage.filterCourse("Spark Developer");
        companyCoursePage.clickFirstCourse();
    }

    @org.junit.Test
    public void TestTwo() {
        MenuComponent menuComponent = new MenuComponent(driver);
        //подсветка элемента
        menuComponent.goToProgrammer();

    }
}

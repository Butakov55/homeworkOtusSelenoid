import page.CompanyCoursePage;
import page.MainPage;
import page.MenuComponent;

public class Test extends FactoryDriver {

    @org.junit.Test
    public void OtusTest() {

        MainPage mainPage = new MainPage(driver);
        mainPage.openSite();

        MenuComponent menuComponent = new MenuComponent(driver);
        menuComponent.goToPageCompanyCourse();
        CompanyCoursePage companyCoursePage  = new CompanyCoursePage(driver);
        companyCoursePage.filterCourse();
        companyCoursePage.clickFirstCourse();
    }
}

package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class serviceCommonPage {
    protected WebDriver driver;
    protected MyListener myListener;

    public serviceCommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        myListener = new MyListener();
    }
}

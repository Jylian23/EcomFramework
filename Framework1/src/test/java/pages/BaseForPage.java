package pages;

import org.openqa.selenium.WebDriver;

public class BaseForPage {

    //Variables
    protected WebDriver driver;

    //Constructor
    public BaseForPage(WebDriver driver){
        this.driver = driver;
    }
}

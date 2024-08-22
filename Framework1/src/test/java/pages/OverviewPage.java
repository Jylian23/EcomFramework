package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage extends BaseForPage {

    //Elements
    @FindBy(id = "finish")
    public WebElement finishBtn;

    //Constructor
    public OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}

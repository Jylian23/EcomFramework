package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage extends BaseForPage {

    //Elements in this page
    @FindBy(id = "continue")
    private WebElement continueBtn;

    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    @FindBy(id = "postal-code")
    private WebElement postCodeInput;

    //Constructor
    public InformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Method for easier filling information boxes
    public OverviewPage checkOut (String firstName,String lastName,String postCode){
        firstNameInput.click();
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);

        lastNameInput.click();
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);

        postCodeInput.click();
        postCodeInput.clear();
        postCodeInput.sendKeys(postCode);

        continueBtn.click();

        return new OverviewPage(driver);
    }
}

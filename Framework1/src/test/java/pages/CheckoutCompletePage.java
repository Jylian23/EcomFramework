package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends BaseForPage{

    //Elements in this page
    @FindBy(className = "complete-text")
    private WebElement successfulOrder;

    @FindBy(id = "back-to-products")
    public WebElement backHomeBtn;

    //Constructor
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Methods/actions - is this order successful
    public boolean isOrderSuccessful(){
        if (successfulOrder.getText().equals("Your order has been dispatched, " +
                "and will arrive just as fast as the pony can get there!")){
            return true;
        }else {
            return false;
        }
    }
}

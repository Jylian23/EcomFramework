package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BaseForPage {

    //Elements in this page
    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingCartBtn;

    @FindBy(className = "shopping_cart_badge")
    private WebElement shoppingCartBadge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOutBtn;

    @FindBy(xpath = "//*[@class='inventory_item']")
    public List<WebElement> productsList;

    //Constructor
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Methods/actions - for adding item in the cart
    public void addItemToTheCart(int productIndex) {
        WebElement itemToBeAdded = productsList.get(productIndex)
                .findElement(By.xpath(".//*[contains(@id, 'add-to-cart-sauce-labs-')]"));
        itemToBeAdded.click();
    }

    //for removing item from the cart
    public void removeItemFromTheCart(int productIndex) {
        WebElement itemToBeRemoved = productsList.get(productIndex)
                .findElement(By.xpath(".//*[contains(@id, 'remove-sauce-labs-')]"));
        itemToBeRemoved.click();
    }

    //Check's if the cart is empty (when it is really empty) it trows us NoSuchElementException, so we catch it here
    public boolean shoppingCartBadgeIsDisplayed() {
        try {
            return shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }

    //Gets the number of items in our cart
    public int getItemCountInCart() {
        return Integer.parseInt(shoppingCartBadge.getText());
    }

    //LogOut Method - With explicit wait
    public void LogOut() {
        menuBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(logOutBtn));
        logOutBtn.click();
    }
}

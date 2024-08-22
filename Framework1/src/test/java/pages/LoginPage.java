package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LoginPage extends BaseForPage{

    //Elements
    @FindBy(id = "user-name")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//*[@class='error-message-container error']")
    private WebElement errorLoginMsg;

    @FindBy(xpath = "//*[@class='error-message-container error']")
    private List<WebElement> msgs;
//noo hordcore data
    private final static String CORRECT_USER = "standard_user";

    private final static String CORRECT_PASS = "secret_sauce";

    //Constructor
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private List<String> msg (){
        List<String> allMsg = new ArrayList<>();
        allMsg.add("Epic sadface: Username and password do not match any user in this service");
        allMsg.add("Epic sadface: Username is required");
        allMsg.add("Epic sadface: Password is required");
        allMsg.add("Epic sadface: Sorry, this user has been locked out.");

        return allMsg;
    }

    //Methods/actions - login method
    public ProductPage logIn(String userName, String password){

        userInput.click();
        userInput.clear();
        userInput.sendKeys(userName);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        loginBtn.click();

        return new ProductPage(driver);
    }

    //Automatic successful login method
    public ProductPage logIn(){

        userInput.click();
        userInput.clear();
        userInput.sendKeys(CORRECT_USER);

        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(CORRECT_PASS);

        loginBtn.click();
        return new ProductPage(driver);
    }

    //Method for - Error messages after try to log in
    public boolean errorMsg(){
        if (msg().contains(errorLoginMsg.getText())) {
            System.out.println("Error message that was displayed is: " + errorLoginMsg.getText());
            return true;
        }else {
            return false;
        }
    }
}



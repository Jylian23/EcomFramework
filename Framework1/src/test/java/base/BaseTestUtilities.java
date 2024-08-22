package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTestUtilities extends DataProviders {

    //Variables that we will use for our "base"
    public WebDriver driver;

    private String browser , targetUrl;

    private int implicitWait;

    protected SoftAssert softAssert = new SoftAssert();

    protected final static String BASE_LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    protected final static String PRODUCT_PAGE_URL = BASE_LOGIN_PAGE_URL + "inventory.html";
    protected final static String YOUR_CART_PAGE_URL = BASE_LOGIN_PAGE_URL + "cart.html";
    protected final static String YOUR_INFO_PAGE_URL = BASE_LOGIN_PAGE_URL + "checkout-step-one.html";
    protected final static String OVERVIEW_PAGE_URL = BASE_LOGIN_PAGE_URL + "checkout-step-two.html";
    protected final static String CHECKOUT_COMPLETE_PAGE_URL = BASE_LOGIN_PAGE_URL + "checkout-complete.html";

    //Method to show from where and how to get our CSV file with Configurations
    private void readConfiguration(String pathToFile) {

        try {
            FileInputStream fileInputStream = new FileInputStream(pathToFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            targetUrl = properties.getProperty("url");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("wait"));
        }catch (IOException e){
            System.out.println(e);
        }
    }

    //Methods to set initialize our different drivers
    private WebDriver setUpGoogleChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return driver = new ChromeDriver();
    }
    private WebDriver setUpFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return  driver = new FirefoxDriver();
    }
    private WebDriver setUpEdgeDriver(){
        WebDriverManager.edgedriver().setup();
        return driver = new EdgeDriver();
    }

    //Method to get chose witch driver to start from our configuration file
    private void setUpDriver(){
        switch (browser){
            case "Firefox":
                driver = setUpFirefoxDriver();
                break;
            case "Google Chrome":
                driver = setUpGoogleChromeDriver();
                break;
            default:
                driver = setUpEdgeDriver();
        }
    }

    //Checks if we are in the page that we want to be comparing URLs
    public boolean correctPageIsLoaded(String expectedUrl) {
        if (driver.getCurrentUrl().equals(expectedUrl)) {
            return true;
        } else {
            return false;
        }
    }

    //Starts when we pres run to selected tests before they start executing
    @BeforeMethod
    public void setUps(){
        readConfiguration("src/test/resources/configuration.properties");
        setUpDriver();
        driver.manage().timeouts().implicitlyWait(Duration.from(Duration.ofSeconds(implicitWait)));
        driver.manage().window().maximize();
        driver.get(targetUrl);
    }

    //Stops our driver when we are finished
    @AfterMethod
    public void tearDown(){

        //I added "softAssert.asserAll()" here because it's a good practise to be in the "@AfterMethod"
        //It's in "comment" because I have to little "softAsserts" in my tests
        //That makes it better to be in the test case witch are using the softAssert methods
        //softAssert.assertAll();
        driver.quit();
    }
}

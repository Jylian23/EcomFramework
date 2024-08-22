package tests.login_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SuccessfulLoginTest extends BaseTestUtilities {

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn("standard_user", "secret_sauce");

        Assert.assertTrue(correctPageIsLoaded(PRODUCT_PAGE_URL));
    }
}

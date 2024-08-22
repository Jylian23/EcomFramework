package tests.login_tests;

import base.BaseTestUtilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class SuccessfulLoginE2E extends BaseTestUtilities {

    @Test
    public void successfulLoginLogout(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn("standard_user","secret_sauce");

        softAssert.assertTrue(correctPageIsLoaded(PRODUCT_PAGE_URL));

        productPage.LogOut();

        softAssert.assertTrue(correctPageIsLoaded(BASE_LOGIN_PAGE_URL));

        softAssert.assertAll();
    }
}


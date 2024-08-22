package tests.login_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class LockedOutUserTest extends BaseTestUtilities {

    @Test
    public void lockedUser(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.logIn("locked_out_user","secret_sauce");

        Assert.assertTrue(loginPage.errorMsg());
    }
}

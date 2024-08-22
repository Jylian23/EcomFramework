package tests.login_tests;

import base.BaseTestUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class UnsuccessfulLoginTest extends BaseTestUtilities {


    @Test(dataProvider = "wrongUsers")
    public void unsuccessfulLogins(String userName,String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn(userName,password);

        Assert.assertTrue(loginPage.errorMsg());
    }
}

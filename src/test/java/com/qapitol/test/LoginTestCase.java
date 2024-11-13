package com.qapitol.test;

import com.qapitol.base.BaseTest;
import com.qapitol.pages.LoginPage;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class LoginTestCase extends BaseTest {

    public LoginTestCase() throws FileNotFoundException {
    }
    @Test
    public void searchContext() throws FileNotFoundException {
        LoginPage lp=new LoginPage();
        lp.verifyElements();


    }

}

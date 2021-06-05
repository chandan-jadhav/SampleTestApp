package android.tc;

import android.po.HomePage;
import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Verify_AddDeleteItemFlow {

    @BeforeTest
    public void Setup() throws MalformedURLException, InterruptedException {
        AppFactory.Android_LaunchApp();
    }

    @Test(description="Verify User is able to add and delete the Item in the cart")
    public void Test_SaveContact_Android() throws InterruptedException {
    	HomePage homePage = new HomePage();
    	homePage.verifyHomePageIsDisplayed();
    	homePage.selectBackpackItem();
    	homePage.verifyItemIsAdded();
    	homePage.removeItem();
    	homePage.verifyItemIsDeleted();
    	
    }

    @AfterTest
    public void tearDown(){
        AppFactory.closeApp();
    }



}

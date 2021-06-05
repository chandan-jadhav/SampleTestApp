package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities cap;

    public static void Android_LaunchApp() throws MalformedURLException, InterruptedException {
    	cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);
        Thread.sleep(1000);
        System.out.println("Android driver is set");
        
        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();

        Thread.sleep(2000);
    }

    public static void closeApp(){
        driver.quit();
    }

}
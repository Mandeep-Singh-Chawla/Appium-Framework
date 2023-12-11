package com.sample.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;

public abstract class BaseTest {

    private ThreadLocal<AppiumDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeMethod
    public void setup(ITestContext context){
        AppiumDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("udid", "emulator-5554");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "14.0");
        caps.setCapability("appActivity", "com.google.android.youtube.HomeActivity");
        caps.setCapability("appPackage", "com.google.android.youtube");

        //Initialise Appium Driver

        try {
             driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Thread.currentThread().setName(context.getCurrentXmlTest().getName());
        driverThreadLocal.set(driver);
    }

    public AppiumDriver getDriver(){
        return driverThreadLocal.get();
    }

    @AfterMethod
    public void quitDriver() {
        driverThreadLocal.get().quit();
    }

}

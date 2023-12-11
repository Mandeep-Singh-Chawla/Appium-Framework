package com.sample;


import com.sample.pages.YoutubePage;
import io.appium.java_client.AppiumDriver;

public class PageManager {
    AppiumDriver driver;
    public PageManager (AppiumDriver driver){
        this.driver = driver;
    }

    public YoutubePage getYoutubePage() {
        return new YoutubePage(driver);
    }

}

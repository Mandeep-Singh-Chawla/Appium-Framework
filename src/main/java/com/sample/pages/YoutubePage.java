package com.sample.pages;

import com.sample.Utility;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class YoutubePage {

    public By watch = By.xpath("//android.view.ViewGroup[@content-desc=\"Watch\"]/android.view.ViewGroup");
    public By shortsWidget = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id=\"com.google.android.youtube:id/results\"]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.support.v7.widget.RecyclerView");
    public Utility utility;
    public AppiumDriver driver;

    public YoutubePage(AppiumDriver driver) {
        this.driver = driver;
        this.utility=new Utility(driver);
    }

    public void clickwatch(){
        driver.findElement(watch).click();
    }

    public void scrollTillWatch(){
        utility.scrollTillElement(watch,10);

    }

    public void swipeToShortTitle(String shortTitle){
        String xpath = "//android.view.ViewGroup[contains(@content-desc,\"__SHORTTITLE__\")]".replace("__SHORTTITLE__",shortTitle);
        By shortTitleXpath = By.xpath(xpath);
        utility.slideElementRightToLeftTillElement(shortsWidget, shortTitleXpath, 10);
    }

    public void playShortTitle(String shortTitle){
        String xpath = "//android.view.ViewGroup[contains(@content-desc,\"__SHORTTITLE__\")]".replace("__SHORTTITLE__",shortTitle);
        By shortTitleXpath = By.xpath(xpath);
        driver.findElement(shortTitleXpath).click();
    }

    public void scrollTillShortsWidget(){
        utility.scrollTillElement(shortsWidget,10);
    }
}
